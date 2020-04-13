package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConexion {
	private static Connection conn = null;
	
	public static Connection getConexion() {
		  try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            Connection  conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhot:1521:SID","USER","PASS");
	        } catch (SQLException | ClassNotFoundException ex) {
	            System.out.println("Error en la conexión de la base de datos");
	        }
		return conn;
	}
}
