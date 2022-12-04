package interfaces;

import java.util.ArrayList;

import beans.Cliente_DTO;

public interface Cliente_DAO {
	public int agregar(Cliente_DTO usuario);
	
	public ArrayList<Cliente_DTO> listar();
	public Cliente_DTO buscar(String dni);
	
	public int modificar(Cliente_DTO usuario);
	
	public int borrar(String dni);
}
