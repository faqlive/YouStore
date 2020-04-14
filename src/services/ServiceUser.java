package services;

import java.util.ArrayList;
import java.util.List;

import dao.IUserDao;
import dao.UserDao;
import database.Conexion;
import database.IConexion;
import model.User;

public class ServiceUser implements IServiceUser{
	
	
	@Override
	public void save(User entity) {
		IConexion conn = Conexion.getInstace();
		IUserDao userDao = new UserDao(conn.conectBBDD());
		userDao.save(entity);
		conn.disconBBDD();
		
	}

	@Override
	public void delete(String mail) {
		IConexion conn = Conexion.getInstace();
		IUserDao userDao = new UserDao(conn.conectBBDD());
		userDao.delete(mail);
		conn.disconBBDD();		
	}

	@Override
	public User get(String mail) {
		User user = null;
		IConexion conn = Conexion.getInstace();
		IUserDao userDao = new UserDao(conn.conectBBDD());
		user = userDao.get(mail);
		conn.disconBBDD();		
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		IConexion conn = Conexion.getInstace();
		IUserDao userDao = new UserDao(conn.conectBBDD());
		list= userDao.getAll();
		conn.disconBBDD();		
		return list;
	}
	
}
