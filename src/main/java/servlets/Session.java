package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cliente_DTO;
import beans.Empleado_DTO;
import services.Cliente_Service;
import services.Empleado_Service;

/**
 * Servlet implementation class Session
 */
@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Empleado_Service empleadoService = new Empleado_Service();
	Cliente_Service clienteService = new Cliente_Service();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session() {
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
		case "iniciar":
			iniciar(req, res);
			break;
		case "cerrar":
			cerrar(req, res);
			break;
		default:
			break;
		}
	}

	private void cerrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Cerrando la sesion actual ID: "+req.getSession().getId());
		req.getSession().invalidate();
		req.getRequestDispatcher("/login.jsp").forward(req, res);
	}

	private void iniciar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Session iniciada");
		
		String url, mensaje;
		
		String dni = req.getParameter("dni");
		String contrasenna = req.getParameter("contrasenna");
		
		HttpSession session = req.getSession();
		
		Cliente_DTO cliente = clienteService.verificar(dni, contrasenna);
		Empleado_DTO empleado = empleadoService.verificar(dni, contrasenna);
		
		if(!(cliente.getDni() == null && empleado.getDni() == null)) {
			// validadando si entro un cliente
			if(!(cliente.getDni() == null)) {
				url = "home.jsp";
				mensaje = "<script>alert('Bienvenido '"+cliente.getNombre() +" "+cliente.getApellidos()+")</script>";
				session.setAttribute("user", cliente);
				System.out.println(cliente.toString());
			} else {
				url = "loginEmpleado.jsp";
				mensaje = "<script>alert(Bienvenido "+cliente.getNombre() +" "+cliente.getApellidos()+")</script>";
				session.setAttribute("user", empleado);
				System.out.println(empleado.toString());
			}
		} else {
			url = "login.jsp";
			mensaje = "<script>alert('DNI o Contraseña incorrecta')</script>";
		}
		
		session.setAttribute("aviso", mensaje);
		res.sendRedirect(url);
	}


}
