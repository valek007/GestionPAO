package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteOtroDAO {
	
	public String insertaClienteOTRO(Cliente cliente, String tipo) {
		System.out.println("----------------------------------------------------");
		System.out.println("Trabajo realizado. Cliente " + tipo + " " + cliente.getNombre() + " insertado con exito.\n");
		return "Hola Mundo";
	}
 

}
