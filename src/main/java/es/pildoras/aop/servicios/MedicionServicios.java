package es.pildoras.aop.servicios;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MedicionServicios {

	public String getServicio() {

		System.out.println("\n *****EL MÉTODO REALIZANDO SUS TAREAS******");

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Servicios terminados.";
	}

}
