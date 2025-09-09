package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InmobiliariaTest {

	private Inmobiliaria inmobiliaria;

	@Before
	public void Setup() {
		inmobiliaria = new Inmobiliaria();
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaSeAgreganPropiedades() {
		Propiedad nueva = new Propiedad(1, "Buenos Aires", 100000.00);
		assertTrue(inmobiliaria.agregarPropiedad(nueva));
		assertEquals(1, inmobiliaria.getPropiedades().size());
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaSePermiteAgregarPropiedadesDuplicadas() {
		Propiedad nueva1 = new Propiedad(1, "Buenos Aires", 100000.00);
		Propiedad nueva2 = new Propiedad(1, "Buenos Aires", 100000.00);
		inmobiliaria.agregarPropiedad(nueva1);
		assertTrue(inmobiliaria.agregarPropiedad(nueva2));
		assertEquals(2, inmobiliaria.getPropiedades().size());
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaSeModificanPropiedades() {
		Propiedad nueva = new Propiedad(1, "Buenos Aires", 100000.00);
		inmobiliaria.agregarPropiedad(nueva);
		inmobiliaria.modificarPropiedad(2, "Rosario", 120000.00);
		assertFalse(inmobiliaria.existePropiedad(1));
		assertEquals(nueva, inmobiliaria.buscarPorCodigo(2));
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaSeAgreganClientes() {
		Cliente nuevo = new Cliente(3312392, "Juan", "Perez");
		assertTrue(inmobiliaria.agregarCliente(nuevo));
		assertEquals(1, inmobiliaria.getClientes().size());
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaNoSePermiteAgregarClientesDuplicadas() {
		Cliente nuevo1 = new Cliente(3312392, "Juan", "Perez");
		Cliente nuevo2 = new Cliente(3312392, "Juan", "Perez");
		inmobiliaria.agregarCliente(nuevo1);
		assertFalse(inmobiliaria.agregarCliente(nuevo2));
		assertEquals(1, inmobiliaria.getClientes().size());
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaSeBuscanPropiedadesPorRangoDePrecios() {
		Propiedad prop1 = new Propiedad(1, "Buenos Aires", 100000.00);
		Propiedad prop2 = new Propiedad(2, "Rosario", 80000.00);
		Propiedad prop3 = new Propiedad(3, "Buenos Aires", 150000.00);

		inmobiliaria.agregarPropiedad(prop1);
		inmobiliaria.agregarPropiedad(prop2);
		inmobiliaria.agregarPropiedad(prop3);

		ArrayList<Propiedad> resultado = new ArrayList<>();
		resultado = inmobiliaria.buscarPorRangoDePrecios(90000, 200000);

		assertEquals(2, resultado.size());
		assertTrue(resultado.contains(prop1));
		assertTrue(resultado.contains(prop3));
		assertFalse(resultado.contains(prop2));
	}

	@Test
	public void dadoQueExisteUnaInmobiliariaSeBuscanPropiedadesPorCiudad() {
		Propiedad prop1 = new Propiedad(1, "Buenos Aires", 100000.00);
		Propiedad prop2 = new Propiedad(2, "Rosario", 80000.00);
		Propiedad prop3 = new Propiedad(3, "Buenos Aires", 150000.00);

		inmobiliaria.agregarPropiedad(prop1);
		inmobiliaria.agregarPropiedad(prop2);
		inmobiliaria.agregarPropiedad(prop3);

		ArrayList<Propiedad> resultado = new ArrayList<>();
		resultado = inmobiliaria.buscarPorCiudad("Buenos Aires");

		assertEquals(2, resultado.size());
		assertTrue(resultado.contains(prop1));
		assertTrue(resultado.contains(prop3));
		assertFalse(resultado.contains(prop2));
	}

	// Realizar venta
	@Test
	public void dadoQueExisteUnaInmobiliariaSeVendeUnaPropiedad() {
		Propiedad nueva = new Propiedad(1, "Buenos Aires", 100000.00);
		Cliente nuevo = new Cliente(3312392, "Juan", "Perez");
		assertTrue(inmobiliaria.venderPropiedad(nueva, nuevo));
		// assertEquals(inmobiliaria.getPropiedades());
	}

	@Test
	public void noSePuedeVenderDosVecesLaMismaPropiedad() {
		Propiedad venta = new Propiedad(1, "Buenos Aires", 100000.00);
		Cliente comprador = new Cliente(3312392L, "Juan", "Perez");
		inmobiliaria.agregarPropiedad(venta);
		inmobiliaria.agregarCliente(comprador);

		assertTrue(inmobiliaria.venderPropiedad(venta, comprador));
		assertFalse(inmobiliaria.venderPropiedad(venta, comprador));
	}

	@Test
	public void noSePuedeVenderPropiedadInexistente() {
		Propiedad inexistente = new Propiedad(99, "Rosario", 80000.00);
		Cliente comprador = new Cliente(44556677L, "Ana", "Lopez");
		inmobiliaria.agregarCliente(comprador);

		assertFalse(inmobiliaria.venderPropiedad(inexistente, comprador));
	}

	@Test
	public void noSePuedeVenderAClienteInexistente() {
		Propiedad venta = new Propiedad(99, "Rosario", 80000.00);
		Cliente inexistente = new Cliente(44556677L, "Ana", "Lopez");
		inmobiliaria.agregarPropiedad(venta);

		assertFalse(inmobiliaria.venderPropiedad(venta, inexistente));
	}

}
