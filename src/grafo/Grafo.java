package grafo;

import java.util.Arrays;

public class Grafo {
  private int cantNodos;
  private int[][] matAdy;
  
public Grafo(int cantNodos, int[][] matAdy) {
	this.cantNodos = cantNodos;
	this.matAdy = matAdy;
}

public int getCantNodos() {
	return cantNodos;
}

public void setCantNodos(int cantNodos) {
	this.cantNodos = cantNodos;
}

public int getMatAdy(int fil, int col){
	return this.matAdy[fil][col];
}

public void mostrarGrafo(){
	System.out.println("*********GRAFO***********");
	System.out.println("Cantidad de nodos: "+this.cantNodos);
	System.out.println("Matriz de adyacencia: ");
	for(int i=0;i<this.cantNodos;i++)
		System.out.println(Arrays.toString(this.matAdy[i]));
	System.out.println("*************************");
}
}
