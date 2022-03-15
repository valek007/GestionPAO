package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteVipDAO {

	public void insertaClienteVIP(Cliente cliente, String tipo) {
		System.out.println(
				"Trabajo realizado OK. Cliente " + tipo + " " + cliente.getNombre() + " insertado con exito.\n");
	}

}
