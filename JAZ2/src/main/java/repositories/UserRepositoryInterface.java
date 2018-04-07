package repositories;

import domain.User;

public interface UserRepositoryInterface {
	public boolean searchForUser(String name, String psw);
	public boolean isInRepository(String name);
	User getUserInformationByName(String name);
	void add(User user);
	int count();
	void setPrivilages(String name);
	public Object returnArray();
}
