package dao;

import java.util.ArrayList;

import beans.Cliente_DTO;
import interfaces.Cliente_DAO;

public class MySQL_Cliente_DAO implements Cliente_DAO {

	@Override
	public int agregar(Cliente_DTO usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Cliente_DTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente_DTO buscar(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modificar(Cliente_DTO usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int borrar(String dni) {
		// TODO Auto-generated method stub
		return 0;
	}

}
