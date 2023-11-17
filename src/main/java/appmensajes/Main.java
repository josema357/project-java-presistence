package appmensajes;

import java.util.Scanner;

public class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int option=0;
		do {
			System.out.println("---------------------");
			System.out.println("Message App");
			System.out.println("1. Create Message");
			System.out.println("2. List Messages");
			System.out.println("3. Edit Message");
			System.out.println("4. Delete Message");
			System.out.println("5. Exit");
			System.out.println();
			//read option
			option=sc.nextInt();
			switch(option) {
			case 1:
				MessageService.createMessage();
				break;
			case 2:
				MessageService.listMessages();
				break;
			case 3:
				MessageService.editMessage();
				break;
			case 4:
				MessageService.deleteMessage();
				break;
			default:
				break;
			}
		}while(option!=5);
	}
}
