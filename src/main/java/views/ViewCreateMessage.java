package views;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import appmensajes.Message;
import appmensajes.MessageDAO;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextArea;

public class ViewCreateMessage extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField authorTextField;
	
	public ViewCreateMessage(JFrame previousWindow) {
		//Window configuration
		setTitle("Create message");
		setSize(514,294);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		//Label Message
		JLabel messageLabel = new JLabel("Message:");
		messageLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		messageLabel.setBounds(31, 35, 65, 34);
		desktopPane.add(messageLabel);
		//TextArea Message
		JTextArea messageTextArea = new JTextArea();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		messageTextArea.setBorder(border);
		messageTextArea.setForeground(new Color(0, 0, 0));
		messageTextArea.setFont(new Font("Tahoma", Font.PLAIN, 10));
		desktopPane.setLayer(messageTextArea, 0);
		messageTextArea.setBounds(100, 40, 380, 79);
		desktopPane.add(messageTextArea);
		//Label Author
		JLabel authorLabel = new JLabel("Author:");
		authorLabel.setFont(authorLabel.getFont().deriveFont(authorLabel.getFont().getStyle() | Font.BOLD));
		authorLabel.setBounds(31, 128, 65, 34);
		desktopPane.add(authorLabel);
		//TextField Author
		authorTextField = new JTextField();
		authorTextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		authorTextField.setColumns(10);
		authorTextField.setBounds(100, 129, 380, 34);
		desktopPane.add(authorTextField);
		//Create button
		JButton btnNewMessage = new JButton("Create Message");
		btnNewMessage.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewMessage.setBounds(348, 189, 132, 34);
		desktopPane.add(btnNewMessage);
		//Return button
		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		returnButton.setBounds(31, 189, 132, 34);
		desktopPane.add(returnButton);
		
		//Adding a ActionListener to window
		btnNewMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Creates a new Message object and set its attributes
				Message record_message=new Message();
				record_message.setMessage(messageTextArea.getText());
				record_message.setAuthor_message(authorTextField.getText());
				//Here send the message to DAO object
				MessageDAO.createMessageDB(record_message);
				previousWindow.setVisible(true);
				dispose();
			}
		});
		
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				previousWindow.setVisible(true);
				dispose();
			}
		});
		
	}
}
