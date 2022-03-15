package es.pildoras.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class ClienteOtroDAO {
	
	public String insertaClienteOTRO() {
		System.out.println("Trabajo realizado OK. Otro cliente insertado con exito.\n");
		return "Hola Mundo";
	}
 

}
