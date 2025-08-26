package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	
	private Calculadora calculadora;

	@Before
	public void inicializacion() {
		this.calculadora = new Calculadora();
	}

    @Test
    public void testSumar() {
    	int resultadoEsperado = 6;
        int resultadoObtenido = this.calculadora.sumar();
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void testRestar() {
    	int resultadoEsperado = 2;
        int resultadoObtenido = this.calculadora.restar();
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void testMultiplicar() {
    	int resultadoEsperado = 8;
        int resultadoObtenido = this.calculadora.multiplicar();
        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void testDividir() {
    	int resultadoEsperado = 2;
        int resultadoObtenido = this.calculadora.dividir();
        assertEquals(resultadoEsperado, resultadoObtenido);
    }


	// TODO: Ejercicio: Realizar las pruebas de una clase Calculadora que permita realizar las
	// operaciones:
	// Sumar dos numeros enteros.
	// Restar dos numeros enteros.
	// Multiplicar dos numeros enteros.
	// Dividir dos numeros enteros. El divisor no puede ser 0 (cero). Si asi fuera,
	// se debe devolver 0 (cero).

}
