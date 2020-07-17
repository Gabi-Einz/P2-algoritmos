package floyd;

import java.util.Arrays;
import grafo.Grafo;

public abstract class FLOYD {
	
	public static int[][] floyd(Grafo grafo){
		
		int[][] matKmenos1 = new int[grafo.getCantNodos()][grafo.getCantNodos()];
		//Obtengo F0
		for(int i=0;i<grafo.getCantNodos();i++)
			for(int j=0;j<grafo.getCantNodos();j++) {
				if(i==j)
					matKmenos1[i][j]=0;
				else
				matKmenos1[i][j]=grafo.getMatAdy(i, j);
			}
		//mostrarMatriz(matKmenos1);
		int idNodo=0;
		while(idNodo<grafo.getCantNodos()){
			
			int[][] matK = new int[grafo.getCantNodos()][grafo.getCantNodos()];
			
			for(int i=0;i<grafo.getCantNodos();i++)
				for(int j=0;j<grafo.getCantNodos();j++){
					
					if(i==j || i==idNodo || j==idNodo)
						matK[i][j]=matKmenos1[i][j];
					else
						matK[i][j]=calcularNewMin(matKmenos1,i,j,idNodo);
				}
			matKmenos1 = matK;
			/*System.out.println("*****************");
			mostrarMatriz(matKmenos1);*/
			idNodo++;
		}
		return matKmenos1;
	}
	private static int calcularNewMin(int[][] matKmenos1,int i,int j,int idNodo){
		int suma = matKmenos1[i][idNodo] + matKmenos1[idNodo][j];
		
		return matKmenos1[i][j]<=suma ? matKmenos1[i][j] : suma; 
	}
	public static void mostrarMatriz(int[][] mat){
		for(int i=0;i<mat.length;i++)
			System.out.println(Arrays.toString(mat[i]));
	}
}
