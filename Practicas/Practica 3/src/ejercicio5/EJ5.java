package ejercicio5;

import ejercicio1.GeneralTree;


public class EJ5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralTree<Integer> arb1 = new GeneralTree<Integer>(1);
		GeneralTree<Integer> arb2 = new GeneralTree<Integer>(2);
		GeneralTree<Integer> arb3 = new GeneralTree<Integer>(3);
		arb1.addChild(arb2);
		arb1.addChild(arb3);
		
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		
		System.out.println(arb1.esAncestro(b, a));
	}

}
