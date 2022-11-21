package beans;

public class Usuario_DTO {
	// Variables
	private int codigo;
	private String usuario, clave, nombre, apellidos;
	
	// Constructors
	public Usuario_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario_DTO(int codigo, String usuario, String clave, String nombre, String apellidos) {
		super();
		this.codigo = codigo;
		this.usuario = usuario;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
