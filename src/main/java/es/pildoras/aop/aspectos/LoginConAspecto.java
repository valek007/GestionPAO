package es.pildoras.aop.aspectos;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.pildoras.aop.dao.Cliente;

@Aspect
@Component
@Order(3)
public class LoginConAspecto {

	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	public void paraClientes() {
	}

	@Before("paraClientes()")
	public void antesInsertarCliente(JoinPoint joinPoint) {
		System.out.println("2. USUARIO LOGEADO");
		System.out.println("3. PERFIL CORRECTO");

		Object[] argumentos = joinPoint.getArgs();

		for (Object object : argumentos) {
			if (object instanceof Cliente) {
				Cliente cliente = (Cliente) object;
				System.out.println("    --> Nombre: " + cliente.getNombre() + " Tipo: " + cliente.getTipo());
			}
		}
	}

	@AfterReturning(pointcut = "execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))", returning = "listaDeClientes")
	public void trasEncontrarClientes(List<Cliente> listaDeClientes) {
		for (Cliente cliente : listaDeClientes) {
			if (cliente.getTipo() == "VIP")
				procesadoDatosAftRet(listaDeClientes);
			System.out.println(cliente.getNombre() + " es un cliente VIP.");
		}
		System.out.println("------------------------------------------\n");
	}

	private void procesadoDatosAftRet(List<Cliente> listaDeClientes) {
		for (Cliente cliente : listaDeClientes) {
			String datosProcesados = cliente.getNombre().toUpperCase();
			cliente.setNombre(datosProcesados);
		}
	}

	@AfterThrowing(pointcut = "execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))", throwing = "ex")
	public void procesarDatosAfterExceptionEncuentraClientes(Throwable ex) {
		System.out.println("\n--PROCESANDO AUTOMÁTICAMENTE LAS TAREAS TRAS EXCEPCIÓN--");
	}

	@After("execution(* es.pildoras.aop.dao.ClienteDAO.encuentraClientes(..))")
	public void ejecutandoTareasConYSinExcepcion(JoinPoint jp) {
		System.out.println("\n--EJECUTANDO TAREAS SIEMPRE!!!--");
	}

	@Around("execution(* es.pildoras.aop.servicios.MedicionServicios.getServicio(..))")
	public Object ejecutarServicio(ProceedingJoinPoint point) throws Throwable {
		
		long comienzo=System.currentTimeMillis();

		System.out.println("-----COMIENZO DE ACCIONES ANTES DE LA LLAMADA-----------------");

		Object resultado = point.proceed(); // El point apunta al método destino

		System.out.println("------------tareas después de llamada------");
		
		long fin=System.currentTimeMillis();
		long duracion =fin-comienzo;
		
		System.out.println("\nEl método tardó "+duracion/1000+" segundos.");

		return resultado;
	}

}
