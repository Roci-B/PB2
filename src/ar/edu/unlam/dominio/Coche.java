package ar.edu.unlam.dominio;

public class Coche extends Vehiculo {

	private double pesoMaximo;
	private int capacidadMaximaDePasajeros;

	public Coche(String patente) {
		super(patente);
		this.pesoMaximo = 1000.0;
		this.capacidadMaximaDePasajeros = 4;
	}

	@Override
	public boolean cargarPasajeros(int cantidadDePasajeros) {
		double pesoACargar = cantidadDePasajeros * PESO_PROMEDIO_POR_PERSONA;

		if (this.pesoMaximo >= pesoACargar && this.capacidadMaximaDePasajeros >= cantidadDePasajeros) {
			this.setPesoActual(this.getPesoActual() + pesoACargar);
			this.setCantidadActual((int) (this.getCantidadActual() + cantidadDePasajeros));
			return true;
		}

		return false;
	}

	@Override
	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(double pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	@Override
	public int getCapacidadMaximaDePasajeros() {
		return capacidadMaximaDePasajeros;
	}

	public void setCapacidadMaximaDePasajeros(int capacidadDePasajeros) {
		this.capacidadMaximaDePasajeros = capacidadDePasajeros;
	}

}
