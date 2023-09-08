package logica;

public class ProductoAjustado {
	private ProductoMenu base1;
	private Ingrediente agregados;
	private Ingrediente eliminados;
	
	public ProductoAjustado(ProductoMenu base1, Ingrediente agregados, Ingrediente eliminados) {
		super();
		this.base1 = base1;
		this.agregados = agregados;
		this.eliminados = eliminados;
		}
	
	public String darNombre() {;
		return base1.getNombre();
		}
	public int darPrecio() {
		return base1.getPrecioBase();
		}
	public String generarTextoFactura() {
		double precioIva = (darPrecio() + agregados.getCostoAdicional() - eliminados.getCostoAdicional()) * 0.19;
		double precioTotal = (darPrecio() + agregados.getCostoAdicional() - eliminados.getCostoAdicional()) + precioIva;
		String respuesta =  + darPrecio() + "," + precioIva + "," + precioTotal;
		return respuesta;
		}
}