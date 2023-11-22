package appmensajes;

import java.util.List;

import javax.swing.JFrame;

import views.ViewCreateMessage;
import views.ViewDeleteMessage;
import views.ViewListMessage;
import views.ViewRequestId;

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
	public static void deleteMessage(JFrame previousWindow) {
		ViewDeleteMessage windowDelete=new ViewDeleteMessage(previousWindow);
		windowDelete.setVisible(true);
	}
	public static void editMessage(JFrame previousWindow) {
		ViewRequestId windowRequest=new ViewRequestId(previousWindow);
		windowRequest.setVisible(true);
	}
}
