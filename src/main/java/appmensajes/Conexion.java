package appmensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase hace la conexion con la base de datos
 * */
public class Conexion {
	public Connection get_connection() {
		Connection conexion = null;
		try {
			conexion=DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/app_mensajes",
					"root",
					"");
			if(conexion!=null) {
				System.out.println("Conexion exitosa");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return conexion;
	}
}
