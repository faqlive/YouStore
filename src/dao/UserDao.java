package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.User;

public class UserDao implements IUserDao{
	private Connection conexion;
	private ResultSet resultado;
	private PreparedStatement statement;
	
	

	public UserDao(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	@Override
	public void save(User entity) {
		try {
			statement = conexion.prepareStatement("INSERT INTO users VALUES(null,?,?,?,?)");
			statement.setString(1, entity.getMail());
			statement.setString(2, entity.getName());
			statement.setBytes(3, entity.getPass());
			statement.setDate(4,java.sql.Date.valueOf( entity.getDateup()));
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String mail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String mail) {
		User user = null;
		try {
			statement = conexion.prepareStatement("SELECT * FROM users WHERE mail=?");
			statement.setString(1, mail);
			resultado = statement.executeQuery();
			while(resultado.next()) {
				user.setId(resultado.getInt("id"));
				user.setMail(mail);
				user.setName(resultado.getString("name"));
				user.setDateup(resultado.getDate("dateup").toLocalDate());
				user.setPass(resultado.getBytes("password"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
