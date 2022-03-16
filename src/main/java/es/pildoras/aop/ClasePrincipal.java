package es.pildoras.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.pildoras.aop.dao.ClienteDAO;
import es.pildoras.aop.servicios.MedicionServicios;

public class ClasePrincipal {

	public static void main(String[] args) {

		// Leer la configuraci�n de Spring
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);

		// Obtener el bean del contenedor de Spring
		ClienteDAO cliente1 = context.getBean("clienteDAO", ClienteDAO.class);

		boolean miParam = true;

		try {
			cliente1.encuentraClientes(miParam);
			cliente1.insertaCliente();
		} catch (Exception e) {
			System.out.println("\nExcepci�n lanzada desde la clase principal");
			System.out.println(e.getMessage());
		}

		System.out.println("\nAqu� continuara la ejecuci�n del programa......");

		// Segunda parte

		MedicionServicios servicio = context.getBean("medicionServicios", MedicionServicios.class);

		System.out.println("\n Llamando al m�todo getServicio()");

		String datos = servicio.getServicio();

		System.out.println("\n Devoluci�n del m�todo " + datos);

		// Cerrar el contexto
		context.close();
	}

}
