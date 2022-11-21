package beans;

import java.io.InputStream;

public class Producto_DTO {
	// Variables
	private int codigo, stock;
	private String nombre;
	private double precio, estrellas;
	private InputStream imagen;
	
	// Constructors
	public Producto_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto_DTO(int codigo, int stock, double estrellas, InputStream imagen, String nombre, double precio) {
		super();
		this.codigo = codigo;
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
}
