package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class panelSeleccionFecha {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelSeleccionFecha window = new panelSeleccionFecha();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public panelSeleccionFecha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelSeleccionFecha = new JPanel();
		panelSeleccionFecha.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionFecha);
		panelSeleccionFecha.setLayout(null);
		
		JLabel lblSeleccionFecha = new JLabel("Seleccione una fecha...");
		lblSeleccionFecha.setBounds(35, 109, 184, 14);
		panelSeleccionFecha.add(lblSeleccionFecha);
	}

}
