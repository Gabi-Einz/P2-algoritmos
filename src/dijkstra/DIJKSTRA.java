package dijkstra;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import grafo.Grafo;

public abstract class DIJKSTRA {
 
 public static List<int[]> dijkstra(Grafo grafo,int idNodoOrigen){
	
	 int[] vectorD = new int[grafo.getCantNodos()];//VECTOR DE COSTOS
	 /****VECTOR P ****************/
	 int[] vectorP = new int[grafo.getCantNodos()];//VECTOR DE PRECEDENCIA
	 
	 for(int i=0;i<grafo.getCantNodos();i++)
		 vectorP[i]=idNodoOrigen;//Seteo el vector de precedencia con el nodoOrigen
	 
	 for(int i=0;i<grafo.getCantNodos();i++)
		 vectorD[i]=grafo.getMatAdy(idNodoOrigen-1, i); //Inicializo vectorD con los valores de la fila E nodoOrigen
	 
	 //System.out.println(Arrays.toString(vectorD));
	 
	 List<Integer> conjuntoSol = new LinkedList<Integer>();
	 List<Integer> conjuntoNoSol = new LinkedList<Integer>();
	 
	 for(int i=0;i<grafo.getCantNodos();i++)
		 conjuntoNoSol.add(i);
	 
	 conjuntoSol.add(idNodoOrigen-1);
	 conjuntoNoSol.remove((Object)(idNodoOrigen-1));
	 
	 int w=0;
	 int resultado=0;
	 
	 while(!conjuntoNoSol.isEmpty()) {
	  w = buscarMinInConjNoSol(vectorD,conjuntoNoSol,grafo);//PASO 1
	 // System.out.println("w : "+w+" "+vectorD[w]);
	  if(w==-1)
		  System.out.println("No se encontro nodo W");
	  
	 conjuntoSol.add(w);
	 conjuntoNoSol.remove((Object)w);
	 
	 //PASO 2
	
	 for(int j=0;j<grafo.getCantNodos();j++) {
		 if(j!=99 && conjuntoNoSol.contains((Object)j)) {
			 resultado=buscarMejorCamino(vectorD,w,j,grafo);
			 if(resultado!=vectorD[j]) { 
				 vectorD[j]=resultado;//ACTUALIZO EL VECTOR D
		         vectorP[j]=w+1;
			 }
		 }//IF
	   }//FOR
	 }//WHILE
	  List<int[]> solucion = new ArrayList<int[]>();
	  solucion.add(vectorD);
	  solucion.add(vectorP);
		 return solucion;
 }
 
 private static int buscarMinInConjNoSol(int[] vectorD,List<Integer> conjuntoNoSol,Grafo grafo){
	 int costoMin=Integer.MAX_VALUE;
	 int idNodo=-1;
	 for(int w=0;w<grafo.getCantNodos();w++) {
		 if(vectorD[w]<costoMin && conjuntoNoSol.contains((Object)w)) {    
			 costoMin = vectorD[w];
			 idNodo = w;
			 }
	 }//FOR
	 return idNodo;
 }
 private static int buscarMejorCamino(int[] vectorD,int w,int j,Grafo grafo){
	 int suma = vectorD[w] + grafo.getMatAdy(w, j);
	
	 return vectorD[j]<=suma ? vectorD[j] : suma;
 }

}
