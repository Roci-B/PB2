package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pase {
	private Vehiculo vehiculo;
	private LocalDateTime fechayHora;

	public Pase(Vehiculo vehiculo, LocalDateTime fechayHora) {
		this.vehiculo = vehiculo;
		this.fechayHora = fechayHora;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	// Mismo vehiculo + fechayHora, Mismo pase

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto)
			return true;
		if (objeto == null || getClass() != objeto.getClass())
			return false;
		Pase pase = (Pase) objeto;
		return vehiculo.equals(pase.vehiculo) && fechayHora.equals(pase.fechayHora);
	}

	@Override
	public int hashCode() {
		return Objects.hash(vehiculo, fechayHora);
	}

	public LocalDateTime getFechayHora() {
		return fechayHora;
	}

	public void setFechayHora(LocalDateTime fechayHora) {
		this.fechayHora = fechayHora;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
