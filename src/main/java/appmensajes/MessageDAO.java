package appmensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
	/**
	 * This method inserts a new message into the database
	 * */
	public static void createMessageDB(Message message) {
		Connection connection = DBConnection.get_connection();
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
		DBConnection.close_connection();
	}
	/**
	 * This method gets messages created in the database
	 * */
	public static List<Message> readMessageDB() {
		List<Message> messagesList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection connection = DBConnection.get_connection();
			String query="SELECT * FROM mensajes";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			//Adding the messages objects to ArrayList
			while(rs.next()) {
				Message newMessage = new Message();
				newMessage.setId_message(rs.getInt("id_mensaje"));
				newMessage.setMessage(rs.getString("mensaje"));
				newMessage.setAuthor_message(rs.getString("autor_mensaje"));
				newMessage.setDate_message(rs.getString("fecha_mensaje"));
				messagesList.add(newMessage);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		DBConnection.close_connection();
		
		return messagesList;
	}
	/**
	 * This function delete a message in the database
	 * */
	public static void deleteMessageDB(int id_message) {
		PreparedStatement ps = null;
		try {
			Connection connection = DBConnection.get_connection();
			try {
				String query="DELETE FROM mensajes WHERE id_mensaje=?";
				ps=connection.prepareStatement(query);
				ps.setInt(1, id_message);
				int countRowsUpdated=ps.executeUpdate();
				if(countRowsUpdated!=0) {
					System.out.println("Successfully deleted message");
				}else {
					System.out.println("ID not found");
				}
				
				
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("Could not delete message");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		DBConnection.close_connection();
	}
	/**
	 * This function update a message in the database
	 * */
	public static void updateMessageDB(Message message) {
		PreparedStatement ps = null;
		try {
			Connection connection = DBConnection.get_connection();
			try {
				String query="UPDATE mensajes SET "
						+ "mensaje = ?, "
						+ "autor_mensaje = ?, "
						+ "fecha_mensaje = CURRENT_TIMESTAMP "
						+ "WHERE mensajes.id_mensaje = ?";
				ps=connection.prepareStatement(query);
				ps.setString(1, message.getMessage());
				ps.setString(2, message.getAuthor_message());
				ps.setInt(3, message.getId_message());
				ps.executeUpdate();
				System.out.println("Message updated successfully");
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("Could not update message");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
