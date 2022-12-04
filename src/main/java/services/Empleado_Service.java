package services;

import java.util.ArrayList;

import beans.Empleado_DTO;
import dao.DAO_Factory;
import interfaces.Empleado_DAO;

public class Empleado_Service {
	DAO_Factory factory = DAO_Factory.getDAO_Factory(1);
	
	Empleado_DAO empleado = factory.getEmpleado();
	
	public int agregar(Empleado_DTO newEmpleado) {
		return empleado.agregar(newEmpleado);
	}
	
	public ArrayList<Empleado_DTO> listar() {
		return empleado.listar();
	}
	public Empleado_DTO buscar(String dni) {
		return empleado.buscar(dni);
	}
	
	public int modificar(Empleado_DTO newEmpleado) {
		return empleado.modificar(newEmpleado);
	}
	
	public int borrar(String dni) {
		return empleado.borrar(dni);
	}
	
	public Empleado_DTO verificar(String dni, String contr) {
		return empleado.verificar(dni, contr);
	}
}
