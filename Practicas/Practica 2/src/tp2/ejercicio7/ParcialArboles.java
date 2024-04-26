package tp2.ejercicio7;
import tp2.ejercicio1.*;
public class ParcialArboles {
	private BinaryTree<Integer> arbol;

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private int isLeftTree(BinaryTree<Integer> a) {
		int aux = 0;
		if (!a.isLeaf()) {
			if (a.hasLeftChild() && a.hasRightChild()) {
				isLeftTree(a.getLeftChild());
				isLeftTree(a.getRightChild());
			} else aux++;
		}
		return aux;
	}
	
	public boolean isLeftTree(int num) {
		boolean resultado = false;
		boolean encontre = false;
		//Verifico que el arbol no sea vacio
		if (!this.getArbol().isEmpty()) {
			BinaryTree<Integer> a = null;
			//Busco el arbol con el num deseado;
			Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
			cola.enqueue(this.getArbol());
			while(!cola.isEmpty() && !encontre) {
				a = cola.dequeue();
				if (a.getData() != num) {
					if(a.hasLeftChild()) {
						cola.enqueue(a.getLeftChild());
					}
					if(a.hasRightChild()) {
						cola.enqueue(a.getRightChild());
					}
				} else encontre = true;
			}
			if (encontre) {
				int d = 0;
				int i = 0;
				if (a.hasLeftChild()) {
					i = isLeftTree(a.getLeftChild());
				}
				if (a.hasRightChild()) {
					d = isLeftTree(a.getRightChild());
				}
				if (i>d) {
					resultado = true;
				}
			}
		}
		
		//Retorno false si num no se encuentra o la cantidad de hijos unicos es menor del lado izquierdo
		return resultado;
	}
	
}
