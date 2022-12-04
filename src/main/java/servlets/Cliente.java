package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cliente_DTO;
import beans.Empleado_DTO;
import services.Cliente_Service;

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
		
		switch (tipo) {
		case "registrarse":
			registrarse(req, res);
			break;
		case "editar":
			editar(req, res);
			break;
		case "eliminar":
			eliminarAuto(req, res);
			break;
		default:
			break;
		}
	}

	private void eliminarAuto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String dni = req.getParameter("deleteAcount");
		int result = clienteService.borrar(dni);
		
		System.out.println(dni);
		System.out.println(result);
		// si no elimino
		if(result == -1) {
			String mensaje = "<script>alert(Ocurrio un error al momento de eliminar)</script>";
			
			req.setAttribute("aviso", mensaje);
			res.sendRedirect("perfil.jsp");
		// si elimino
		} else {
			String mensaje = "<script>alert(Cuenta eliminada)</script>";
			req.setAttribute("aviso", mensaje);
			req.getSession().invalidate();
			res.sendRedirect("login.jsp");
		}
		
		//req.getRequestDispatcher("login.jsp").forward(req, res);
	}

	private void editar(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String clave = req.getParameter("contrasenna");
		String dni = req.getParameter("dni");
		String email = req.getParameter("email");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		
		Cliente_DTO cliente= new Cliente_DTO();
		cliente.setDni(dni);
		cliente.setEmail(email);
		cliente.setClave(clave);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellido);
		cliente.setAvatar(null);
		
		int actualizar = clienteService.modificar(cliente);
		
		HttpSession session = req.getSession();
		Cliente_DTO c = clienteService.buscar(dni);
		session.setAttribute("user", c);
		res.sendRedirect("perfil.jsp");
		System.out.println(actualizar);
	}

	private void registrarse(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String clave = req.getParameter("contra");
		String dni = req.getParameter("dni");
		String email = req.getParameter("email");
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		
		Cliente_DTO cliente= new Cliente_DTO();
		cliente.setDni(dni);
		cliente.setEmail(email);
		cliente.setClave(clave);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellido);
		
		int agregar = clienteService.agregar(cliente);
		System.out.println(agregar);
		
		// si no registro
		if(agregar == -1) {
			String mensaje = "<script>alert(Ocurrio un error al momento de registrarse)</script>";
			
			req.setAttribute("aviso", mensaje);
			res.sendRedirect("register.jsp");
		// si registro
		} else {
			String mensaje = "<script>alert(Bienvenido "+cliente.getNombre() +" "+cliente.getApellidos()+")</script>";
			
			req.setAttribute("aviso", mensaje);
			res.sendRedirect("home.jsp");
		}
		
	}

}
