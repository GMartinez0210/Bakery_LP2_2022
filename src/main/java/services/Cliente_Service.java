package services;

import java.util.ArrayList;

import beans.Cliente_DTO;
import dao.DAO_Factory;
import interfaces.Cliente_DAO;

public class Cliente_Service {
	DAO_Factory factory = DAO_Factory.getDAO_Factory(1);

	Cliente_DAO cliente = factory.getCliente();
	
	public int agregar(Cliente_DTO newCliente) {
		return cliente.agregar(newCliente);
	}

	public ArrayList<Cliente_DTO> listar() {
		return cliente.listar();
	}
	public Cliente_DTO buscar(String dni) {
		return cliente.buscar(dni);
	}
	
	public int modificar(Cliente_DTO newCliente) {
		return cliente.modificar(newCliente);
	}
	
	public int borrar(String dni) {
		return cliente.borrar(dni);
	}
}
