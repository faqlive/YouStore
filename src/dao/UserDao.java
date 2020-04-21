package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.IConexion;
import generics.GenericDao;
import interfeces.IUserDao;
import model.User;

public class UserDao extends GenericDao implements IUserDao{
	
	private ResultSet resultado;
	private PreparedStatement statement;
	
	

	public UserDao(IConexion conexion) {
		super(conexion);

	}

	@Override
	public void save(User entity) {
		try {
			statement = conexion.prepareStatement("INSERT INTO users(mail,name,pass,dateup) VALUES(?,?,?,?)");
			statement.setString(1, entity.getMail());
			statement.setString(2, entity.getName());
			statement.setBytes(3, entity.getPass());
			statement.setDate(4,java.sql.Date.valueOf( entity.getDateup()));
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	@Override
	public void delete(String mail) {
		try {
			statement = conexion.prepareStatement("DELETE FROM users WHERE mail=?");
			statement.setString(1, mail);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	@Override
	public User get(String mail) {
		User user = new User();
		try {
			statement = conexion.prepareStatement("SELECT * FROM users WHERE mail=?");
			statement.setString(1, mail);
			resultado = statement.executeQuery();
			while(resultado.next()) {
				user.setId(resultado.getInt("id"));
				user.setMail(mail);
				user.setName(resultado.getString("name"));
				user.setDateup(resultado.getDate("dateup").toLocalDate());
				user.setPass(resultado.getBytes("pass"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> list = new ArrayList<User>();
		User user = null;
		try {
			statement = conexion.prepareStatement("SELECT * FROM users");
			resultado = statement.executeQuery();
			while(resultado.next()) {
				user = new User();
				user.setId(resultado.getInt("id"));
				user.setMail(resultado.getString("mail"));
				user.setName(resultado.getString("name"));
				user.setDateup(resultado.getDate("dateup").toLocalDate());
				user.setPass(resultado.getBytes("pass"));
				list.add(user);
			}
		}catch(SQLException e) {
			
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<User> getAllForaneKey(String fkey) {
		// TODO Auto-generated method stub
		return null;
	}

}
