package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelSeleccionSesion extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PanelSeleccionSesion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSesiones = new JLabel("Seleccione una sesión...");
		lblSesiones.setBounds(238, 23, 179, 14);
		contentPane.add(lblSesiones);
		
		JTable tableSesiones = new JTable();
		tableSesiones.setBounds(10, 43, 596, 227);
		contentPane.add(tableSesiones);
		
		JButton btnAceptarSesion = new JButton("Aceptar");
		btnAceptarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnAceptarSesion, "Ha seleccionado la película -meter título o info-", "Confirmación", 1);
				panelSeleccionCine cines = new panelSeleccionCine();
				cines.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnAceptarSesion.setBounds(211, 287, 89, 23);
		contentPane.add(btnAceptarSesion);
		
		JButton btnSesion = new JButton("Cancelar");
		btnSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSeleccionPelicula pelis = new panelSeleccionPelicula();
				pelis.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnSesion.setBounds(350, 287, 89, 23);
		contentPane.add(btnSesion);
		
	}

}
