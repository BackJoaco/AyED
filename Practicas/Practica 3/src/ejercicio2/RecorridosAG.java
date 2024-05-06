package ejercicio2;
import java.util.*;
import ejercicio1.*;
import ejercicio1.Queue;

public class RecorridosAG {
	private List<Integer> lista;
	public static boolean esImpar(int n) {
		return n % 2  !=0;
	}
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		int dato = a.getData();
		if ((dato % 2 != 0) && (dato > n)) {
			lista.add(dato);
;		}
		if (a.hasChildren()) { // si el nodo tiene hijos
			List<GeneralTree<Integer>> l = a.getChildren(); // obtenemos la lista de hijos
			for (GeneralTree<Integer> hijo : l) { // iteramos sobre esa lista 
				numerosImparesMayoresQuePreOrden(hijo, n); // los procesamos recursivamente
			}
		}
		return lista;
	}
	
	private static void  InOrden (List<Integer> lista,GeneralTree<Integer> a, Integer n) {
		if (!a.isEmpty()) {
			int i = 0;
			for (GeneralTree<Integer> child:a.getChildren()) {
				i++;
				InOrden(lista, child, n);
				if ((i==1) && (a.getData()>n) && (esImpar(a.getData()))) {
					lista.add(a.getData());
				}
			}
			if ((i==0) && (a.getData()>n) && (esImpar(a.getData()))) {
				lista.add(a.getData());
			}
		}
	}
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> list = new LinkedList<Integer>();
		InOrden(list, a, n);
		return list;
	}
	
	private static void postOrden(List<Integer> lista, GeneralTree<Integer> a, Integer n) {
		if (a.hasChildren()) {
			for (GeneralTree<Integer> hijo : a.getChildren()) {
				postOrden(lista, hijo, n);
			}
		}
		int dato = a.getData();
		if ((dato > n) && (dato % 2 != 0)) {
			lista.add(dato);
		}
		
 	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		List<Integer> list = new LinkedList<Integer>();
		postOrden(list, a, n);
		return list;
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if (!a.isEmpty()) {
			Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
			cola.enqueue(a);
			while (!cola.isEmpty()) {
				GeneralTree<Integer> aux = cola.dequeue();
				if ((aux.getData() % 2 == 0) && (aux.getData() > n)) {
					lista.add(aux.getData());
				}
				if(aux.hasChildren()) {
					for (GeneralTree<Integer> hijo : aux.getChildren()) {
						cola.enqueue(hijo);
					}
				}
			}
		}
		return lista;
	}


}
