package dao;

import interfaces.*;

public abstract class DAO_Factory {
	public static final int MYSQL = 1;
	
	public abstract Codigo_Nombre_DAO getCargoEmpleado();
	public abstract Empleado_DAO getEmpleado();
	public abstract Cliente_DAO getCliente();
	
	public abstract Codigo_Nombre_DAO getCategoriaProducto();
	public abstract Producto_DAO getProducto();
	
	
	public static DAO_Factory getDAO_Factory(int whichFactory) {
		switch(whichFactory) {
			case MYSQL:
				return new MySQL_DAO_Factory();
			default:
				return null;
		}
	}
}
