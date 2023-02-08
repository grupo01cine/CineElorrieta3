package bbdd.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * POJO - Describe la tabla Entrada 
 */
public class Entrada implements Serializable{

	private static final long serialVersionUID = 5803034015734968201L;

	// Clave primaria
	private int codigo = 0;
	
	// Atributos
	private Date fechaCompra;
	private double precio = 0;
	
	// Atributos de la Relacion 
	//Relacion N:1 con la tabla Proyeccion
	private Proyeccion proyeccion = null;
	//Relacion N:1 con la tabla Cliente
	private Cliente cliente = null;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Proyeccion getProyeccion() {
		return proyeccion;
	}
	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, codigo, fechaCompra, precio, proyeccion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return Objects.equals(cliente, other.cliente) && codigo == other.codigo
				&& Objects.equals(fechaCompra, other.fechaCompra)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(proyeccion, other.proyeccion);
	}
	@Override
	public String toString() {
		return "Entrada [codigo=" + codigo + ", fechaCompra=" + fechaCompra + ", precio=" + precio + ", proyeccion="
				+ proyeccion + ", cliente=" + cliente + "]";
	}
	
}
