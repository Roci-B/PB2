package ar.edu.unlam.dominio;

public interface Operaciones {

	double PESO_PROMEDIO_POR_PERSONA = 70.0;

	boolean cargarPasajeros(int cantidadDePasajeros);

	double getPesoMaximo();

	int getCapacidadMaximaDePasajeros();

}
