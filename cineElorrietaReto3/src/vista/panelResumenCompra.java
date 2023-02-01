package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

public class panelResumenCompra {

	private JFrame frame;
	private JTable tableResumen;
	private JTextField textFieldTotal;
	private JTextField textFieldDescuento;
	private JTextField textFieldPrecioTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					panelResumenCompra window = new panelResumenCompra();
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
	public panelResumenCompra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelResumenCompra = new JPanel();
		panelResumenCompra.setBounds(0, 0, 616, 351);
		frame.getContentPane().add(panelResumenCompra);
		panelResumenCompra.setLayout(null);
		
		JLabel lblResumenCompra = new JLabel("Resumen de compra");
		lblResumenCompra.setBounds(238, 23, 179, 14);
		panelResumenCompra.add(lblResumenCompra);
		
		tableResumen = new JTable();
		tableResumen.setBounds(10, 43, 596, 154);
		panelResumenCompra.add(tableResumen);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(412, 208, 73, 14);
		panelResumenCompra.add(lblTotal);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(412, 233, 73, 14);
		panelResumenCompra.add(lblDescuento);
		
		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(412, 258, 73, 14);
		panelResumenCompra.add(lblPrecioTotal);
		
		JButton btnAceptarResumen = new JButton("Aceptar");
		btnAceptarResumen.setBounds(211, 287, 89, 23);
		panelResumenCompra.add(btnAceptarResumen);
		
		JButton btnCancelarResumen = new JButton("Cancelar");
		btnCancelarResumen.setBounds(350, 287, 89, 23);
		panelResumenCompra.add(btnCancelarResumen);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBounds(495, 208, 86, 20);
		panelResumenCompra.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		textFieldDescuento = new JTextField();
		textFieldDescuento.setBounds(495, 230, 86, 20);
		panelResumenCompra.add(textFieldDescuento);
		textFieldDescuento.setColumns(10);
		
		textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setBounds(495, 255, 86, 20);
		panelResumenCompra.add(textFieldPrecioTotal);
		textFieldPrecioTotal.setColumns(10);
	}

}
