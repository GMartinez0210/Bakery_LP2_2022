package interfaces;

import java.util.ArrayList;

import beans.Producto_DTO;

public interface Producto_DAO {
	public int agregar(Producto_DTO producto);
	
	public ArrayList<Producto_DTO> listar();
	public Producto_DTO buscar(int codigo);
	
	public int modificar(Producto_DTO producto);
	
	public int borrar(int codigo);
}
