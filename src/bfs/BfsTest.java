package bfs;

import org.junit.Test;

import grafo.Grafo;

public class BfsTest {
	@Test
    public void asd(){
		int cantNodos=3;
		 int[][] matAdy = new int[cantNodos][cantNodos];
		 
		 for(int i=0;i<cantNodos;i++)
			 for(int j=0;j<cantNodos;j++)
				 matAdy[i][j] = 99;
		 
		 matAdy[0][1] = 8;
		 matAdy[0][2] = 5;
		 matAdy[1][0] = 2;
		 matAdy[2][1] = 1;
		 Grafo g = new Grafo(cantNodos, matAdy);
		 BFS.bfs(g, 0);
    }
}
