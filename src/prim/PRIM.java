package prim;

import java.util.LinkedList;
import java.util.List;
import grafo.Grafo;

public abstract class PRIM {
  
	//DEVUELVE EL ARBOL DE COSTO MINIMO
	public static Arbol prim(Grafo grafo){
		List<Integer> conjuntoSol = new LinkedList<Integer>(); 
		List<Integer> conjuntoNoSol =  new LinkedList<Integer>();
		for(int i=0;i<grafo.getCantNodos();i++)
			conjuntoNoSol.add(i);
		
		List<Arista> listAristas = new LinkedList<Arista>();
		//AGREGO PRIMER IDNODO AL CONJUNTO SOLUCION, Y LO QUITO DEL OTRO CONJUNTO
		conjuntoSol.add(0);
		conjuntoNoSol.remove((Object)0);
		
		int idNodo;
		//PRIMERO BUSCO EL IDNODO CON LA ARISTA DE MENOR COSTO, LO AGREGO AL CONJUNTO SOL Y LUEGO LO ELIMINO DEL CONJUNTO NO SOL
		while(!conjuntoNoSol.isEmpty()){
			idNodo = buscarIdNodoConAristaDeMenorCosto(listAristas,conjuntoSol,grafo);
			if(idNodo==-1)//Significa que no se encontraron nodos adyacentes, existen nodos sueltos.
				break;
			//System.out.println("idNodo "+idNodo);
			conjuntoNoSol.remove((Object)idNodo);
			conjuntoSol.add(idNodo);
			//System.out.println("TAM CONJUNTO NO SOL "+this.conjuntoNoSol.size());
		}
		//System.out.println(this.conjuntoSol);
		int costoTotalMin = calcularCostoTotalMin(listAristas);
		return new Arbol(costoTotalMin, listAristas);
	}
	private static int buscarIdNodoConAristaDeMenorCosto(List<Arista> listAristas,List<Integer> conjuntoSol,Grafo grafo){
		int costoMin = Integer.MAX_VALUE;
		int costo = 0;
		int nodoOrigen = -1;
		int nodoDestino = -1;
		for(int i=0;i<conjuntoSol.size();i++) {
			for(int j=0;j<grafo.getCantNodos();j++){
				costo = grafo.getMatAdy(conjuntoSol.get(i), j);//Uso el contenido del lista conjuntoSol el cual contiene las idNodo
				if(costo!=0 && costo<costoMin && !conjuntoSol.contains((Object)j)) {
					costoMin = costo;
				    nodoOrigen = conjuntoSol.get(i);
				    nodoDestino = j;
				    }//IF
			}//SEGUNDO FOR
		}//PRIMER FOR
		if(nodoDestino!=-1)
		listAristas.add(new Arista(nodoOrigen, nodoDestino, costoMin));
		
		return nodoDestino;
	}
	
	private static int calcularCostoTotalMin(List<Arista> listAristas){
		int acumulador=0;
		for(Arista element : listAristas)
			acumulador+=element.getCosto();
		return acumulador;
	}
	
}