/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ejercicio1;
import tp2.ejercicio3.*;
import java.util.*;
/**
 *
 * @author joaqu
 */
public class prueba {

	public static void main(String[] args) {
        BinaryTree<Integer> a = new BinaryTree(1);
        BinaryTree<Integer> b = new BinaryTree(2);
        BinaryTree<Integer> c = new BinaryTree(3);
        BinaryTree<Integer> d = new BinaryTree(4);
        d.addLeftChild(new BinaryTree<Integer>(10));
        d.addRightChild(new BinaryTree<Integer>(13));
        b.addLeftChild(new BinaryTree<Integer>(7));
        b.addRightChild(new BinaryTree<Integer>(22));
        a.addLeftChild(b);
        a.addRightChild(c);
        c.addRightChild(d);
        a.porNiveles();;
        System.out.println("---------------------------------------------- ");
        ContadorArbol cont = new ContadorArbol(a);
        
        System.out.println("Cantidad de hojas: " + cont.getTree().contarHojas());
        System.out.println(" ");
        cont.getTree().entreNiveles(0, 2);
        System.out.println(" ");
        
        List<Integer> lista = null;
        lista = cont.numerosPares1();
        for (Integer num : lista) {
        	System.out.print(num + " ");
        }
        System.out.println(" ");
        lista = cont.numerosPares2();
        for (Integer num : lista) {
        	System.out.print(num + " ");
        }
        System.out.println(" ");
        lista = cont.numerosPares3();
        for (Integer num : lista) {
        	System.out.print(num + " ");
        }
    }
    
}
