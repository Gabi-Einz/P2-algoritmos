package dijkstra;



import java.util.List;

import org.junit.Test;

import grafo.Grafo;

public class DijkstraTest {
	@Test
 public void asd(){
		
		int cantNodos=5;
		int[][] mat = new int[cantNodos][cantNodos];
		/*EN DIJKSTRA debo setear inicialmente la matriz con un valor alto, para poder
		 hallar los costos minimos*/
		for(int i=0;i<cantNodos;i++)
			for(int j=0;j<cantNodos;j++)
				mat[i][j] = 99; // 99 = no existe arista.
		/*********************************************************************/
		// Seteo un grafo dirigido
		mat[0][1]=4;
		mat[0][3]=1;
		mat[0][4]=6;
		
		mat[1][2]=1;
		mat[2][4]=2;
		
		mat[3][2]=2;
		mat[3][4]=7;
		
	 Grafo g = new Grafo(cantNodos, mat);
	 List<int[]> s = DIJKSTRA.dijkstra(g,1);
	 int num;
      // El primer vector es el de costos.
	 for(int i=0;i<cantNodos;i++){
		 num=i+1;
	 System.out.println("idNodo: "+num+" costoMin: "+s.get(0)[i]);
	 }
	 System.out.println("*******************************");
	 // El segundo vector es el de precedencia.
	 for(int i=0;i<cantNodos;i++){
		 num=i+1;
	 System.out.println("idNodo: "+num+" idNodoPrecede: "+s.get(1)[i]);
	 }
	 //g.mostrarVectorP();
 }
}
