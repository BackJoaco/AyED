package tp2.ejercicio8;

import tp2.ejercicio1.BinaryTree;

public class Ej8 {

	public static void main(String[] args) {
		BinaryTree<Integer> a = new BinaryTree(65);
        BinaryTree<Integer> b = new BinaryTree(37);
        BinaryTree<Integer> c = new BinaryTree(81);
        BinaryTree<Integer> d = new BinaryTree(22);
        BinaryTree<Integer> e = new BinaryTree(93);
        a.addLeftChild(b);
        a.addRightChild(c);
        b.addLeftChild(d);
        b.addRightChild(new BinaryTree<Integer>(47));
        c.addLeftChild(new BinaryTree<Integer>(76));
        c.addRightChild(e);
        d.addLeftChild(new BinaryTree<Integer>(11));
        d.addRightChild(new BinaryTree<Integer>(29));
        e.addLeftChild(new BinaryTree<Integer>(85));
        e.addRightChild(new BinaryTree<Integer>(94));
        BinaryTree<Integer> arbol2 = a;
        BinaryTree<Integer> a1 = new BinaryTree(65);
        BinaryTree<Integer> b1 = new BinaryTree(37);
        BinaryTree<Integer> c1 = new BinaryTree(81);
        a1.addLeftChild(b1);
        a1.addRightChild(c1);
        b1.addRightChild(new BinaryTree<Integer>(47));
        c1.addRightChild(new BinaryTree<Integer>(93));
        BinaryTree<Integer> arbol1 = a1;
        
        ParcialArboles aux = new ParcialArboles();
        aux.esPrefijo(arbol1, arbol2);
        System.out.println(aux.esPrefijo(arbol1, arbol2));
        System.out.println(aux.esPrefijo(c1.getRightChild(), e));
        System.out.println(aux.esPrefijo(b1, b));
	}

}
