package vista;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelSeleccionCine extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public panelSeleccionCine() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label labelSeleccionCine = new Label("Seleccione un cine...");
		labelSeleccionCine.setBounds(57, 102, 202, 22);
		contentPane.add(labelSeleccionCine);
		
		JComboBox comboBoxCines = new JComboBox();
		comboBoxCines.setBounds(265, 102, 246, 22);
		contentPane.add(comboBoxCines);
		
		JButton btnAceptarSeleccionCine = new JButton("Aceptar");
		btnAceptarSeleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionPelicula peliculas = new panelSeleccionPelicula();
				peliculas.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnAceptarSeleccionCine.setBounds(94, 208, 188, 23);
		contentPane.add(btnAceptarSeleccionCine);
		
		JButton btnFinalizarSesionSeleccionCine = new JButton("Finalizar sesión");
		btnFinalizarSesionSeleccionCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnFinalizarSesionSeleccionCine.setBounds(323, 208, 188, 23);
		contentPane.add(btnFinalizarSesionSeleccionCine);
	}

}
