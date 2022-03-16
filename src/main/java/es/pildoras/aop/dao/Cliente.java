package es.pildoras.aop.dao;

public class Cliente {

	private String nombre, tipo;

	public Cliente() {
	}

	public Cliente(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cliente: "+nombre + ", tipo: " + tipo;
	}

}
