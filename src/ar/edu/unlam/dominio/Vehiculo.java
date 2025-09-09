package ar.edu.unlam.dominio;

import java.util.Objects;

public class Vehiculo {

	private String marca;
	private String modelo;
	private String patente;

	public Vehiculo(String marca, String modelo, String patente) {
		this.marca = marca;
		this.modelo = modelo;
		this.patente = patente;
	}

	// Misma patente, mismo modelo, misma marca, mismo vehiculo
	@Override
	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (objeto == null || getClass() != objeto.getClass())
			return false;
		Vehiculo vehiculo = (Vehiculo) objeto;
		return patente.equals(vehiculo.patente) && marca.equals(vehiculo.marca) && modelo.equals(vehiculo.modelo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

}
