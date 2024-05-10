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

	private double calcularCaudales(double caudal, GeneralTree<Character> arbol) {
		double min = caudal;
		if (arbol.hasChildren()) {
			for (GeneralTree<Character> hijo : arbol.getChildren()) {
				double actual = calcularCaudales(caudal/arbol.getChildren().size(), hijo);
				if (actual < min) min = actual;
			}
		}
		return min;
	}
	
	public double minimoCaudal(double caudal) {
		return calcularCaudales(caudal, this.getArbol());
	}

}
