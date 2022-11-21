package services;

import java.util.ArrayList;

import beans.Producto_DTO;
import dao.DAO_Factory;
import interfaces.Producto_DAO;

public class Producto_Service {
	DAO_Factory factory = DAO_Factory.getDAO_Factory(1);
	
	Producto_DAO producto = factory.getProducto();
	
	public int agregar(Producto_DTO newProducto) {
		return producto.agregar(newProducto);
	}
	
	public ArrayList<Producto_DTO> listar() {
		return producto.listar();
	}
	
	public Producto_DTO buscar(int codigo) {
		return producto.buscar(codigo);
	}
	
	public int modificar(Producto_DTO newProducto) {
		return producto.modificar(newProducto);
	}
	
	public int borrar(int codigo) {
		return producto.borrar(codigo);
	}
}
  