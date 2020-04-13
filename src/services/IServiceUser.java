package services;

import java.util.List;

import model.User;

public interface IServiceUser {
	public void save(User entity);
	public void delete(String mail);
	public User get(String mail);
	public List<User> getAll();

}
