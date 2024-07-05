package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class Recorridos {
	private static <T> void dfs(Vertex<T> vertice, Graph<T> grafo, boolean[] visitados, List<T> lista) {
		visitados[vertice.getPosition()]= true;
		lista.add(vertice.getData());
		for (Edge<T> arista : grafo.getEdges(vertice)) {
			Vertex<T> aux = arista.getTarget();
			if (!visitados[aux.getPosition()]) {
				dfs(aux,grafo,visitados,lista);
			}
		}
	}
	
	public static <T> List<T> dfs(Graph<T> grafo){
		boolean [] visitados = new boolean[grafo.getSize()];
		List<T> lista = new ArrayList<>();
		for (int i= 0; i < grafo.getSize(); i++) {
			if(!visitados[i]) {
				dfs(grafo.getVertex(i), grafo, visitados, lista);
			}
		}
		return lista;
	}
	
	public static <T> List<T> bfs(Graph<T> grafo){
		boolean[] visitados = new boolean [grafo.getSize()];
		List<T> lista = new ArrayList<>();
		List<Vertex<T>> cola = new ArrayList<>();
		cola.add(grafo.getVertex(0));
		visitados[0] = true;
		cola.add(null);
		while(!cola.isEmpty()) {
			Vertex<T> vertice = cola.removeFirst();
			if(vertice != null) {
				lista.add(vertice.getData());
				for(Edge<T> arista : grafo.getEdges(vertice)) {
					Vertex<T> aux = arista.getTarget();
					if (!visitados[aux.getPosition()]) {
						visitados[aux.getPosition()]= true;
						cola.add(aux);
					}
				}
			} else if (!cola.isEmpty()) {
				cola.add(null);
			}
		}
		return lista;
	}
}
