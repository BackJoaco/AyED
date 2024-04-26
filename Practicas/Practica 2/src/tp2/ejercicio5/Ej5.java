package tp2.ejercicio5;

import tp2.ejercicio1.BinaryTree;

public class Ej5 {

	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree(1);
        BinaryTree<Integer> b = new BinaryTree(8);
        BinaryTree<Integer> c = new BinaryTree(10);
        a.addLeftChild(b);
        a.addRightChild(c);
        c.addRightChild(new BinaryTree(5));
        c.addLeftChild(new BinaryTree(2));
        b.addRightChild(new BinaryTree(4));
        b.addLeftChild(new BinaryTree(3));
        
        ProfundidadDeArbolBinario aux = new ProfundidadDeArbolBinario();
        aux.setArbol(a);
        System.out.println(aux.sumaElementosProfundidad(2));
	}

}
