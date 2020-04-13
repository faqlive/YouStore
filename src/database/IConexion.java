package database;

import java.sql.Connection;

public interface IConexion {
	public  Connection conectBBDD();
	public  void disconBBDD();

}
