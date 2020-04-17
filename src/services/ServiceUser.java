package services;

import dao.UserDao;
import database.Conexion;
import database.IConexion;
import generics.GenericService;
import generics.IGenericDao;
import model.User;


public class ServiceUser extends GenericService<User,String> implements IServiceUser{
	

	public ServiceUser() {
		super();

	}

	@Override
	public IGenericDao <User, String> getDao() {
		IConexion conn = Conexion.getInstace();
		return new UserDao(conn);
	}
	
}
