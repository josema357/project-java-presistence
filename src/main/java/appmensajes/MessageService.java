package appmensajes;

import java.util.Scanner;

public class MessageService {
	
	public static void createMessage() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Write a message");
		String message = sc.nextLine();
		System.out.println("Author's name");
		String name=sc.nextLine();
		//Creates a new Message object and set its attributes
		Message record_message=new Message();
		record_message.setMessage(message);
		record_message.setAuthor_message(name);
		//Here send the message to DAO object
		MessageDAO.createMessageDB(record_message);
	}
	public static void listMessages() {
		
	}
	public static void deleteMessage() {
		
	}
	public static void editMessage() {
		
	}
}
