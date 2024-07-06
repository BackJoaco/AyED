package ejercicio3;
import ejercicio1.*;
import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapa) {
        this.mapaCiudades = mapa;
    }
	
	// PUNTO 1
	
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
        camino.removeLast();
        return false;
		
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		boolean[] visitados = new boolean[mapaCiudades.getSize()];
        List<String> camino = new ArrayList<String>(); 
        Vertex<String> vertice = this.mapaCiudades.search(ciudad1);
        if (vertice != null) {
        	devolverCamino(vertice,visitados, camino, ciudad2);
        }
        return camino;
	}
	
	// PUNTO 2
	
	private boolean devolverCaminoExceptuando(Vertex<String> vertice, boolean [] visitados, List<String> camino, List<String> ciudades, String destino) {
		camino.add(vertice.getData());
		visitados[vertice.getPosition()]= true;
		
		if (vertice.getData() == destino) {
			return true;
		}
		
		for (Edge<String> arista : this.mapaCiudades.getEdges(vertice)) {
			Vertex<String> v =  arista.getTarget();
			if(!visitados[v.getPosition()]) {
				if(devolverCaminoExceptuando(v, visitados, camino, ciudades, destino)) {
					return true;
				}
			}
		}

		camino.removeLast();
		return false;
	}
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new ArrayList<>();
		boolean [] visitados = new boolean[this.mapaCiudades.getSize()];
		for (String ciudad : ciudades) {
			visitados[this.mapaCiudades.search(ciudad).getPosition()] = true;
		}
		Vertex<String> vertice = this.mapaCiudades.search(ciudad1);
		if (vertice != null) {
			devolverCaminoExceptuando(vertice, visitados, camino, ciudades, ciudad2);
		}
		return camino;
	}
	
	// PUNTO 2 DE EZE
	
	public List<String> devolverCaminoExceptuando2(String ciudad1, String ciudad2, List<String> camino){
	    boolean [] visitados = new boolean [this.mapaCiudades.getSize()];
	    List<String> camino2 = new ArrayList<>();
	    if ((this.mapaCiudades.search(ciudad1) != null) && (this.mapaCiudades.search(ciudad2) != null)){ 
	        int i = this.mapaCiudades.search(ciudad1).getPosition();
	        devolverCaminoExceptuando2(i, ciudad2, visitados, camino2, camino);
	    }return camino2;

	}

	private boolean devolverCaminoExceptuando2(int pos, String ciudad2, boolean[] visitados, List<String> camino, List<String> caminoEx){
	    Vertex<String> v = this.mapaCiudades.getVertex(pos);
	    visitados [pos] = true;
	    boolean aux = false;

	    if (v.getData().equals(ciudad2) && !(caminoEx.contains(v.getData()))){
	        camino.add(v.getData());
	        aux = true; 
	    } else {
	        List<Edge<String>> adyEdges = this.mapaCiudades.getEdges(v);
	        for(Edge<String> e : adyEdges){
	            int j = e.getTarget().getPosition();
	            if (!visitados[j] && !(aux) && !(caminoEx.contains(v.getData()))){
	            	System.out.println(v.getData());
	                camino.add(v.getData());
	                aux = devolverCaminoExceptuando2(j, ciudad2, visitados, camino, caminoEx);
	            } else if (!aux && !camino.isEmpty()) {
	                camino.remove(camino.size()-1);
	            }
	        }
	    }

	    return aux;
	}
	
	// PUNTO 3
	
	private void caminoMasCorto(Vertex<String> ciudad,String ciudad2,boolean[] visitados,Recorrido aux, Recorrido min) {
		// Agrego al camino auxiliar la ciudad del vertice actual
        aux.ciudades.add(ciudad.getData());
        // Marco como visitado en el vector el vertice actual
        visitados[ciudad.getPosition()] = true;
        // Si el vertice actual es igual al destino y el peso del camino auxiliar es menor al peso del camino minimo
        if ((ciudad.getData()==ciudad2) && (aux.peso<min.peso)) {
        	// Actualizo el camino minimo
            min.ciudades = new LinkedList<>(aux.ciudades);
            // Actualizo el peso minimo
            min.peso = aux.peso;
        }
        // Creo backup de la longitud
        int auxLBak = aux.ciudades.size();
        // Creo backup del peso
        int auxWBak = aux.peso;
        // Itero sobre las aristas del vertice actual
        for (Edge<String> edge: this.mapaCiudades.getEdges(ciudad)) {
        	// Creo un vertice v para guardar el target de la arista actual
            Vertex<String> v = edge.getTarget();
            // Si v no esta visitado
            if (!visitados[v.getPosition()]) {
            	// Sumo el peso de v al camino auxiliar
                aux.peso+=edge.getWeight();
                // Llamo recursivamete al dfs con v, el destino, vector de visitados, camino auxiliar y minimo
                caminoMasCorto(v, ciudad2, visitados, aux, min);
                // restablesco la lista de ciudades del camino auxiliar con el backup
                aux.ciudades = aux.ciudades.subList(0,auxLBak);
                // restablesco el peso del camino auxiliar con el backup
                aux.peso = auxWBak;
            }
        }
        // marco el vertice actual como no visitado
        visitados[ciudad.getPosition()] = false;
    }

    public List<String> devolverCaminoMinimo(String ciudad1, String ciudad2) {
        // Creo array de booleanos para los vertices visitados
        boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
        // Creo un vertice y le guardo la ciudad de inicio
        Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
        // Creo una variable instancia min para guardar el camino minimo. y lo inicializo con una lista vacia y el mayor peso
        Recorrido min = new Recorrido(new LinkedList<String>(),Integer.MAX_VALUE);
        // Creo una variable instancia aux para guardar los caminos. Y lo inicializo con una lista vacia y un peso 0
        Recorrido aux = new Recorrido(new LinkedList<String>(),0);
        // Si la ciudad de inicio y la ciudad destino existen
        if ((v1!=null) && (this.mapaCiudades.search(ciudad2)!=null)) {
        	// Llamo al dfs con el vertice de inicio, el destino, vector de visitados, y recorridos aux y min.
            caminoMasCorto(v1, ciudad2, visitados, aux, min);
        }
        // Retorno el camino mas corto
        return min.ciudades;
    }
    
    // PUNTO 4
    
    private boolean caminoSinCargarCombustible(Vertex<String> ciudad,String ciudad2,boolean[] visitados,List<String> camino, int tanqueAuto) {
        camino.add(ciudad.getData());
        visitados[ciudad.getPosition()] = true;
        if ((ciudad.getData()==ciudad2) && (tanqueAuto > 0)) {
            return true;
        }
        int tanqueBackup = tanqueAuto;
        for (Edge<String> edge: this.mapaCiudades.getEdges(ciudad)) {
            Vertex<String> v = edge.getTarget();
            if (!visitados[v.getPosition()]) {
            	tanqueAuto -= edge.getWeight();
            	if ((tanqueAuto > 0) && (caminoSinCargarCombustible(v, ciudad2, visitados, camino, tanqueAuto))) {
            		return true;
            	}
                tanqueAuto = tanqueBackup;
            }
        }
        visitados[ciudad.getPosition()] = false;
        camino.removeLast();
        System.out.println(tanqueAuto);
        return false;
    }
    
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
    	Vertex<String> v1 = this.mapaCiudades.search(ciudad1);
    	List<String> camino =  new ArrayList<>();
    	if ((v1!=null) && (this.mapaCiudades.search(ciudad2)!=null)) {
	    	boolean[] visitados = new boolean[this.mapaCiudades.getSize()];
	        caminoSinCargarCombustible(v1, ciudad2, visitados, camino, tanqueAuto);
        }
    	System.out.println(tanqueAuto);
        return camino;
    }
}