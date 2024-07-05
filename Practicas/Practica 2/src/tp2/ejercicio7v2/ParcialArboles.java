package tp2.ejercicio7v2;
import tp2.ejercicio1.*;
public class ParcialArboles {
	private BinaryTree<Integer> arbol;

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	private BinaryTree<Integer> buscar(BinaryTree<Integer> tree, int num){
		if (tree.getData() == num) {
			return tree;
		}
		
		BinaryTree<Integer> buscado = null;
		if (tree.hasLeftChild()) {
			buscado = buscar(tree.getLeftChild(), num);
		}
		if (tree.hasRightChild() && (buscado == null)) {
			buscado = buscar(tree.getRightChild(), num);
		}
		return buscado;
	}
	
	private int cantConHijosUnicos(BinaryTree<Integer> tree) {
		int cant = 0;
		
		if (tree.hasLeftChild()) {
			cant += cantConHijosUnicos(tree.getLeftChild());
		}
		if (tree.hasRightChild()) {
			cant += cantConHijosUnicos(tree.getRightChild());
		}
		if (tree.hasLeftChild() ^ tree.hasRightChild()) {
			cant ++;
		}
		return cant;
	}
	
	private boolean isLeftTree(BinaryTree<Integer> tree) {
		int i = -1;
		int d = -1;
		if (tree.hasLeftChild()) {
			i = cantConHijosUnicos(tree.getLeftChild());
		}
		if (tree.hasRightChild()) {
			d = cantConHijosUnicos(tree.getRightChild());
		}
		System.out.println("Izquierda: " + i + " Derecha: " + d);
		return i>d;
	}
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> tree = buscar(this.getArbol(), num);
		if (tree == null) {
			return false;
		} else {
			return isLeftTree(tree);
		}
	}
}
