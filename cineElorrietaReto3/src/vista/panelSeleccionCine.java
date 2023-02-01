package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class panelSeleccionCine {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelSeleccionCine window = new panelSeleccionCine();
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
	public panelSeleccionCine() {
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
		
		JPanel panelSeleccionCine = new JPanel();
		panelSeleccionCine.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelSeleccionCine);
		panelSeleccionCine.setLayout(null);
		
		Label labelSeleccionCine = new Label("Seleccione un cine...");
		labelSeleccionCine.setBounds(57, 102, 202, 22);
		panelSeleccionCine.add(labelSeleccionCine);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(265, 102, 246, 22);
		panelSeleccionCine.add(comboBox);
		
		JButton btnAceptarSeleccionCine = new JButton("Aceptar");
		btnAceptarSeleccionCine.setBounds(193, 208, 89, 23);
		panelSeleccionCine.add(btnAceptarSeleccionCine);
		
		JButton btnCencelarSeleccionCine = new JButton("Cancelar");
		btnCencelarSeleccionCine.setBounds(323, 208, 89, 23);
		panelSeleccionCine.add(btnCencelarSeleccionCine);
	}
}
