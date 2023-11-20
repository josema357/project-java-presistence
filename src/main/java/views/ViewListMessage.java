package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import appmensajes.Message;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;


public class ViewListMessage extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	public ViewListMessage(JFrame previousWindow, List<Message> response) {
		//Window configuration
		setTitle("Create message");
		setSize(514,294);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		//Create a table model
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Message");
		model.addColumn("Author");
		model.addColumn("Date");
		
		//Fill the table with data
		for(Message message:response) {
			Object[] rowData= {message.getId_message(),message.getMessage(),message.getAuthor_message(),message.getDate_message()};
			model.addRow(rowData);
		}
		
		table = new JTable(model);
		table.setBounds(0, 10, 500, 201);
		
		JScrollPane scrollPane= new JScrollPane(table);	
		scrollPane.setLocation(0, 10);
		scrollPane.setSize(500, 201);
		
		desktopPane.add(scrollPane);
		
		JButton returnButton = new JButton("Return");
		returnButton.setBounds(35, 221, 85, 21);
		desktopPane.add(returnButton);
		
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				previousWindow.setVisible(true);
				dispose();
			}
		});
		
	}
}
