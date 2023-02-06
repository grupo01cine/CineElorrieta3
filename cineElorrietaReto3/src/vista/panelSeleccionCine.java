package vista;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.pojos.Cliente;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class panelSeleccionCine extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> clientes;

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
		
		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelResumenCompra resumen = new panelResumenCompra();
				resumen.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnFinalizarCompra.setBounds(323, 208, 188, 23);
		contentPane.add(btnFinalizarCompra);
	}

}
