package appmensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase hace la conexion con la base de datos
 * */
public class DBConnection {
	public Connection get_connection() {
		Connection db_connection = null;
		try {
			db_connection=DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/app_mensajes",
					"root",
					"");
			if(db_connection!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return db_connection;
	}
}
