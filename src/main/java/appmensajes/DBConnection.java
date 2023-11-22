package appmensajes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class makes the connection with the database
 * */
public class DBConnection {
	private static Connection myConnection;
	private static String database=System.getenv("DATA_BASE");
	private static String userName=System.getenv("USER_NAME");
	private static String password=System.getenv("PASSWORD");
	
	private DBConnection() {
		
	}
	/**
	 * This method creates a singleton to avoid creating a new connection on each query
	 * */
	public static Connection get_connection() {
		if(myConnection==null) {
			try {
				myConnection=DriverManager.getConnection(database,userName,password);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return myConnection;
	}
	/**
	 * This function close the connection with the database
	 * */
	public static void close_connection() {
		if(myConnection != null) {
			try {
				myConnection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				myConnection=null;
			}
		}
	}
}
