package es.pildoras.aop.aspectos;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginConAspecto {

	// Solo en unico caso
	// (public void es.pildoras.aop.dao.ClienteVipDAO.insertaCliente())")
	// Solo con el cliente VIP
	// (public * insertaCliente*(es.pildoras.aop.dao.Cliente, ..))") 
	
	//@Pointcut("execution(public * insertaCliente*(..))")
	
	//Actuar con todos los métodos de un paquete
	@Pointcut("execution(* es.pildoras.aop.dao.*.*(..))")
	private void paraClientes() {
	}
	
	//Pointcut para getters
	@Pointcut("execution(* es.pildoras.aop.dao.*.get*(..))")
	private void paraGetters() {
	}
	
	//Pointcut para setters
	@Pointcut("execution(* es.pildoras.aop.dao.*.set*(..))")
	private void paraSetters() {
	}
	
	//Combinación de Pointcuts
	@Pointcut("paraClientes() && !(paraGetters() || paraSetters())")
	private void combinacionPointcuts() {
	}

	@Before("combinacionPointcuts()")
	public void antesInsertarCliente() {
		System.out.println("El usuario esta logeado");
		System.out.println("El perfil para insertar clientes es correcto");
	}

	@Before("combinacionPointcuts()")
	public void requisitosCliente() {
		System.out.println("El cliente cumple con los requisitos para ser insertado en la BBDD");
	}

	@Before("combinacionPointcuts()")
	public void requisitosTabla() {
		System.out.println("Hay menos de 3000 registros en la tabla, puedes insertar el nuevo cliente");
	}

}
