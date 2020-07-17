package bfs;

import java.util.LinkedList;
import java.util.Queue;
import grafo.Grafo;
public abstract class BFS {
	public static void bfs(Grafo grafo,int idNodoOrigen){

		Queue<Integer> cola = new LinkedList<Integer>();
		boolean[] visitados = new boolean[grafo.getCantNodos()];

		cola.add(idNodoOrigen);
		visitados[idNodoOrigen]=true;
		System.out.println("BFS idNodoOrigen: "+idNodoOrigen);

		int nodoActual=0;

		while(!cola.isEmpty()){
		nodoActual = cola.poll(); //SACAMOS PRIMERO DE LA COLA
		 for(int j=0;j<grafo.getCantNodos();j++){
		     if(grafo.getMatAdy(nodoActual,j)!=99)
		      if(!visitados[j]){
		        visitados[j]=true;
		        /*contadores[idNodoOrigen]=1;
		        contadores[j]+=contadores[nodoActual];//SOLUCION PARA INSPECCIONANDO LA RESERVA
		        return contadores[cantNodos-1];*/
		        System.out.println("BFS idNodo: "+j);
		        cola.add(j);
		        
		       }//IF
		    
		    }//FOR
		 
		}//WHILE

		}//FUNCION
}
