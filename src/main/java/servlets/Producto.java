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

import beans.Producto_DTO;
import services.Producto_Service;

@MultipartConfig
/**
 * Servlet implementation class Producto
 */
@WebServlet("/Producto")
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Producto_Service productoService = new Producto_Service();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
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
		String nombre = req.getParameter("nombre");
		double precio = Double.parseDouble(req.getParameter("precio"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		double estrellas = Double.parseDouble(req.getParameter("estrellas"));
		
		Part part = req.getPart("imagen");
		InputStream inputStream = part.getInputStream();
		
		Producto_DTO producto = new Producto_DTO();
		producto.setImagen(inputStream);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setStock(stock);
		producto.setEstrellas(estrellas);
		
		int agregar = productoService.agregar(producto);
		
		res.sendRedirect("Producto?tipo=listar");
	}
	
	private void listar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ArrayList<Producto_DTO> productos = productoService.listar();
		req.setAttribute("productos", productos);
		req.getRequestDispatcher("listarProducto.jsp").forward(req, res);
	}
	
	private void buscar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		Producto_DTO producto = productoService.buscar(codigo);
		req.setAttribute("producto", producto);
		req.getRequestDispatcher("modificarProducto.jsp").forward(req, res);
	}
	
	private void modificar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		String nombre = req.getParameter("nombre");
		double precio = Double.parseDouble(req.getParameter("precio"));
		int stock = Integer.parseInt(req.getParameter("stock"));
		double estrellas = Double.parseDouble(req.getParameter("estrellas"));
		
		Part part = req.getPart("imagen");
		InputStream inputStream = part.getInputStream();
		
		Producto_DTO producto = new Producto_DTO();
		producto.setCodigo(codigo);
		producto.setImagen(inputStream);
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setStock(stock);
		producto.setEstrellas(estrellas);
		
		int modificar = productoService.modificar(producto);
		
		res.sendRedirect("Producto?tipo=listar");
	}
	
	private void borrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));

		int borrar = productoService.borrar(codigo);
		
		res.sendRedirect("Producto?tipo=listar");
	}
}
