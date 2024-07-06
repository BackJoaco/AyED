package ejercicio3;
import ejercicio1.*;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapa) {
        this.mapaCiudades = mapa;
    }
	
	private boolean devolverCamino(Vertex<String> vertice, boolean[] visitados, List<String> camino, String ciudad2) {
		camino.add(vertice.getData());
        visitados[vertice.getPosition()] = true;

        if (vertice.getData()==ciudad2) {
            return true;
        }

        for (Edge<String> arista: mapaCiudades.getEdges(vertice)) {
            Vertex<String> v = arista.getTarget();
            if (!visitados[v.getPosition()]) {
                if (devolverCamino(v,visitados,camino,ciudad2)) {
                    return true;
                }
            }
        }
        System.out.println("Removido: "+ camino.removeLast());
        return false;
		
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		boolean[] visitados = new boolean[mapaCiudades.getSize()]; 
        List<String> camino = new ArrayList<String>(); 
        devolverCamino(mapaCiudades.search(ciudad1),visitados, camino, ciudad2);
        return camino;
	}
}