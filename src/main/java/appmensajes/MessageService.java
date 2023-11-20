package appmensajes;

import java.util.List;

import javax.swing.JFrame;

import views.ViewCreateMessage;
import views.ViewListMessage;

public class MessageService {
	
	public static void createMessage(JFrame previousWindow) {
		ViewCreateMessage windowCreate = new ViewCreateMessage(previousWindow);
		windowCreate.setVisible(true);
	}
	public static void listMessages(JFrame previousWindow) {
		List<Message> response = MessageDAO.readMessageDB();
		ViewListMessage windowList = new ViewListMessage(previousWindow, response);
		windowList.setVisible(true);
	}
	public static void deleteMessage() {
		
	}
	public static void editMessage() {
		
	}
}
