package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Empleado_DTO;
import services.Empleado_Service;

/**
 * Servlet implementation class Empleado
 */
@WebServlet("/Empleado")
public class Empleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Empleado_Service empleadoService = new Empleado_Service();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Empleado() {
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
		String clave = req.getParameter("clave");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		
		Empleado_DTO empleado = new Empleado_DTO();
		empleado.setClave(clave);
		empleado.setNombre(nombre);
		empleado.setApellidos(apellidos);
		
		int agregar = empleadoService.agregar(empleado);
		
		res.sendRedirect("Empleado?tipo=listar");
	}

	private void listar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Empleado_DTO> empleados = empleadoService.listar();
		req.setAttribute("empleados", empleados);
		req.getRequestDispatcher("listarEmpleado.jsp").forward(req, res);
	}
	
	private void buscar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String codigo = req.getParameter("codigo");
		Empleado_DTO empleado = empleadoService.buscar(codigo);
		req.setAttribute("empleado", empleado);
		req.getRequestDispatcher("modificarEmpleado.jsp").forward(req, res);
	}

	private void modificar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String codigo = req.getParameter("codigo");
		String clave = req.getParameter("clave");
		String nombre = req.getParameter("nombre");
		String apellidos = req.getParameter("apellidos");
		
		Empleado_DTO empleado = new Empleado_DTO();
		empleado.setDni(codigo);
		empleado.setClave(clave);
		empleado.setNombre(nombre);
		empleado.setApellidos(apellidos);
		
		int modificar = empleadoService.modificar(empleado);
		
		res.sendRedirect("Empleado?tipo=listar");
	}
	
	private void borrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String codigo = req.getParameter("codigo");
		
		int borrar = empleadoService.borrar(codigo);
		
		res.sendRedirect("Empleado?tipo=listar");		
	}
}
