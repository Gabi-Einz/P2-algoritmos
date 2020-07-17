package prim;

import org.junit.Test;

import grafo.Grafo;

public class PrimTest {
	@Test
  public void asd(){
	  int cantNodos=5;
	  int[][] m = new int[cantNodos][cantNodos];
	  //La matriz se setea con ceros por defecto, 0 = no existe arista.
	  //ARMO MATRIZ SIMETRICA
/*NOTAS: si es un grafo no dirigido entonces debe ser simetrica la matriz.
	     si es un grafo dirigido entonces no necesariamente debe ser simetrica la matriz.*/
	  
	  m[0][1]=14;
	  m[1][0]=14;
	  m[1][4]=5;
	  m[4][1]=5;
	  m[2][1]=13;
	  m[1][2]=13;
	  m[3][4]=2;
	  m[4][3]=2;
	  m[4][0]=1;
	  m[0][4]=1;
	  	  
	  Grafo g = new Grafo(cantNodos, m);
	 
	  g.mostrarGrafo();
	  Arbol a = PRIM.prim(g);
	  a.mostrarCostoMin();
	  a.mostrarAristas();
  }
}
