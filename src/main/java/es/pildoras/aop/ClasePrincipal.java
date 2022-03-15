package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.Cliente;
import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.dao.ClienteOtroDAO;
import es.pildoras.aop.dao.ClienteVipDAO;

public class ClasePrincipal {

	public static void main(String[] args) {

		// Leer la configuración de Spring
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Configuracion.class);
		
		// Obtener el bean del contenedor de Spring
		ClienteDAO cliente1 = context.getBean("clienteDAO", ClienteDAO.class);
		ClienteVipDAO cliente2 = context.getBean("clienteVipDAO", ClienteVipDAO.class);
		ClienteOtroDAO cliente3 = context.getBean("clienteOtroDAO", ClienteOtroDAO.class);
		
		//Cliente nuevo
		Cliente paco = new Cliente("Paco", "Especial");
		paco.setTipo("zumbado");
		
		
		// Llamar al método
		cliente1.insertaCliente();
		cliente2.insertaClienteVIP();
		cliente3.insertaClienteOTRO(paco, paco.getTipo());
		
		// Cerrar el contexto
		context.close();
	}

}
