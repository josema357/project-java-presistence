package appmensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {
	/**
	 * This method inserts a new message into the database
	 * */
	public static void createMessageDB(Message message) {
		try (Connection connection = DBConnection.get_connection()) {
			PreparedStatement ps = null;
			try {
				String query="INSERT INTO mensajes"
						+ "(mensaje, autor_mensaje, fecha_mensaje) "
						+ "VALUES (?,?,CURRENT_TIMESTAMP)";
				ps=connection.prepareStatement(query);
				ps.setString(1, message.getMessage());
				ps.setString(2, message.getAuthor_message());
				ps.executeUpdate();
				System.out.println("Message created successfully");
				
			} catch (Exception ex) {
				System.out.println(ex);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public static void readMessageDB() {
		
	}
	public static void deleteMessageDB(int id_message) {
		
	}
	public static void updateMessageDB(Message message) {
		
	}
}
