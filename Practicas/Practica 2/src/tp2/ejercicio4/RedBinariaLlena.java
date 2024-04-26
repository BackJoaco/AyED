package tp2.ejercicio4;
import tp2.ejercicio1.*;
public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public RedBinariaLlena(BinaryTree<Integer> arbol){
		this.setArbol(arbol);
	}
	
	public int retardoReenvio(BinaryTree<Integer> a) {
		if (a.isLeaf()) {
			return a.getData();
		}
		int l = 0;
		int r = 0;
		if (a.hasLeftChild()) {
			l = retardoReenvio(a.getLeftChild());
		}
		if (a.hasRightChild()) {
			r = retardoReenvio(a.getRightChild());
		}
		if (l>r) {
			return a.getData() + l;
		} else {
			return a.getData() + r;
		}
	}
	
	public int retardoReenvio() {
		return retardoReenvio(this.getArbol());
	}
}
