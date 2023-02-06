package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class panelSeleccionPelicula extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public panelSeleccionPelicula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionPelicula = new JLabel("Seleccione una película...");
		lblSeleccionPelicula.setBounds(47, 34, 180, 14);
		contentPane.add(lblSeleccionPelicula);
		
		JButton btnAceptarSeleccionPelicula = new JButton("Aceptar");
		btnAceptarSeleccionPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCine cines = new panelSeleccionCine();
				cines.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false); 
			}
		});
		btnAceptarSeleccionPelicula.setBounds(172, 270, 130, 23);
		contentPane.add(btnAceptarSeleccionPelicula);
		
		JButton btnCancelarSeleccionPelicula = new JButton("Cancelar");
		btnCancelarSeleccionPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionCine cines2 = new panelSeleccionCine();
				cines2.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnCancelarSeleccionPelicula.setBounds(346, 270, 142, 23);
		contentPane.add(btnCancelarSeleccionPelicula);
		
		JList list = new JList();
		list.setBounds(47, 64, 531, 160);
		contentPane.add(list);
	}
}
