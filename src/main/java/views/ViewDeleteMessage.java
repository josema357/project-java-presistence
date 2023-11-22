package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import appmensajes.MessageDAO;

import javax.swing.JButton;

public class ViewDeleteMessage extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField idTextField;
	public ViewDeleteMessage(JFrame previousWindow) {
		//Window configuration
		setTitle("Delete message");
		setSize(514,294);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
				
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		//Label ID message
		JLabel idLabel = new JLabel("Enter ID message");
		idLabel.setBounds(139, 101, 98, 23);
		desktopPane.add(idLabel);
		//TextField ID message
		idTextField = new JTextField();
		idTextField.setBounds(247, 101, 119, 23);
		desktopPane.add(idTextField);
		idTextField.setColumns(10);
		//Button to return to ViewMain
		JButton returnButton = new JButton("Return");
		returnButton.setBounds(35, 202, 85, 21);
		desktopPane.add(returnButton);
		//Button to delete a message
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(379, 202, 85, 21);
		desktopPane.add(deleteButton);
		
		returnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				previousWindow.setVisible(true);
				dispose();
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MessageDAO.deleteMessageDB(Integer.parseInt(idTextField.getText()));
				previousWindow.setVisible(true);
				dispose();
			}
		});
	}
}
