package beans;

import java.io.InputStream;

public class Producto_DTO {
	// Variables
	private int codigo, codigoCategoria, stock;
	private String nombre, nombreCategoria;
	private double precio, estrellas;
	private InputStream imagen;
	
	// Constructors
	public Producto_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto_DTO(int codigo, int codigoCategoria, int stock, double estrellas, InputStream imagen, String nombre, String nombreCategoria, double precio) {
		super();
		this.codigo = codigo;
		this.codigoCategoria = codigoCategoria;
		this.nombreCategoria = nombreCategoria;
		this.stock = stock;
		this.estrellas = estrellas;
		this.imagen = imagen;
		this.nombre = nombre;
		this.precio = precio;
	}

	// Getters and Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(double estrellas) {
		this.estrellas = estrellas;
	}

	public InputStream getImagen() {
		return imagen;
	}

	public void setImagen(InputStream imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
}
