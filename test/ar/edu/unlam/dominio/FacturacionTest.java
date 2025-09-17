package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class FacturacionTest {

	// dadoQueExisteUnaTiendaCrearUnProductoElectronico
	@Test
	public void dadoQueExisteUnaTiendaCrearUnProductoElectronico() {
		Producto electronico = new Electronico("tablet", 1000000.00, "tablet samsung");
		assertEquals("tablet", electronico.getNombre());
		assertEquals(1000000, electronico.getPrecio(), 0.0001);
		assertEquals("tablet samsung", electronico.getDescripcion());
	}

	// dadoQueExisteUnaTiendaCrearUnProductoAlimenticio
	@Test
	public void dadoQueExisteUnaTiendaCrearUnProductoAlimenticio() {
		Producto alimenticio = new Alimenticio("fideos", 1500.00, "fideos matarazzo");
		assertEquals("fideos", alimenticio.getNombre());
		assertEquals(1500, alimenticio.getPrecio(), 0.0001);
		assertEquals("fideos matarazzo", alimenticio.getDescripcion());
	}

	// dadoQueExisteUnaTiendaCrearUnProductoRopa
	@Test
	public void dadoQueExisteUnaTiendaCrearUnProductoRopa() {
		Producto ropa = new Ropa("remera", 25000.00, "remera levis");
		assertEquals("remera", ropa.getNombre());
		assertEquals(25000, ropa.getPrecio(), 0.0001);
		assertEquals("remera levis", ropa.getDescripcion());
	}

	// dadoQueExisteUnaTiendaCalcularPrecioFinalDeUnProductoElectronico
	@Test
	public void dadoQueExisteUnaTiendaCalcularPrecioFinalDeUnProductoElectronico() {
		Producto electronico = new Electronico("tablet", 1000000.00, "tablet samsung");
		assertEquals(1150000.0, electronico.calcularPrecioFinal(), 0.0001);
	}

	// dadoQueExisteUnaTiendaCalcularPrecioFinalDeUnProductoAlimenticio
	@Test
	public void dadoQueExisteUnaTiendaCalcularPrecioFinalDeUnProductoAlimenticio() {
		Producto alimenticio = new Alimenticio("fideos", 1500.00, "fideos matarazzo");
		assertEquals(2612.5, alimenticio.calcularPrecioFinal(), 0.0001);
	}

	// dadoQueExisteUnaTiendaCalcularPrecioFinalDeUnProductoRopa
	@Test
	public void dadoQueExisteUnaTiendaCalcularPrecioFinalDeUnProductoRopa() {
		Producto ropa = new Ropa("remera", 25000.00, "remera levis");
		assertEquals(26250.0, ropa.calcularPrecioFinal(), 0.0001);
	}

	// dadoQueExisteUnaTiendaHacerUnaListaDeVariosProductos
	@Test
	public void dadoQueExisteUnaTiendaHacerUnaListaDeVariosProductos() {
		ArrayList<Producto> productos = new ArrayList<>();

		productos.add(new Electronico("tablet", 1000000.00, "tablet samsung"));
		productos.add(new Alimenticio("fideos", 1500.00, "fideos matarazzo"));
		productos.add(new Ropa("remera", 25000.00, "remera levis"));

		assertEquals(3, productos.size());
	}

	// dadoQueExisteUnaTiendaHacerUnaCompraDeVariosProductosYCalcularSuPrecioFinal
	@Test
	public void dadoQueExisteUnaTiendaHacerUnaCompraDeVariosProductosYCalcularSuPrecioFinal() {
		ArrayList<Producto> productos = new ArrayList<>();

		productos.add(new Electronico("tablet", 1000000.00, "tablet samsung"));
		productos.add(new Alimenticio("fideos", 1500.00, "fideos matarazzo"));
		productos.add(new Ropa("remera", 25000.00, "remera levis"));

		double totalEsperado = 1150000.0 + 2612.5 + 26250.0;
		double totalCalculado = 0.0;

		for (Producto p : productos) {
			totalCalculado += p.calcularPrecioFinal();
		}

		assertEquals(totalEsperado, totalCalculado, 0.0001);
	}

	/*
	 * Ejercicio 2: Sistema de Facturación para Productos Enunciado: Diseña un
	 * sistema de facturación para diferentes tipos de productos en una tienda. Crea
	 * una clase base Producto con atributos como nombre, precio, y descripcion.
	 * Luego, crea subclases como ProductoElectronico, ProductoAlimenticio, y
	 * ProductoRopa que sobrescriban el método calcularPrecioFinal() para incluir
	 * descuentos específicos o impuestos según el tipo de producto. Los productos
	 * electrónicos tienen un recargo del 15%, los de ropa agregan una comisión del
	 * vendedor de 5% y los productos alimenticios, agregan un valor fijo de $1000,
	 * más un 7.5%.
	 */

}
