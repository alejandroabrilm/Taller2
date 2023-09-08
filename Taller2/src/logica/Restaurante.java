package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Restaurante {
	private ArrayList <Ingrediente> ingredientes;
	private static ArrayList <ProductoMenu> menubase;
	private static ArrayList <Combo> combos;
	private static ArrayList <String> nombreMenus;
	
	private void cargarIngrediente(File nombreArchivo) throws IOException{
		Scanner scan = new Scanner(nombreArchivo);
		while (scan.hasNextLine()) {;
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombreIngrediente = partes[0];
			int costoAdicional = Integer.parseInt(partes[1]);
			Ingrediente nuevo = new Ingrediente(nombreIngrediente,costoAdicional);
			ingredientes.add(nuevo);
		}
		scan.close();
	}
	
	
	private static void cargarProductoMenu(File nombreArchivo) throws IOException{
		nombreMenus = new ArrayList <String>();
		menubase = new ArrayList <ProductoMenu>();
		Scanner scan = new Scanner(nombreArchivo);
		while (scan.hasNextLine()) {;
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombreProducto = partes[0];
			int precioBase = Integer.parseInt(partes[1]);
			ProductoMenu nuevo = new ProductoMenu(nombreProducto,precioBase);
			nombreMenus.add(nombreProducto);
			menubase.add(nuevo);
		}
		scan.close();
	}
	private static void cargarCombo(File nombreArchivo) throws IOException{
		combos = new ArrayList <Combo>();
		Scanner scan = new Scanner(nombreArchivo);
		while (scan.hasNextLine()) {;
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String nombreCombo = partes[0];
			String descuentoConP = partes[1].replace("%", "");
			double descuento = Double.parseDouble(descuentoConP);
			for (int i = 2; i < partes.length; i++){
				int indice = nombreMenus.indexOf(partes[i]);
				ProductoMenu producto = menubase.get(indice);
				Combo.agregarItemCombo(producto);
			}
			Combo nuevo = new Combo(descuento,nombreCombo);
			combos.add(nuevo);
		}
		scan.close();
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}


	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}


	public ArrayList<ProductoMenu> getMenubase() {
		return menubase;
	}


	public void setMenubase(ArrayList<ProductoMenu> menubase) {
		this.menubase = menubase;
	}
	public static void main(String[] args) throws IOException {
		File menu = new File("./data/menu.txt");
		File comboss = new File("./data/combos.txt");
		
		cargarProductoMenu(menu);
		cargarCombo(comboss);
		System.out.println(menubase);
		//System.out.println(combos);
		//System.out.println(combos);
		
	}
	
}
