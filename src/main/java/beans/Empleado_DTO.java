package beans;

public class Empleado_DTO {
	// Variables
	private String dni, email, clave, nombre, apellidos;
	private int codigoCargo;
	private double sueldo;
	
	// Constructors
	public Empleado_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado_DTO(String dni, String email, String clave, String nombre, String apellidos, int codigoCargo,
			double sueldo) {
		super();
		this.dni = dni;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.codigoCargo = codigoCargo;
		this.sueldo = sueldo;
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

	public int getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(int codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado_DTO [dni=" + dni + ", email=" + email + ", clave=" + clave + ", nombre=" + nombre
				+ ", apellidos=" + apellidos + ", codigoCargo=" + codigoCargo + ", sueldo=" + sueldo + "]";
	}
}
