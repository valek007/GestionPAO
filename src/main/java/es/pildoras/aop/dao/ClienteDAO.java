package es.pildoras.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ClienteDAO {

	public void insertaCliente() {
		System.out.println("----------------------------------------------------");
		System.out.println("Trabajo realizado. Cliente insertado con exito.\n");
	}
	
	public List<Cliente> encuentraClientes(boolean miParam){
		
		if(miParam) throw new RuntimeException("Error! No se ha podido procesar la petición.");
		
		List<Cliente> listaClientes= new ArrayList<Cliente>();
		
		// simular clientes devueltos por BBDD
		Cliente paco = new Cliente("Paco", "Especial");
		Cliente ana = new Cliente("Ana", "VIP");
		Cliente pedro = new Cliente("Pedro", "Normal");
		Cliente lucia = new Cliente("Lucia", "Normal");
		Cliente roberto = new Cliente("Roberto", "Especial");
		
		listaClientes.add(paco);
		listaClientes.add(ana);
		listaClientes.add(pedro);
		listaClientes.add(lucia);
		listaClientes.add(roberto);
		
		System.out.println("------------------------------------------");
		System.out.println("LISTA DE CLIENTES COMPLETADA\n");
		
		return listaClientes;
	}

}
