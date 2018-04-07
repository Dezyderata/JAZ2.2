package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UserRepository implements UserRepositoryInterface{
	private static List<User> db = new ArrayList<User>();
	
	@Override
	public boolean searchForUser(String name, String psw) {
		for(User user: db){
			if(user.getName().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(psw))
				return true;
		}
		return false;
	}

	@Override
	public User getUserInformationByName(String name) {
		for(User user: db){
			if(user.getName().equalsIgnoreCase(name))
				return user;
		}
		return null;
	}

	@Override
	public void add(User user) {
		db.add(user);
		
	}

	@Override
	public int count() {
		return db.size();
	}

	@Override
	public void setPrivilages(String name) {
		for(User user:db) {
			if(user.getName().equalsIgnoreCase(name)) {
				user.setPremium(!user.isPremium());
			}
		}
	}

	@Override
	public boolean isInRepository(String name) {
		for(User user:db) {
			if(user.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	public Object returnArray() {
		return db;
	}
}
