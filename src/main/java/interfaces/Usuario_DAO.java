package interfaces;

import java.util.ArrayList;

import beans.Usuario_DTO;

public interface Usuario_DAO {
	public int agregar(Usuario_DTO usuario);
	
	public ArrayList<Usuario_DTO> listar();
	public Usuario_DTO buscar(int codigo);
	
	public int modificar(Usuario_DTO usuario);
	
	public int borrar(int codigo);
}
