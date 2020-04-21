package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexion {
	
	private static Connection conn = null;

	/**
	 * Conexion on base de datos MySql
	 * */
	
	public static Connection getConexion() {
		// try (Connection connr =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root","")){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tienda","root","");		
		}catch(SQLException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
