package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class Peaje {
	private HashSet<Pase> pases;
	private ArrayList<Tarifa> tarifas;

	public Peaje() {
		this.pases = new HashSet<>();
		this.tarifas = new ArrayList<>();
	}

	public ArrayList<Tarifa> getTarifas() {
		return tarifas;
	}

	public boolean registrarPasada(Pase pase) {
		return pases.add(pase);
	}

	public Object getCantidadPasadas() {
		return this.pases.size();
	}

	public HashSet<Vehiculo> obtenerTodosLosVehiculos() {

		HashSet<Vehiculo> vehiculos = new HashSet<>();
		for (Pase pase : pases) {
			vehiculos.add(pase.getVehiculo());
		}

		return vehiculos;
	}

	public double obtenerMontoAABonarDeUnVehiculoParaUnMesDado(String patente, int anio, int mes) {
		double montoTotal = 00.0;
		for (Pase pase : pases) {
			if (pase.getVehiculo() != null && pase.getVehiculo().getPatente().equals(patente)) {
				if (pase.getFechayHora().getYear() == anio && pase.getFechayHora().getMonthValue() == mes) {
					for (Tarifa tarifa : tarifas) {
						montoTotal += tarifa.getValor();
					}
				}
			}
		}
		return montoTotal;
	}

	public Tarifa obtenerTarifaVigente() {
		for (Tarifa tarifa : this.tarifas) {
			if (tarifa.getHasta() == null)
				return tarifa;
		}
		return null;
	}

}
