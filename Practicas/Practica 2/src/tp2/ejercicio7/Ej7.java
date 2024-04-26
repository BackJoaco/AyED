package tp2.ejercicio7;

import tp2.ejercicio1.BinaryTree;

public class Ej7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<Integer> a = new BinaryTree(2);
        BinaryTree<Integer> b = new BinaryTree(7);
        BinaryTree<Integer> c = new BinaryTree(-5);
        BinaryTree<Integer> d = new BinaryTree(23);
        BinaryTree<Integer> e = new BinaryTree(6);
        BinaryTree<Integer> f = new BinaryTree(19);
        BinaryTree<Integer> g = new BinaryTree(4);
        
        a.addLeftChild(b);
        a.addRightChild(c);
        
        b.addLeftChild(d);
        b.addRightChild(e);
        
        c.addLeftChild(f);
        
        d.addLeftChild(new BinaryTree(-3));
        
        e.addLeftChild(new BinaryTree(55));
        e.addRightChild(new BinaryTree(11));
        
        f.addRightChild(g);
        
        g.addLeftChild(new BinaryTree(18));
        
        ParcialArboles aux = new ParcialArboles();
        aux.setArbol(a);
        System.out.println();
        System.out.println(aux.isLeftTree(7));
        System.out.println(aux.isLeftTree(2));
        System.out.println(aux.isLeftTree(-5));
        System.out.println(aux.isLeftTree(19));
        System.out.println(aux.isLeftTree(-3));
        
	}

}
