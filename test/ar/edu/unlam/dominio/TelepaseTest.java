package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.junit.Test;

public class TelepaseTest {

//	Una empresa de peajes registra cada paso de vehículos, lo que resulta en una colección con múltiples entradas duplicadas 
//	(un vehiculo puede pasar varias veces). Es necesario poder registrar la pasada de un vehiculo (vehiculo y fecha con hora), 
//	obtener un listado de todas las pasadas realizadas (todos los vehiculos) y obtener un listado de vehiculos (solo vehiculos) 
//	sin duplicados. Para identificar a cada vehiculo debemos usar la patente.

	@Test
	public void dadoQueExisteUnaEmpresaDePeajeSeRegistraUnaPasada() {
		// Voy a necesitar iniciar Peaje, Vehiculo y Pase

		// Inicio Peaje
		Peaje peaje = new Peaje();
		// Inicio Vehiculo
		Vehiculo vehiculo = new Vehiculo("ADS123", "Fiat", "Palio");
		// Inicio Pase
		LocalDateTime fechayHora = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		Pase pase = new Pase(vehiculo, fechayHora);

		// Accion de registrar pasada
		boolean pasada = peaje.registrarPasada(pase);

		// Assert de comprobacion
		assertTrue(pasada);
	}

	@Test
	public void dadoQueExisteUnaEmpresaDePeajeNoSePermitenPasesDuplicados() {
		// Voy a necesitar iniciar Peaje, Vehiculo y Pase

		// Inicio Peaje
		Peaje peaje = new Peaje();
		// Inicio Vehiculo
		Vehiculo vehiculo1 = new Vehiculo("ADS123", "Fiat", "Palio");
		Vehiculo vehiculo2 = new Vehiculo("ADS123", "Fiat", "Palio");
		// Inicio Pase
		LocalDateTime fechayHora1 = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		LocalDateTime fechayHora2 = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		Pase pase1 = new Pase(vehiculo1, fechayHora1);
		Pase pase2 = new Pase(vehiculo2, fechayHora2);

		// Accion de registrar pasadas
		peaje.registrarPasada(pase1);
		peaje.registrarPasada(pase2);

		// Assert de comprobacion
		assertEquals(2, peaje.getCantidadPasadas());
	}

	@Test
	public void dadoQueExisteUnaEmpresaDePeajeSeRegistranPasadasDeDosVehiculos() {
		// Voy a necesitar iniciar Peaje, Vehiculo y Pase

		// Inicio Peaje
		Peaje peaje = new Peaje();
		// Inicio Vehiculo
		Vehiculo vehiculo1 = new Vehiculo("ADS123", "Fiat", "Palio");
		Vehiculo vehiculo2 = new Vehiculo("OSD932", "Ford", "Ka");
		// Inicio Pase
		LocalDateTime fechayHora1 = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		LocalDateTime fechayHora2 = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		Pase pase1 = new Pase(vehiculo1, fechayHora1);
		Pase pase2 = new Pase(vehiculo2, fechayHora2);

		// Accion de registrar pasadas
		peaje.registrarPasada(pase1);
		peaje.registrarPasada(pase2);

		// Assert de comprobacion
		assertEquals(2, peaje.getCantidadPasadas());
	}

	@Test
	public void dadoQueExisteUnaEmpresaDePeajeSeRegistrasDosPasadasDelMismoVehiculoEnDistintasHoras() {
		// Voy a necesitar iniciar Peaje, Vehiculo y Pase

		// Inicio Peaje
		Peaje peaje = new Peaje();
		// Inicio Vehiculo
		Vehiculo vehiculo = new Vehiculo("ADS123", "Fiat", "Palio");
		// Inicio Pase
		LocalDateTime fechayHora1 = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		LocalDateTime fechayHora2 = LocalDateTime.of(2025, 9, 3, 9, 14, 0).plusHours(1);
		Pase pase1 = new Pase(vehiculo, fechayHora1);
		Pase pase2 = new Pase(vehiculo, fechayHora2);

		// Accion de registrar pasadas
		peaje.registrarPasada(pase1);
		peaje.registrarPasada(pase2);

		// Assert de comprobacion
		assertEquals(2, peaje.getCantidadPasadas());
	}

	@Test
	public void dadoQueExisteUnGestorDePeajeAlRegistrar2PasesDeunVehiculoYotroPaseDeotroVheculoObtengoUnListadoConLos2Vehiculos() {
		// Voy a necesitar iniciar Peaje, Vehiculo y Pase

		// Inicio Peaje
		Peaje peaje = new Peaje();

		String patente = "ac111as";
		String marco = "fiat";
		String modelo = "punto";

		// Inicio Vehiculo 1 y Pase 1
		Vehiculo vehiculo = new Vehiculo(patente, marco, modelo);
		LocalDateTime fechayHora = LocalDateTime.of(2025, 9, 03, 12, 0);
		Pase pase = new Pase(vehiculo, fechayHora);
		peaje.registrarPasada(pase);

		String patente2 = "ac333fr";
		String marco2 = "fiat";
		String modelo2 = "punto";

		// Inicio Vehiculo 2 y Pase 2
		LocalDateTime fechayHora2 = LocalDateTime.of(2025, 9, 03, 13, 0);
		Vehiculo vehiculo2 = new Vehiculo(patente2, marco2, modelo2);
		Pase pase2 = new Pase(vehiculo2, fechayHora2);
		peaje.registrarPasada(pase2);

		// Inicio Pase 3
		LocalDateTime fechayHora3 = LocalDateTime.of(2025, 9, 03, 14, 0);
		Pase pase3 = new Pase(vehiculo, fechayHora3);
		peaje.registrarPasada(pase3);

		// Lista de Vehiculos
		HashSet<Vehiculo> vehiculos = peaje.obtenerTodosLosVehiculos();

		// Asserts sobre la lista
		Integer valorEsperado = 2;
		Integer valorObtenido = vehiculos.size();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void dadoQueExisteUnaEmpresaDePeajeSeAgregaUnaTarifa() {
		// Voy a necesitar iniciar Peaje y Tarifa

		// Inicio Peaje
		Peaje peaje = new Peaje();

		// Inicio Tarifa
		Tarifa tarifa = new Tarifa();
		tarifa.setId(1);
		tarifa.setDesde(LocalDateTime.of(2025, 1, 1, 0, 0));
		tarifa.setValor(100.0);

		// Agrego Tarfia
		peaje.getTarifas().add(tarifa);

		// Asserts sobre la tarifa
		assertEquals(1, peaje.getTarifas().size());
		assertEquals(tarifa, peaje.obtenerTarifaVigente());
	}

	@Test
	public void dadoQueAgregoUnaNuevaTarifaModificoElHastaEnUnDiaAnterior() {
		// Voy a necesitar iniciar Peaje y Tarifa

		// Inicio Peaje
		Peaje peaje = new Peaje();

		// Inicio Tarifa vieja
		Tarifa tarifaVieja = new Tarifa();
		tarifaVieja.setId(1);
		tarifaVieja.setDesde(LocalDateTime.of(2025, 1, 1, 0, 0));
		tarifaVieja.setValor(100.0);

		// Accion de agregar tarifa vieja
		peaje.getTarifas().add(tarifaVieja);

		// Inicio Tarifa nueva
		Tarifa tarifaNueva = new Tarifa();
		tarifaNueva.setId(2);
		tarifaNueva.setDesde(LocalDateTime.of(2025, 2, 1, 0, 0));
		tarifaNueva.setValor(120.0);

		// Modificar el Hasta
		tarifaVieja.setHasta(tarifaNueva.getDesde().minusDays(1));
		// Accion de agregar tarifa vieja
		peaje.getTarifas().add(tarifaNueva);

		// Assert sobre las tarifas
		assertEquals(LocalDateTime.of(2025, 1, 31, 0, 0), tarifaVieja.getHasta());
		assertEquals(tarifaNueva, peaje.obtenerTarifaVigente());
	}

	@Test
	public void dadoQueExistenPasesObtengoElMontoDeUnVehiculoParaUnMes() {
		// Voy a necesitar iniciar Peaje, Vehiculo y Tarifa

		// Inicio Peaje
		Peaje peaje = new Peaje();

		// Inicio Tarifa
		Tarifa tarifa = new Tarifa();
		tarifa.setId(1);
		tarifa.setDesde(LocalDateTime.of(2025, 1, 1, 0, 0));
		tarifa.setValor(50.0);

		// Accion de agregar tarifa
		peaje.getTarifas().add(tarifa);

		// Inicio vehiculo
		Vehiculo vehiculo = new Vehiculo("ADS123", "Fiat", "Palio");

		// Accion de registrar pasadas de un mes
		peaje.registrarPasada(new Pase(vehiculo, LocalDateTime.of(2025, 9, 3, 10, 0)));
		peaje.registrarPasada(new Pase(vehiculo, LocalDateTime.of(2025, 9, 4, 11, 0)));
		peaje.registrarPasada(new Pase(vehiculo, LocalDateTime.of(2025, 9, 5, 12, 0)));

		// Obtengo el monto del mes para el vehiculo
		double monto = peaje.obtenerMontoAABonarDeUnVehiculoParaUnMesDado("ADS123", 2025, 9);

		// Assert del monto
		assertEquals(150.0, monto, 0.01);
	}

}
