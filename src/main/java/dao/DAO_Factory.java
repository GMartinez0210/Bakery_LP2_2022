package dao;

import interfaces.Empleado_DAO;
import interfaces.Producto_DAO;
import interfaces.Usuario_DAO;

public abstract class DAO_Factory {
	public static final int MYSQL = 1;
	
	public abstract Empleado_DAO getEmpleado();
	public abstract Producto_DAO getProducto();
	public abstract Usuario_DAO getUsuario();
	
	public static DAO_Factory getDAO_Factory(int whichFactory) {
		switch(whichFactory) {
			case MYSQL:
				return new MySQL_DAO_Factory();
			default:
				return null;
		}
	}
}
