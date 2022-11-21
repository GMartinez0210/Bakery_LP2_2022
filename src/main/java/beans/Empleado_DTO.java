package beans;

public class Empleado_DTO {
	// Variables
	private int codigo;
	private String clave, nombre, apellidos;
	
	// Constructors
	public Empleado_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado_DTO(int codigo, String clave, String nombre, String apellidos) {
		super();
		this.codigo = codigo;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	// Getters and Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
}
