package appmensajes;

import javax.swing.JFrame;

import views.ViewCreateMessage;

public class MessageService {
	
	public static void createMessage(JFrame previousWindow) {
		ViewCreateMessage windowCreate=new ViewCreateMessage(previousWindow);
		windowCreate.setVisible(true);
	}
	public static void listMessages() {
		
	}
	public static void deleteMessage() {
		
	}
	public static void editMessage() {
		
	}
}
