package ejercicio6;
import ejercicio1.*;
public class Ej6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralTree<Character> A = new GeneralTree<Character>('A');
		GeneralTree<Character> B = new GeneralTree<Character>('B');
		GeneralTree<Character> C = new GeneralTree<Character>('C');
		GeneralTree<Character> D = new GeneralTree<Character>('D');
		GeneralTree<Character> E = new GeneralTree<Character>('E');
		GeneralTree<Character> F = new GeneralTree<Character>('F');
		GeneralTree<Character> G = new GeneralTree<Character>('G');
		GeneralTree<Character> H = new GeneralTree<Character>('H');
		GeneralTree<Character> I = new GeneralTree<Character>('I'); 
		GeneralTree<Character> J = new GeneralTree<Character>('J'); 
		GeneralTree<Character> K = new GeneralTree<Character>('K'); 
		GeneralTree<Character> L = new GeneralTree<Character>('L');
		GeneralTree<Character> M = new GeneralTree<Character>('M');
		GeneralTree<Character> N = new GeneralTree<Character>('N'); 
		GeneralTree<Character> O = new GeneralTree<Character>('O');
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		A.addChild(E);
		C.addChild(F);
		C.addChild(G);
		G.addChild(M);
		D.addChild(H);
		D.addChild(I);
		D.addChild(J);
		D.addChild(K);
		D.addChild(L);
		J.addChild(N);
		J.addChild(O);
		
		RedDeAguaPotable aux = new RedDeAguaPotable();
		aux.setArbol(A);
		System.out.println(aux.minimoCaudal(1000));
		
	}

}
