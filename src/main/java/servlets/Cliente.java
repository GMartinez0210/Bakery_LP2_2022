package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Cliente_DTO;
import services.Cliente_Service;

@MultipartConfig
/**
 * Servlet implementation class Cliente
 */
@WebServlet("/Cliente")
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Cliente_Service clienteService = new Cliente_Service();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String tipo = req.getParameter("tipo");
		
		if(tipo.equals("agregar")) {
			agregar(req, res);
			return;
		}
		
		if(tipo.equals("listar")) {
			listar(req, res);
			return;
		}
		
		if(tipo.equals("buscar")) {
			buscar(req, res);
		return;
		}
		
		if(tipo.equals("modificar")) {
			modificar(req, res);
			return;
		}
		
		if(tipo.equals("borrar")) {
			borrar(req, res);
			return;
		}
	}
	
	private void agregar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String dni = req.getParameter("dni");
		String email = req.getParameter("email");
		String clave = req.getParameter("clave");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		
		Part part = req.getPart("avatar");
		InputStream inputStream = part.getInputStream();
		
		Cliente_DTO cliente = new Cliente_DTO();
		cliente.setDni(dni);
		cliente.setEmail(email);
		cliente.setClave(clave);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setAvatar(inputStream);
		
		int agregar = clienteService.agregar(cliente);
		
		res.sendRedirect("views/cliente/listar.jsp?tipo=listar");
	}
	
	private void listar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendRedirect("views/cliente/listar.jsp?tipo=listar");
	}
	
	private void buscar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String dni = req.getParameter("dni");
		
		Cliente_DTO cliente = clienteService.buscar(dni);
		
		req.setAttribute("cliente", cliente);
		req.getRequestDispatcher("views/cliente/listar.jsp?tipo=buscar").forward(req, res);
	}
	
	private void modificar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String dni = req.getParameter("dni");
		String email = req.getParameter("email");
		String clave = req.getParameter("clave");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		
		Part part = req.getPart("avatar");
		InputStream inputStream = part.getInputStream();
		
		Cliente_DTO cliente = new Cliente_DTO();
		cliente.setDni(dni);
		cliente.setEmail(email);
		cliente.setClave(clave);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setAvatar(inputStream);
		
		int modificar = clienteService.modificar(cliente);
		
		res.sendRedirect("views/cliente/listar.jsp?tipo=listar");
	}
	
	private void borrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String dni = req.getParameter("dni");

		int borrar = clienteService.borrar(dni);
		
		res.sendRedirect("views/cliente/listar.jsp?tipo=listar");
	}
}
