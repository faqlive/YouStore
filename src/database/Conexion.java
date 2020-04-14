package database;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion implements IConexion {
	public static Connection conn;
	public static Conexion instaceConexion;
	
	public BBDD source;
	
	enum BBDD {ORACLE,MySQL}
	
	private Conexion() {	
		this.source = BBDD.MySQL;
	}

	public static Conexion getInstace() {
		return new Conexion();
	}

	
	@Override
	public Connection conectBBDD() {
		//TODO detecta base de datos
		if (conn == null) {
			switch(source) {
			case MySQL:
				conn = MySqlConexion.conectBBDD();
				break;
			case ORACLE:
				conn = OracleConexion.getConexion();
				break;
			default:
				conn = null;
			}
		}
		return conn;
	}

	@Override
	public void disconBBDD() {
		try {
			if (conn != null && !conn.isClosed()) {
			conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public BBDD getSource() {
		return source;
	}

	public void setSource(BBDD source) {
		this.source = source;
	}
	
}
