package domain;

public class User {

	private String name;
	private String password;
	private String email;
	private boolean premium;
	private boolean admin;
	public User() {
	}
	public User(String name, String password, String email, boolean premium, boolean admin) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.premium = premium;
		this.admin = admin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
