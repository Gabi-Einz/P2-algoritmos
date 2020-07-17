package prim;

import java.util.List;

public class Arbol {
   
	private int costoMin;
	private List<Arista> listAristas;
	
	public Arbol(int costoMin, List<Arista> listAristas) {
		this.costoMin = costoMin;
		this.listAristas = listAristas;
	}
	
	public void mostrarCostoMin(){
		System.out.println("el costo del arbol es: "+this.costoMin);
	}
	
	public void mostrarAristas(){
		System.out.println("El arbol contiene las siguientes aristas: ");
		for(Arista element : this.listAristas)
			System.out.println(element.toString());
	}
}
