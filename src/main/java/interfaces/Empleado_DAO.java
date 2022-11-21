package interfaces;

import java.util.ArrayList;

import beans.Empleado_DTO;

public interface Empleado_DAO {
	public int agregar(Empleado_DTO empleado);
	
	public ArrayList<Empleado_DTO> listar();
	public Empleado_DTO buscar(int codigo);
	
	public int modificar(Empleado_DTO empleado);
	
	public int borrar(int codigo);
	
	//public ArrayList<Equipo_DTO> filtrar();
}
