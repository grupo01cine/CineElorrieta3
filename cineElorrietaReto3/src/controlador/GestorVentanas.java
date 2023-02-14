package controlador;

import javax.swing.JTable;

public class GestorVentanas {

	public Double sacarPrecioTotal (JTable tablaResumen) {
		Double ret=(double) 0;
		
		for(int i=0; i < tablaResumen.getRowCount();i++)
        {
			Double precio = Double.parseDouble(String.valueOf(tablaResumen.getValueAt(i,3)));
             ret = ret + precio;
        }
		
		System.out.println(ret);
		return ret;
	}
	
	public int sacarDescuento (JTable tablaResumen) {
		int ret=0;
		int filas=tablaResumen.getRowCount();
		
		
		
		return ret;
	}
}
