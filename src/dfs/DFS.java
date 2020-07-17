package dfs;

import java.util.Stack;
import grafo.Grafo;
public abstract class DFS {
	//public DFS(){}
	public static void dfs(Grafo grafo, int idNodoOrigen){

		Stack<Integer> pila = new Stack<Integer>();
		boolean[] visitados = new boolean[grafo.getCantNodos()]; //Inicialmente estan todos en false

		 pila.push(idNodoOrigen);//APILAR
		 visitados[idNodoOrigen]=true;
		 System.out.println("DFS idNodoOrigen: "+idNodoOrigen);
		 int nodoActual=0;
		while(!pila.empty()){
		    nodoActual=pila.peek();//VISITAR CIMA DE LA PILA
		 for(int j=0;j<grafo.getCantNodos();j++){
		    if(grafo.getMatAdy(nodoActual,j)!=99)
		            if(!visitados[j]){
		                  pila.push(j);//APILAR NODO ADYACENTE
		                  visitados[j]=true;
		                  System.out.println("DFS idNodo visitado: "+j);
		                   break;
		                  }//IF
		         }//FOR
		      if(pila.peek()==nodoActual)
		           pila.pop();//DESAPILAR
		   }//WHILE

		}//FUNCION
}
