package appmensajes;

import javax.swing.SwingUtilities;

import views.ViewMainMenu;

public class Main {
	public static void main (String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ViewMainMenu().setVisible(true);
			}
		});
	}
}
