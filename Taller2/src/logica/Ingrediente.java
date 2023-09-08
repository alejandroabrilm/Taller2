package logica;



public class Ingrediente {
	private String nombre;
	private int costoAdicional;


	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCostoAdicional() {
		return costoAdicional;
	}
	
	public void setCostoAdicional(int costoAdicional) {
		this.costoAdicional = costoAdicional;
	}

	public Ingrediente(String nombre, int costoAdicional) {
		super();
		this.nombre = nombre;
		this.costoAdicional = costoAdicional;
	}
}
		
	
	


