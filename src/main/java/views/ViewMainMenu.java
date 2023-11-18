package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import appmensajes.MessageService;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMainMenu extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public ViewMainMenu() {
		//Window configuration
		setTitle("Main Menu");
		setSize(514,294);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		//Button to create a new message
		JButton createButton = new JButton("Create Message");
		createButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		createButton.setBounds(184, 43, 138, 31);
		desktopPane.add(createButton);
		//Button to list messages
		JButton listButton = new JButton("List Messages");
		listButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		listButton.setBounds(184, 84, 138, 31);
		desktopPane.add(listButton);
		//Button to edit a message
		JButton editButton = new JButton("Edit Message");
		editButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		editButton.setBounds(184, 125, 138, 31);
		desktopPane.add(editButton);
		//Button to delete a message
		JButton deleteButton = new JButton("Delete Message");
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		deleteButton.setBounds(184, 166, 138, 31);
		desktopPane.add(deleteButton);
		
		//Set up buttons ActionListener
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MessageService.createMessage(ViewMainMenu.this);
				dispose();
			}
		});
		listButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
