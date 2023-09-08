package logica;

public class ProductoMenu {
	
	private String nombre;
	private int precioBase;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecioBase() {
		return precioBase;
	}
	
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}
	
	public ProductoMenu(String nombre, int precioBase2) {
		super();
		this.nombre = nombre;
		this.precioBase = precioBase2;
	}
	
	public String generarTextoFactura() {
		double precioIva = precioBase * 0.19;
		double precioTotal = precioBase + precioIva;
		String respuesta =  + precioBase + "," + precioIva + "," + precioTotal;
		return respuesta;
			
	}

}
