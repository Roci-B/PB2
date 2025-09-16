package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

public class TransporteTest {

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteCrearUnColectivo() {
		Colectivo colectivo = new Colectivo("ASD123");
		assertEquals("ASD123", colectivo.getPatente());
		assertEquals(10000.0, colectivo.getPesoMaximo(), 0.0);
		assertEquals(50, colectivo.getCapacidadMaximaDePasajeros(), 0.0);
		// Verificar patente
		// Verificar pesoMaximo
		// Verificar capacidadDeCarga
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteCrearUnCamion() {
		Camion camion = new Camion("ASD124");
		assertEquals("ASD124", camion.getPatente());
		assertEquals(100000.0, camion.getPesoMaximo(), 0.0);
		assertEquals(2, camion.getCapacidadMaximaDePasajeros(), 0.0);
		// Verificar patente
		// Verificar pesoMaximo
		// Verificar capacidadDeCarga
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteCrearUnCoche() {
		Coche coche = new Coche("ASD125");
		assertEquals("ASD125", coche.getPatente());
		assertEquals(1000.0, coche.getPesoMaximo(), 0.0);
		assertEquals(4, coche.getCapacidadMaximaDePasajeros(), 0.0);
		// Verificar patente
		// Verificar pesoMaximo
		// Verificar capacidadDeCarga
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteCargarPasajerosEnUnColectivo() {
		Colectivo colectivo = new Colectivo("ASD123");
		assertTrue(colectivo.cargarPasajeros(5));
		// Verificar si se cargaron los pasajeros correctamente
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteCargarPasajerosEnUnCamion() {
		Camion camion = new Camion("ASD124");
		assertTrue(camion.cargarPasajeros(1));
		// Verificar si se cargaron los pasajeros correctamente
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteCargarPasajerosEnUnCoche() {
		Coche coche = new Coche("ASD125");
		assertTrue(coche.cargarPasajeros(3));
		// Verificar si se cargaron los pasajeros correctamente
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteNoCargarPasajerosEnUnColectivoSiSeExcedeLaCapacidadMaxima() {
		Colectivo colectivo = new Colectivo("ASD123");
		assertFalse(colectivo.cargarPasajeros(55));
		// Verificar si se no cargaron los pasajeros por exceso de peso y capacidad
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteNoCargarPasajerosEnUnCamionSiSeExcedeLaCapacidadMaxima() {
		Camion camion = new Camion("ASD124");
		assertFalse(camion.cargarPasajeros(3));
		// Verificar si se no cargaron los pasajeros por exceso de peso y capacidad
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteNoCargarPasajerosEnUnCocheSiSeExcedeLaCapacidadMaxima() {
		Coche coche = new Coche("ASD125");
		assertFalse(coche.cargarPasajeros(5));
		// Verificar si se no cargaron los pasajeros por exceso de peso y capacidad
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransportePuedoGuardarDiferentesVehiculosEnUnaListaDeOperaciones() {
		HashSet<Operaciones> vehiculos = new HashSet<>();

		vehiculos.add(new Colectivo("ABC123"));
		vehiculos.add(new Camion("DEF456"));
		vehiculos.add(new Coche("GHI789"));

		assertEquals(3, vehiculos.size());
		// Verificar si se agregaron los vehiculos a la lista
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteTodosDiferentesVehiculosPuedenCargarPasajeros() {
		HashSet<Operaciones> vehiculos = new HashSet<>();

		vehiculos.add(new Colectivo("ABC123"));
		vehiculos.add(new Camion("DEF456"));
		vehiculos.add(new Coche("GHI789"));

		for (Operaciones v : vehiculos) {
			assertTrue(v.cargarPasajeros(1));
			// Verificar si todos pueden cargar pasajeros en 'simultaneo'
		}
	}

	@Test
	public void dadoQueExisteUnaCompaniaDeTransporteUsoPolimorfismoCadaVehiculo() {
		Operaciones colectivo = new Colectivo("ABC123");
		Operaciones camion = new Camion("DEF456");
		Operaciones coche = new Coche("GHI789");

		assertTrue(colectivo.cargarPasajeros(40));
		assertFalse(camion.cargarPasajeros(5));
		assertTrue(coche.cargarPasajeros(3));
		// Verificar si todos pueden cargar pasajeros y como responde segun las
		// restricciones de cada uno
	}
}
