package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserRepositoryDb {

	Connection connection;
	
	private String createTableSql = "CREATE TABLE users("
			+ "name VARCHAR(20),"
			+ "password VARCHAR(20),"
			+ "email VARCHAR(30),"
			+ "premium BOOLEAN BOOLEAN DEFAULT FALSE NOT NULL,"
			+ "admin BOOLEAN BOOLEAN DEFAULT FALSE NOT NULL,"
			+ ")";
	private String insertSql = "INSERT INTO users(name,password,email,premium,admin) VALUES (?,?,?,?,?)";
	private String selectAllSql = "SELECT * FROM users";
	private String searchForUserSql = "SELECT * FROM users WHERE name=? AND password=?";
	private String getUserInformationSql = "SELECT * FROM users WHERE name=?";
	private String updatePremiumSql = "UPDATE users SET premium=NOT premium WHERE name=?";
	private String deleteSql = "DELETE FROM users WHERE name=?";
	
	Statement createTable;
	PreparedStatement insert;
	PreparedStatement selectAll;
	PreparedStatement searchFor;
	PreparedStatement getUserInformation;
	PreparedStatement updatePremium;
	PreparedStatement delete;
	
	public UserRepositoryDb(){
		
		try {
			
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydatabase");
			createTable = connection.createStatement();
			insert = connection.prepareStatement(insertSql);
			selectAll = connection.prepareStatement(selectAllSql);
			searchFor = connection.prepareStatement(searchForUserSql);
			getUserInformation = connection.prepareStatement(getUserInformationSql);
			updatePremium = connection.prepareStatement(updatePremiumSql);
			delete = connection.prepareStatement(deleteSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateUser(String name) throws SQLException {
		updatePremium.setString(1, name);
		updatePremium.executeUpdate();
	}
	public void drop(String name) throws SQLException {
		delete.setString(1, name);
		delete.executeUpdate();
	}
	
	public List<User> getAll(){
		List<User> result = new ArrayList<User>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next()){
				result.add(returnUser(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean searchForUser(String name, String psw) throws SQLException {
		searchFor.setString(1, name);
		searchFor.setString(2, psw);
		ResultSet rs = searchFor.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	
	public User getUserInformationByName(String name) throws SQLException {
		getUserInformation.setString(1, name);
		ResultSet rs = getUserInformation.executeQuery();
		if(rs.next()) {
			return returnUser(rs);
		}else {
			return null;
		}
	}
	
	
	public User returnUser(ResultSet rs) throws SQLException {
		User result = new User();
		result.setName(rs.getString("name"));
		result.setPassword(rs.getString("password"));
		result.setEmail(rs.getString("email"));
		result.setPremium(rs.getBoolean("premium"));
		result.setAdmin(rs.getBoolean("admin"));
		return result;
		
	}	
	public void add(User user){
		try{
			insert.setString(1, user.getName());
			insert.setString(2, user.getPassword());
			insert.setString(3, user.getEmail());
			insert.setBoolean(4, user.isPremium());
			insert.setBoolean(5, user.isAdmin());
			insert.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void createTable(){
		try {
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			boolean tableExists = false;
			while(rs.next()){
				if(rs.getString("TABLE_NAME").equalsIgnoreCase("users")){
					//na chwile
					drop("admin");
					drop("Anna");
					drop("Danie");
					drop("Janek");
					drop("hhh");
					drop("Karolina");
					tableExists=true;
					break;
				}
			}
			if(!tableExists) {
				createTable.executeUpdate(createTableSql);
				User u = new User("admin", "123", "admin@admin.com", true, true);
				add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
