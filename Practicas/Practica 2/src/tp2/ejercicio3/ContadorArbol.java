package tp2.ejercicio3;

import tp2.ejercicio1.BinaryTree;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> tree;
	
	public BinaryTree<Integer> getTree() {
		return tree;
	}

	public void setTree(BinaryTree<Integer> tree) {
		this.tree = tree;
	}

	public ContadorArbol(BinaryTree<Integer> tree) {
		this.setTree(tree);
	}
	public ContadorArbol() {
		this.setTree(tree);
	}
	
	private void preOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
		if (nodo.getData() % 2 == 0) {
			pares.add(nodo.getData());
		}
		if(nodo.hasLeftChild()) {
			preOrden(nodo.getLeftChild(), pares);
		}
		if(nodo.hasRightChild()) {
			preOrden(nodo.getRightChild(), pares);
		}
	}
	
	public List<Integer> numerosPares1(){
		List<Integer> aux = new LinkedList<Integer>();
		preOrden(this.getTree(), aux);
		return aux;
 	}
	
	private void inOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
		if(nodo.hasLeftChild()) {
			inOrden(nodo.getLeftChild(), pares);
		}
		if (nodo.getData() % 2 == 0) {
			pares.add(nodo.getData());
		}
		if(nodo.hasRightChild()) {
			inOrden(nodo.getRightChild(), pares);
		}
	}
	
	public List<Integer> numerosPares2(){
		List<Integer> aux = new LinkedList<Integer>();
		inOrden(this.getTree(), aux);
		return aux;
	}
	
	private void postOrden(BinaryTree<Integer> nodo, List<Integer> pares) {
		if(nodo.hasLeftChild()) {
			postOrden(nodo.getLeftChild(), pares);
		}
		if(nodo.hasRightChild()) {
			postOrden(nodo.getRightChild(), pares);
		}
		if (nodo.getData() % 2 == 0) {
			pares.add(nodo.getData());
		}
	}
	
	public List<Integer> numerosPares3(){
		List<Integer> aux = new LinkedList<Integer>();
		postOrden(this.getTree(), aux);
		return aux;
	}
}
