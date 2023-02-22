package controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestorVentanas {

	public Double sacarPrecioTotal(JTable tablaResumen) {
		Double ret = (double) 0;

		for (int i = 0; i < tablaResumen.getRowCount(); i++) {
			Double precio = Double.parseDouble(String.valueOf(tablaResumen.getValueAt(i, 3)));
			ret = ret + precio;
		}
		return ret;
	}

	public Double sacarDescuento(JTable tablaResumen) {
		Double ret = (double) 0;
		int filas = tablaResumen.getRowCount();
		Double precio = sacarPrecioTotal(tablaResumen);

		if (filas == 2) {
			ret = (20 * precio) / 100;
		} else if (filas == 3) {
			ret = (30 * precio) / 100;
		} else if (filas == 4) {
			ret = (40 * precio) / 100;
		} else if (filas >= 5) {
			ret = (50 * precio) / 100;
		}
		return ret;
	}

	public Double sacarPrecioFinal(JTable tablaResumen) {
		Double ret = (double) 0;
		Double precio = sacarPrecioTotal(tablaResumen);
		Double descuento = sacarDescuento(tablaResumen);
		ret = precio - descuento;
		return ret;
	}

	public String sacarPorcentaje(JTable tablaResumen) {
		String ret = "";
		int filas = tablaResumen.getRowCount();

		if (filas < 2) {
			ret = "0%";
		} else if (filas == 2) {
			ret = "20%";
		} else if (filas == 3) {
			ret = "30%";
		} else if (filas == 4) {
			ret = "40%";
		} else if (filas >= 5) {
			ret = "50%";
		}
		return ret;
	}

	public void vaciarTabla(JTable tabla) {
		DefaultTableModel diseno = new DefaultTableModel();

		while (diseno.getRowCount() > 0) {
			diseno.removeRow(0);
		}

		tabla.setModel(diseno);
	}

}
