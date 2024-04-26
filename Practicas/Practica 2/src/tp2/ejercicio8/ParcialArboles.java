package tp2.ejercicio8;
import tp2.ejercicio1.*;
public class ParcialArboles {
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean aux = false;
		if (!arbol1.isEmpty() && !arbol2.isEmpty()) {
			aux = !aux;
			Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
			Queue<BinaryTree<Integer>> cola2 = new Queue<BinaryTree<Integer>>();
			cola.enqueue(arbol1);
			cola2.enqueue(arbol2);
			while (!cola.isEmpty() && aux) {
				BinaryTree<Integer> a1 = cola.dequeue();
				BinaryTree<Integer> a2 = cola2.dequeue();
				if (a1.getData() != a2.getData()) aux = !aux;
				if (a1.hasLeftChild() && a2.hasLeftChild()) {
					cola.enqueue(a1.getLeftChild());
					cola2.enqueue(a2.getLeftChild());
				} else if (a1.hasLeftChild()) { aux = !aux; }
				if(a1.hasRightChild() && a2.hasRightChild()) {
					cola.enqueue(a1.getRightChild());
					cola2.enqueue(a2.getRightChild());
				} else if (a1.hasRightChild()) { aux= !aux; }
			}
		}
		return aux;
	}
}
