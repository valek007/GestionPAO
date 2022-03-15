package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteDAO {

	public void insertaCliente() {
		System.out.println("----------------------------------------------------");
		System.out.println("Trabajo realizado. Cliente insertado con exito.\n");
	}

}
