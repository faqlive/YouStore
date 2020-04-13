package dao;

import java.util.List;

import model.User;

public interface IUserDao {
	public void save(User entity);
	public void delete(String mail);
	public User get(String mail);
	public List<User> getAll();
}
