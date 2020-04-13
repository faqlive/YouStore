package services;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
