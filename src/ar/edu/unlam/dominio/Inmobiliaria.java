package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class Inmobiliaria {
	private HashSet<Cliente> clientes;
	private ArrayList<Propiedad> propiedades;

	public Inmobiliaria() {
		this.propiedades = new ArrayList<>();
		this.clientes = new HashSet<>();
	}

	public boolean agregarPropiedad(Propiedad nueva) {
		return propiedades.add(nueva);
	}

	public HashSet<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(HashSet<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(ArrayList<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}

	public boolean agregarCliente(Cliente nuevo) {
		return clientes.add(nuevo);
	}

	public Propiedad buscarPorCodigo(int id) {
		for (Propiedad encontrada : propiedades) {
			if (encontrada != null && encontrada.getId() == id) {
				return encontrada;
			}
		}
		return null;
	}

	public Cliente buscarClientePorDNI(long dni) {
		for (Cliente esteCliente : clientes) {
			if (esteCliente != null && esteCliente.getDni() == dni)
				return esteCliente;
		}
		return null;
	}

	public boolean venderPropiedad(Propiedad nueva, Cliente nuevo) {
		if (nueva != null && nuevo != null && nueva.isVendida() == false) {
			return nueva.setVendida();
		}
		return false;
	}

	public boolean modificarPropiedad(int id, String nuevaCiudad, double nuevoPrecio) {
		Propiedad encontrada = buscarPorCodigo(id);
		if (encontrada != null) {
			encontrada.setId(id);
			encontrada.setCiudad(nuevaCiudad);
			encontrada.setPrecio(nuevoPrecio);
			return true;
		}
		return false;
	}

	public ArrayList<Propiedad> buscarPorRangoDePrecios(double min, double max) {
		ArrayList<Propiedad> resultado = new ArrayList<>();
		for (Propiedad propiedad : propiedades) {
			if (!propiedad.isVendida() && propiedad.getPrecio() >= min && propiedad.getPrecio() <= max) {
				resultado.add(propiedad);
			}
		}
		return resultado;
	}

	public ArrayList<Propiedad> buscarPorCiudad(String ciudad) {
		ArrayList<Propiedad> resultado = new ArrayList<>();
		for (Propiedad propiedad : propiedades) {
			if (!propiedad.isVendida() && propiedad.getCiudad().equalsIgnoreCase(ciudad)) {
				resultado.add(propiedad);
			}
		}
		return resultado;
	}

	public boolean existePropiedad(int id) {
		return buscarPorCodigo(id) != null;
	}

}
