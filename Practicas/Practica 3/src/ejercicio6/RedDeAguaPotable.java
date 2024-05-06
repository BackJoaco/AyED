package ejercicio6;
import ejercicio1.*;
import java.util.*;

public class RedDeAguaPotable {
	private GeneralTree<Character> arbol;
	
	public GeneralTree<Character> getArbol() {
		return arbol;
	}

	public void setArbol(GeneralTree<Character> arbol) {
		this.arbol = arbol;
	}

	private void calcularCaudales(GeneralTree<Character> nodo, double caudal, List<Double> caudales) {
		List<GeneralTree<Character>> hijos = nodo.getChildren();
	    int numHijos = hijos.size();
	
	    if (numHijos == 0) {
	        caudales.add(caudal);
	        return;
	    }
	
	    double caudalPorHijo = caudal / numHijos;
	    for (GeneralTree<Character> hijo : hijos) {
	        calcularCaudales(hijo, caudalPorHijo, caudales);
	    }
	}
	
	public double minimoCaudal(double caudal) {
		List<Double> caudales = new ArrayList<Double>();
		calcularCaudales(arbol, caudal, caudales);
		double min = caudal;
		if (!caudales.isEmpty()) {
			for(double num : caudales) {
				if (num < min) min = num;
			}
		}
		return min;
	}

}
