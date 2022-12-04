package dao;

import interfaces.*;

public class MySQL_DAO_Factory extends DAO_Factory {

	@Override
	public Empleado_DAO getEmpleado() {
		// TODO Auto-generated method stub
		return new MySQL_Empleado_DAO();
	}

	@Override
	public Producto_DAO getProducto() {
		// TODO Auto-generated method stub
		return new MySQL_Producto_DAO();
	}

	@Override
	public Codigo_Nombre_DAO getCargoEmpleado() {
		// TODO Auto-generated method stub
		return new MySQL_CargoEmpleado_DAO();
	}

	@Override
	public Cliente_DAO getCliente() {
		// TODO Auto-generated method stub
		return new MySQL_Cliente_DAO();
	}

	@Override
	public Codigo_Nombre_DAO getCategoriaProducto() {
		// TODO Auto-generated method stub
		return new MySQL_CategoriaProducto_DAO();
	}
}
