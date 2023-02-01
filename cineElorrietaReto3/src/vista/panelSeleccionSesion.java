package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class panelSeleccionSesion {

	private JFrame frame;
	private JTable tableSesion;
	private JLabel lblCantidadEntradas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelSeleccionSesion window = new panelSeleccionSesion();
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
	public panelSeleccionSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelSeleccionSesion = new JPanel();
		panelSeleccionSesion.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionSesion);
		panelSeleccionSesion.setLayout(null);
		
		JLabel lblSeleccionSesion = new JLabel("Seleccione una sesión...");
		lblSeleccionSesion.setBounds(235, 39, 223, 14);
		panelSeleccionSesion.add(lblSeleccionSesion);
		
		tableSesion = new JTable();
		tableSesion.setBounds(31, 64, 546, 167);
		panelSeleccionSesion.add(tableSesion);
		
		lblCantidadEntradas = new JLabel("Cantidad de entradas:");
		lblCantidadEntradas.setBounds(383, 252, 126, 14);
		panelSeleccionSesion.add(lblCantidadEntradas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(519, 249, 58, 20);
		panelSeleccionSesion.add(spinner);
		
		JButton btnAceptarSesion = new JButton("Aceptar");
		btnAceptarSesion.setBounds(197, 288, 89, 23);
		panelSeleccionSesion.add(btnAceptarSesion);
		
		JButton btnCancelarSesion = new JButton("Cancelar");
		btnCancelarSesion.setBounds(343, 288, 89, 23);
		panelSeleccionSesion.add(btnCancelarSesion);
	}
}
