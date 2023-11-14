package appmensajes;

import java.sql.Connection;

public class Main {
	public static void main (String[] args) {
		DBConnection connectionToDB = new DBConnection();
		//try-with-resources: cierra la conexion con la base de datos automaticamente
		try(Connection cnx=connectionToDB.get_connection()){
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
