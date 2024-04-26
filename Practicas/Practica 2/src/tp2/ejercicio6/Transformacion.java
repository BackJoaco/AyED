package tp2.ejercicio6;
import tp2.ejercicio1.*;
public class Transformacion {
	private BinaryTree<Integer> arbol;

	public BinaryTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	private int suma(BinaryTree<Integer> a) {
		int suma = 0;
		if (!a.isLeaf()) {
			if (a.hasLeftChild()) {
				suma+=suma(a.getLeftChild());
			}
			if(a.hasRightChild()) {
				suma+=suma(a.getRightChild());
			}
		} else {
			suma = a.getData();
			a.setData(0);
			return suma;
		}
		int yo = a.getData();
		a.setData(suma);
		return suma + yo;
	}
	
	public BinaryTree<Integer> suma(){
		BinaryTree<Integer> a = this.getArbol();
		suma(a);
		return a;
	}
}
