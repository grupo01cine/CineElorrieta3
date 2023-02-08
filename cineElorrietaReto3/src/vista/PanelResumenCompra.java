package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelResumenCompra extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PanelResumenCompra() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResumenCompra = new JLabel("Resumen de compra");
		lblResumenCompra.setBounds(238, 23, 179, 14);
		contentPane.add(lblResumenCompra);
		
		JTable tableResumen = new JTable();
		tableResumen.setBounds(10, 43, 596, 154);
		contentPane.add(tableResumen);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(412, 208, 73, 14);
		contentPane.add(lblTotal);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setBounds(412, 233, 73, 14);
		contentPane.add(lblDescuento);
		
		JLabel lblPrecioTotal = new JLabel("Precio total:");
		lblPrecioTotal.setBounds(412, 258, 73, 14);
		contentPane.add(lblPrecioTotal);
		
		JButton btnComprarResumen = new JButton("Finalizar compra");
		btnComprarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelLogin login = new PanelLogin(null);
				login.setVisible(true);
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnComprarResumen.setBounds(150, 287, 150, 23);
		contentPane.add(btnComprarResumen);
		
		JButton btnCancelarResumen = new JButton("Cancelar");
		btnCancelarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.getParent().getParent().getParent().setVisible(false);
			}
		});
		btnCancelarResumen.setBounds(350, 287, 150, 23);
		contentPane.add(btnCancelarResumen);
		
		JTextField textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setBounds(495, 208, 86, 20);
		contentPane.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JTextField textFieldDescuento = new JTextField();
		textFieldDescuento.setEditable(false);
		textFieldDescuento.setBounds(495, 230, 86, 20);
		contentPane.add(textFieldDescuento);
		textFieldDescuento.setColumns(10);
		
		JTextField textFieldPrecioTotal = new JTextField();
		textFieldPrecioTotal.setEditable(false);
		textFieldPrecioTotal.setBounds(495, 255, 86, 20);
		contentPane.add(textFieldPrecioTotal);
		textFieldPrecioTotal.setColumns(10);
	}

}
