package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import appmensajes.Message;
import appmensajes.MessageDAO;

public class ViewUpdateMessage extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField authorTextField;
	
	public ViewUpdateMessage(JFrame previousWindow, Message message) {
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
		JTextArea messageTextArea = new JTextArea(message.getMessage());
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
		authorTextField = new JTextField(message.getAuthor_message());
		authorTextField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		authorTextField.setColumns(10);
		authorTextField.setBounds(100, 129, 380, 34);
		desktopPane.add(authorTextField);
		//Create button
		JButton btnUpdateMessage = new JButton("Update message");
		btnUpdateMessage.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdateMessage.setBounds(348, 189, 132, 34);
		desktopPane.add(btnUpdateMessage);
		//Return button
		JButton returnButton = new JButton("Return");
		returnButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		returnButton.setBounds(31, 189, 132, 34);
		desktopPane.add(returnButton);
		
		//Adding a ActionListener to window
		btnUpdateMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				message.setMessage(messageTextArea.getText());
				message.setAuthor_message(authorTextField.getText());
				MessageDAO.updateMessageDB(message);
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
