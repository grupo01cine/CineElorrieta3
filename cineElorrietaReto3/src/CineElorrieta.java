import java.awt.EventQueue;

import vista.Ventanas;

public class CineElorrieta {

	public CineElorrieta() {
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanas window = new Ventanas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
