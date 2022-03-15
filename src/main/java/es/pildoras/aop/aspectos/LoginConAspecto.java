package es.pildoras.aop.aspectos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import es.pildoras.aop.dao.Cliente;

@Aspect
@Component
@Order(2)
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

}
