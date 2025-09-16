package ar.edu.unlam.dominio;

public abstract class Vehiculo implements Operaciones {

	private String patente;
	private double pesoActual;
	private int cantidadActual;

	// Verificar patente
	// Verificar pesoMaximo
	// Verificar capacidadDeCarga

	public Vehiculo(String patente) {
		this.patente = patente;
		this.pesoActual = 0.0;
		this.cantidadActual = 0;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public double getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(double pesoActual) {
		this.pesoActual = pesoActual;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

}
