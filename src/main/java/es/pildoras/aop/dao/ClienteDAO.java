package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteDAO {

	private String valoracionCliente, codigoCliente;

	public String getValoracionCliente() {
		System.out.println("Obteniendo valoración del cliente");
		return valoracionCliente;
	}

	public void setValoracionCliente(String valoracionCliente) {
		System.out.println("Estableciendo valoración del cliente");
		this.valoracionCliente = valoracionCliente;
	}

	public String getCodigoCliente() {
		System.out.println("Obteniendo código del cliente");
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		System.out.println("Obteniendo código del cliente");
		this.codigoCliente = codigoCliente;
	}

	public void insertaCliente() {
		System.out.println("Trabajo realizado OK. Cliente insertado con exito.\n");
	}

}
