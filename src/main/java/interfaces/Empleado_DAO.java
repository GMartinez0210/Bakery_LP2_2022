package interfaces;

import java.util.ArrayList;

import beans.Empleado_DTO;

public interface Empleado_DAO {
	public int agregar(Empleado_DTO empleado);
	
	public ArrayList<Empleado_DTO> listar();
	public Empleado_DTO buscar(String dni);
	
	public int modificar(Empleado_DTO empleado);
	
	public int borrar(String dni);	
	
	public Empleado_DTO verificar(String dni, String contrasenna);
}
