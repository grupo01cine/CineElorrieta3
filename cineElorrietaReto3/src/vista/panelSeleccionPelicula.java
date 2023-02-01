package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class panelSeleccionPelicula {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelSeleccionPelicula window = new panelSeleccionPelicula();
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
	public panelSeleccionPelicula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelSeleccionPelicula = new JPanel();
		panelSeleccionPelicula.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionPelicula);
		panelSeleccionPelicula.setLayout(null);
		
		JLabel lblSeleccionPelicula = new JLabel("Seleccione una película...");
		lblSeleccionPelicula.setBounds(51, 102, 180, 14);
		panelSeleccionPelicula.add(lblSeleccionPelicula);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(241, 98, 291, 22);
		panelSeleccionPelicula.add(comboBox);
		
		JButton btnAceptarSeleccionPelicula = new JButton("Aceptar");
		btnAceptarSeleccionPelicula.setBounds(126, 201, 89, 23);
		panelSeleccionPelicula.add(btnAceptarSeleccionPelicula);
		
		JButton btnCancelarSeleccionPelicula = new JButton("Cancelar");
		btnCancelarSeleccionPelicula.setBounds(280, 201, 89, 23);
		panelSeleccionPelicula.add(btnCancelarSeleccionPelicula);
		
		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		btnFinalizarCompra.setBounds(430, 201, 89, 23);
		panelSeleccionPelicula.add(btnFinalizarCompra);
	}

}
