package warshall;

import java.util.Arrays;

import grafo.Grafo;

public abstract class WARSHALL{
	
	public static boolean[][] warshall(Grafo grafo){
		
		boolean[][] matKmenos1 = new boolean[grafo.getCantNodos()][grafo.getCantNodos()];
		//Obtengo F0
		for(int i=0;i<grafo.getCantNodos();i++)
			for(int j=0;j<grafo.getCantNodos();j++) {
				if(i==j || grafo.getMatAdy(i, j)==99)
					matKmenos1[i][j]=false;
				else
				matKmenos1[i][j]=true;
			}
		//mostrarMatrizBoolean(matKmenos1);
		int idNodo=0;
		while(idNodo<grafo.getCantNodos()){
			
			boolean[][] matK = new boolean[grafo.getCantNodos()][grafo.getCantNodos()];
			
			for(int i=0;i<grafo.getCantNodos();i++)
				for(int j=0;j<grafo.getCantNodos();j++){
					
					if(i==j || i==idNodo || j==idNodo)
						matK[i][j]=matKmenos1[i][j];
					else
						matK[i][j]=existeCamino(matKmenos1,i,j,idNodo);
				}
			matKmenos1 = matK;
			/*System.out.println("*****************");
			mostrarMatrizBoolean(matKmenos1);*/
			idNodo++;
		}
		return matKmenos1;
	}
	private static boolean existeCamino(boolean[][] matKmenos1,int i,int j,int idNodo){
		return matKmenos1[i][j] || (matKmenos1[i][idNodo] && matKmenos1[idNodo][j]);
	}
	
	public static void mostrarMatrizBoolean(boolean[][] mat){
		for(int i=0;i<mat.length;i++)
			System.out.println(Arrays.toString(mat[i]));
	}
}
