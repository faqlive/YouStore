package database;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion implements IConexion {
	enum BBDD {ORACLE,MySQL}
	public static Connection conn;
	public BBDD source;
	
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
