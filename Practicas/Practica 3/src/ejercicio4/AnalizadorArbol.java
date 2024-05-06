package ejercicio4;
import ejercicio1.*;
import ejercicio4.AreaEmpresa;

@SuppressWarnings("unused")
public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		int max = 0;
		if(!arbol.isEmpty()) {
			Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
			cola.enqueue(arbol);
			cola.enqueue(null);
			int suma = 0;
			int cont = 0;
			while (!cola.isEmpty()) {
				GeneralTree<AreaEmpresa> aux = cola.dequeue();
				if (aux != null) {
					suma += aux.getData().getPing();
					cont++;
					if (aux.hasChildren()) {
						for (GeneralTree<AreaEmpresa> hijo : aux.getChildren()) {
							cola.enqueue(hijo);
						}
					}
				} else if (!cola.isEmpty()) {
					if (suma / cont > max) max= suma/cont;
					cola.enqueue(null);
					suma=0;
					cont=0;
				}
			}
		}
		return max;
	}
}
