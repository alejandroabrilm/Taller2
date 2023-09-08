package logica;

import java.util.ArrayList;

public class Combo {
	private double descuento;
	private String nombreCombo;
	private static ArrayList<ProductoMenu> itemsCombo ;
	
	
		
	public Combo(double descuento, String nombreCombo) {
		itemsCombo = new ArrayList<ProductoMenu>();
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
	}



	public static void agregarItemCombo(ProductoMenu itemCombo) {
		itemsCombo.add(itemCombo);
	}



	public double getDescuento() {
		return descuento;
	}



	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}



	public String getNombreCombo() {
		return nombreCombo;
	}



	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}
		
	public int getPrecio() {
		int precioActual = 0;
		for (int i = 0; i < itemsCombo.size(); i++) {
			ProductoMenu productoActual = itemsCombo.get(i);
			precioActual += productoActual.getPrecioBase();
		}
	return precioActual;
					
		}
	
	public String generarTextoFactura() {
		double precioIva = getPrecio() * 0.19;
		double precioTotal = getPrecio() + precioIva;
		String respuesta = getPrecio()+ "," + precioIva + "," + precioTotal;
		return respuesta;
			
	}
}

