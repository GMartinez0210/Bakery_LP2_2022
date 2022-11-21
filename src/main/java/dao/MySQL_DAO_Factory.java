package dao;

import interfaces.Empleado_DAO;
import interfaces.Producto_DAO;
import interfaces.Usuario_DAO;

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
	public Usuario_DAO getUsuario() {
		// TODO Auto-generated method stub
		return new MySQL_Usuario_DAO();
	}
}
