package ejercicio3;
import ejercicio1.*;
import ejercicio1.adjList.*;
import java.util.*;

public class Ej3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> holmenkollen = grafo.createVertex("Holmenkollen");
        Vertex<String> parqueVigeland = grafo.createVertex("Parque Vigeland");
        Vertex<String> folkMuseum = grafo.createVertex("Folk Museum");
        Vertex<String> museoFram = grafo.createVertex("Museo Fram");
        Vertex<String> museoDelBarcoPolar = grafo.createVertex("Museo del Barco Polar");

        Vertex<String> galeriaNacional = grafo.createVertex("Galeria Nacional");
        Vertex<String> palacioReal = grafo.createVertex("Palacio Real");
        Vertex<String> museoVikingo = grafo.createVertex("Museo Vikingo");

        Vertex<String> parqueBotanico = grafo.createVertex("Parque Botanico");
        Vertex<String> ayuntamiento = grafo.createVertex("Ayuntamiento");
        Vertex<String> akkerBrigge = grafo.createVertex("Akker Brigge");

        Vertex<String> museoMunch = grafo.createVertex("Museo Munch");
        Vertex<String> elTigre = grafo.createVertex("El Tigre");
        Vertex<String> laOpera = grafo.createVertex("La Opera");
        Vertex<String> fortalezaAkershus = grafo.createVertex("Fortaleza Akershus");

        grafo.connect(holmenkollen, parqueVigeland, 30);
        grafo.connect(parqueVigeland, holmenkollen, 30);

        grafo.connect(parqueVigeland, galeriaNacional, 10);
        grafo.connect(galeriaNacional, parqueVigeland, 10);
        
        grafo.connect(parqueVigeland, folkMuseum, 20);
        grafo.connect(folkMuseum, parqueVigeland, 20);

        grafo.connect(folkMuseum, palacioReal, 5);
        grafo.connect(palacioReal, folkMuseum, 5);
        
        grafo.connect(folkMuseum, akkerBrigge, 30);
        grafo.connect(akkerBrigge, folkMuseum, 30);
        
        grafo.connect(folkMuseum, museoFram, 5);
        grafo.connect(museoFram, folkMuseum, 5);

        grafo.connect(museoFram, museoDelBarcoPolar, 5);
        grafo.connect(museoDelBarcoPolar, museoFram, 5);

        grafo.connect(museoDelBarcoPolar, museoVikingo, 5);
        grafo.connect(museoVikingo, museoDelBarcoPolar, 5);

        grafo.connect(galeriaNacional, parqueBotanico, 15);
        grafo.connect(parqueBotanico, galeriaNacional, 15);

        grafo.connect(palacioReal, ayuntamiento, 5);
        grafo.connect(ayuntamiento, palacioReal, 5);

        grafo.connect(akkerBrigge, ayuntamiento, 20);
        grafo.connect(ayuntamiento, akkerBrigge, 20);

        grafo.connect(parqueBotanico, museoMunch, 1);
        grafo.connect(museoMunch, parqueBotanico, 1);
        
        grafo.connect(parqueBotanico, ayuntamiento, 10);
        grafo.connect(ayuntamiento, parqueBotanico, 10);

        grafo.connect(ayuntamiento, elTigre, 15);
        grafo.connect(elTigre, ayuntamiento, 15);

        grafo.connect(museoMunch, elTigre, 15);
        grafo.connect(elTigre, museoMunch, 15);

        grafo.connect(elTigre, laOpera, 5);
        grafo.connect(laOpera, elTigre, 5);

        grafo.connect(laOpera, fortalezaAkershus, 10);
        grafo.connect(fortalezaAkershus, laOpera, 10);

        Mapa mapa = new Mapa(grafo);
        System.out.println("\n\ndevolverCamino():");
        System.out.println(mapa.devolverCamino("Fortaleza Akershus", "Museo Vikingo"));
        System.out.println(mapa.devolverCamino("Holmenkollen", "N/A"));
        System.out.println(mapa.devolverCamino("Museo del Barco Polar", "Museo Munch"));
        
        System.out.println("\n\ndevolverCaminoExceptuando():");
        List<String> ciudades = new LinkedList<>();
        ciudades.add("Palacio Real");
        ciudades.add("Akker Brigge");
        System.out.println(mapa.devolverCaminoExceptuando2("Fortaleza Akershus", "Parque Botanico", ciudades));
        System.out.println(mapa.devolverCaminoExceptuando2("Fortaleza Akershus", "N/A", ciudades));
        System.out.println(mapa.devolverCaminoExceptuando2("N/A", "Museo Vikingo", ciudades));
        
        System.out.println("\n\ndevolverCaminoMinimo():");
        System.out.println(mapa.devolverCaminoMinimo("Fortaleza Akershus", "Parque Botanico"));
        System.out.println(mapa.devolverCaminoMinimo("Holmenkollen", "N/A"));
        System.out.println(mapa.devolverCaminoMinimo("Museo del Barco Polar", "Museo Munch"));
        
        System.out.println("\n\ncaminoSinCargarCombustible():");
        System.out.println(mapa.caminoSinCargarCombustible("Fortaleza Akershus", "Museo Munch", 31));
	}

}
