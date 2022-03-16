package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteOtroDAO {
	
	public String insertaClienteOTRO(Cliente cliente) {
		System.out.println("----------------------------------------------------");
		System.out.println("Trabajo realizado. Cliente " + cliente.getTipo() + " " + cliente.getNombre() + " insertado con exito.\n");
		return "Hola Mundo";
	}
 

}
