package ar.edu.unlam.dominio;

public class Producto {
	private String nombre;
	protected double precio;
	private String descripcion;
	protected double recargo;

	public Producto(String nombre, double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double calcularPrecioFinal() {
		int valorFijo = 0;
		return this.precio + valorFijo + (this.precio * this.recargo);

	}

	/*
	 * Ejercicio 2: Sistema de Facturación para Productos Enunciado: Diseña un
	 * sistema de facturación para diferentes tipos de productos en una tienda. Crea
	 * una clase base Producto con atributos como nombre, precio, y descripcion.
	 * Luego, crea subclases como ProductoElectronico, ProductoAlimenticio, y
	 * ProductoRopa que sobrescriban el método calcularPrecioFinal() para incluir
	 * descuentos específicos o impuestos según el tipo de producto. Los productos
	 * electrónicos tienen un recargo del 15%, los de ropa agregan una comisión del
	 * vendedor de 5% y los productos alimenticios, agregan un valor fijo de $1000,
	 * más un 7.5%.
	 */

}
