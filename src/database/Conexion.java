package database;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion implements IConexion {
	/*
	 * Se limitan las bases de datos a las que nos podemos conectar
	 * 
	 * */
	enum BBDD {ORACLE,MySQL,H2}
	
	public static Connection conn;
	public BBDD source;
	
	/*
	 * Se prevee poder cambiar de bases de datos.
	 * */
	private Conexion() {	
		this.source = BBDD.MySQL;
	}

	public static Conexion getInstace() {
		return new Conexion();
	}

	
	@Override
	public Connection conectBBDD() throws SQLException {
		if (conn == null || conn.isClosed()) {
			switch(source) {
			case MySQL:
				conn = MySqlConexion.getConexion();
				break;
			case ORACLE:
				conn = OracleConexion.getConexion();
				break;
			case H2:
				conn = H2Conexion.getConexion();
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
