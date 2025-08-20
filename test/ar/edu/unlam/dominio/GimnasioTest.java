package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GimnasioTest {
	
	private Gimnasio gimnasioEclipse;
	
	@Before
	public void inicializacion() {
		// @Before permite instanciar el objeto gimnasio antes de que se corra cada prueba
		this.gimnasioEclipse = new Gimnasio();
	}

	@Test
	public void dadoQueExisteUnGimnasioConNombreCuandoConsultoSuNombreObtengoEclipseGym() {
		// preparacion:
		
		// Comentamos la instancia de esta clase porque se movio con refactor al metodo inicializacion
		//Gimnasio gimnasioEclipse = new Gimnasio();
		this.gimnasioEclipse.setNombre("Eclipse Gym");

		// ejecucion:
		String nombreDelGimnasioObtenido = this.gimnasioEclipse.getNombre();

		// verificacion:
		String nombreDelGimnasioEsperado = "Eclipse Gym";

		assertEquals(nombreDelGimnasioEsperado, nombreDelGimnasioObtenido);
	}
	
	@Test
	public void dadoQueExisteUnGimnasioConNombreYCapacidadCuandoConsultoSuCapacidadObtengo50() {
		// preparacion:
		
		// Comentamos la instancia de esta clase porque se movio con refactor al metodo inicializacion
		//Gimnasio gimnasioEclipse = new Gimnasio();
		this.gimnasioEclipse.setNombre("Eclipse Gym");

		// ejecucion:
		Integer capacidadDelGimnasioObtenida = this.gimnasioEclipse.getCapacidad();

		// verificacion:
		Integer capacidadDelGimnasioEsperado = 50;

		assertEquals(capacidadDelGimnasioEsperado, capacidadDelGimnasioObtenida);
	}

	@Test
	public void dadoQueExisteUnGimnasioCuandoInstancioUnObjetoUsandoElConstructorConSuNombreYConsultoElNombreDelGimnasioObtengoEclipseGym() {
		// preparacion:
		Gimnasio gimnasioEclipse = new Gimnasio("Eclipse Gym2");

		// ejecucion:
		String nombreDelGimnasioObtenido = gimnasioEclipse.getNombre();

		// verificacion:
		String nombreDelGimnasioEsperado = "Eclipse Gym2";

		assertEquals(nombreDelGimnasioEsperado, nombreDelGimnasioObtenido);
	}

}
