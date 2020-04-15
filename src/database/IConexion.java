package database;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexion {
	public  Connection conectBBDD() throws SQLException;
	public  void disconBBDD();

}
