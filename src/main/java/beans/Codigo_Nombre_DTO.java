package beans;

public class Codigo_Nombre_DTO {
	// Variables
	private int codigo;
	private String nombre;
	
	// Constructors
	public Codigo_Nombre_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Codigo_Nombre_DTO(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	// Getters and Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
