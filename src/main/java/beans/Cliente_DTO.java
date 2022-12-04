package beans;

import java.io.InputStream;

public class Cliente_DTO {
	// Variables
	private String dni, email, clave, nombre, apellidos;
	private InputStream avatar;
	
	// Constructors
	public Cliente_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente_DTO(String dni, String email, String clave, String nombre, String apellidos, InputStream avatar) {
		super();
		this.dni = dni;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.avatar = avatar;
	}

	// Getters and Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public InputStream getAvatar() {
		return avatar;
	}

	public void setAvatar(InputStream avatar) {
		this.avatar = avatar;
	}
}
