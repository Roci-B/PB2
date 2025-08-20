package ar.edu.unlam.dominio;

public class ClaseDeTest {
	
	// Clase con indicaciones para el desarrollo con TDD.

	public void pasosParaDesarrollarConTDD() {
		// Paso 1:
		// Escribimos una prueba (Generar clases, metodos y elementos necesarios para
		// que compile). Ejecutar o correr la prueba y debe dar rojo (la prueba no
		// pasa).

		// Paso 2:
		// Agregamos la menor cantidad de codigo productivo (JUSTO y NECESARIO) para que
		// la prueba pase (de
		// en color verde).

		// Paso 3:
		// Re organizamos el codigo (refactor) si es posible y/o util.

		// Importante: Las pruebas, ejecutan metodos. Probamos metodos.
	}

	public void contenidoDeUnaPrueba() {

		// Preparacion: elementos necesarios para garantizar que la prueba sea efectiva.
		// Si vamos a sumar 2 + 3, debemos contar con el 2 y el 3.

		// Ejecucion: ejecutamos el metodo que estamos probando. En este ejemplo
		// deberiamos ejecutar "sumar(2,3)".

		// Verificacion: garantizamos que el dato o resultado OBTENIDO sea el dato o
		// resultado ESPERADO. El resultado debe ser 5.
	}

	public void nomenclaturaDePruebas() {
		// Es importante que en el nombre del metodo que prueba, se incluya la
		// informacion necesaria para entender que se esta probando.

		// Dado que (given): aclara el contexto.
		// Cuando (when): aclara lo que se ejecuta.
		// Entonces (then): aclara el resultado esperado.
	}

	public void paraPracticar() {
		// TODO: Crear un usuario en GitHub.
		// TODO: Crear un repositorio en GitHub.
		// TODO: Clonar el repositorio.
		// TODO: Crear una nueva rama en el repositorio antes creado.
		// TODO: Desarrollar el ejercicio en la nueva rama y subirlo al repositorio.
		
		// TODO: Ejercicio: Realizar las pruebas de una clase Calculadora que permita realizar las
		// operaciones:
		// Sumar dos numeros enteros.
		// Restar dos numeros enteros.
		// Multiplicar dos numeros enteros.
		// Dividir dos numeros enteros. El divisor no puede ser 0 (cero). Si asi fuera,
		// se debe devolver 0 (cero).
	}
}
