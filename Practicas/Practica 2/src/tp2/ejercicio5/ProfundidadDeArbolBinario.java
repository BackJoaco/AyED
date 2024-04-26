package tp2.ejercicio5;
import tp2.ejercicio1.*;
public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	
	public BinaryTree<Integer> getArbol() {
		return arbol;
	}


	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}


	public int sumaElementosProfundidad(int p) {
		Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
		BinaryTree<Integer> a = null;
		cola.enqueue(this.arbol);
		cola.enqueue(null);
		int suma = 0;
		int altura = 0;
		while (!cola.isEmpty() && (altura <= p)) {
			a = cola.dequeue();
			if (a != null) {
				if (altura == p) {
					suma += a.getData();
				}
				if (a.hasLeftChild()) {
					cola.enqueue(a.getLeftChild());
				}
				if(a.hasRightChild()) {
					cola.enqueue(a.getRightChild());
				} 
			} else if (!cola.isEmpty()){
				cola.enqueue(null);
				altura++;
			}
		}
		return suma;
	}
}
