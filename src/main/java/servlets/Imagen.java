package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MySQL_Imagen_DAO;

/**
 * Servlet implementation class Imagen
 */
@WebServlet("/Imagen")
public class Imagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	MySQL_Imagen_DAO mySqlImagenDao = new MySQL_Imagen_DAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imagen() {
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
		buscarCodigo(req, res);
	}
	
	private void buscarCodigo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		mySqlImagenDao.buscar(codigo, res);
	}
	
}
