package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario_DTO;
import beans.Usuario_DTO;
import beans.Usuario_DTO;
import beans.Usuario_DTO;
import services.Usuario_Service;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Usuario_Service usuarioService = new Usuario_Service();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usuario() {
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
		String usuario = req.getParameter("usuario");
		String clave = req.getParameter("clave");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		
		Usuario_DTO producto = new Usuario_DTO();
		producto.setUsuario(usuario);
		producto.setClave(clave);
		producto.setNombre(nombre);
		producto.setApellidos(apellidos);
		
		int agregar = usuarioService.agregar(producto);
		
		res.sendRedirect("Usuario?tipo=listar");
	}

	private void listar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Usuario_DTO> usuarios = usuarioService.listar();
		req.setAttribute("usuarios", usuarios);
		req.getRequestDispatcher("listarUsuario.jsp").forward(req, res);
	}

	private void buscar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		Usuario_DTO usuario = usuarioService.buscar(codigo);
		req.setAttribute("usuario", usuario);
		req.getRequestDispatcher("modificarUsuario.jsp").forward(req, res);
	}

	private void modificar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		String clave = req.getParameter("clave");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		String usuario2 = req.getParameter("usuario");
		
		Usuario_DTO usuario = new Usuario_DTO();
		usuario.setCodigo(codigo);
		usuario.setClave(clave);
		usuario.setNombre(nombre);
		usuario.setApellidos(apellidos);
		usuario.setUsuario(usuario2);
		
		int modificar = usuarioService.modificar(usuario);
		
		res.sendRedirect("Usuario?tipo=listar");
	}
	
	private void borrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
				
		int borrar = usuarioService.borrar(codigo);
		
		res.sendRedirect("Usuario?tipo=listar");		
	}
}
