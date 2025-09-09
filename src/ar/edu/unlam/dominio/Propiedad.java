package ar.edu.unlam.dominio;

public class Propiedad {

	private String ciudad;
	private double precio;
	private int id;
	private boolean vendida;

	public Propiedad(int id, String ciudad, double precio) {
		this.id = id;
		this.ciudad = ciudad;
		this.precio = precio;
		this.vendida = false;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isVendida() {
		return vendida;
	}

	public boolean setVendida() {
		return this.vendida = true;
	}

}
