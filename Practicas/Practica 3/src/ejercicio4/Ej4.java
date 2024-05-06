package ejercicio4;
import ejercicio4.*;
import ejercicio1.*;

@SuppressWarnings("unused")
public class Ej4 {

	public static void main(String[] args) {
		AreaEmpresa A = new AreaEmpresa("A", 4);
		AreaEmpresa B = new AreaEmpresa("B", 7);
		AreaEmpresa C = new AreaEmpresa("C", 5);
		AreaEmpresa D = new AreaEmpresa("D", 6);
		AreaEmpresa E = new AreaEmpresa("E", 10);
		AreaEmpresa F = new AreaEmpresa("F", 18);
		AreaEmpresa G = new AreaEmpresa("G", 9);
		AreaEmpresa H = new AreaEmpresa("H", 12);
		AreaEmpresa I = new AreaEmpresa("I", 19);
		AreaEmpresa J = new AreaEmpresa("J", 13);
		AreaEmpresa K = new AreaEmpresa("K", 25);
		AreaEmpresa L = new AreaEmpresa("L", 10);
		AreaEmpresa M = new AreaEmpresa("M", 14);
		
		GeneralTree<AreaEmpresa> arb1 = new GeneralTree<AreaEmpresa>();
		GeneralTree<AreaEmpresa> arb2 = new GeneralTree<AreaEmpresa>();
		GeneralTree<AreaEmpresa> arb3 = new GeneralTree<AreaEmpresa>();
		GeneralTree<AreaEmpresa> arb4 = new GeneralTree<AreaEmpresa>();
		
		arb1.addChild(arb2);
		arb1.addChild(arb3);
		arb1.addChild(arb4);
		arb1.setData(M);
		arb2.setData(J);
		arb3.setData(K);
		arb4.setData(L);
		arb2.addChild(new GeneralTree<AreaEmpresa>(A));
		arb2.addChild(new GeneralTree<AreaEmpresa>(B));
		arb2.addChild(new GeneralTree<AreaEmpresa>(C));
		arb3.addChild(new GeneralTree<AreaEmpresa>(D));
		arb3.addChild(new GeneralTree<AreaEmpresa>(E));
		arb3.addChild(new GeneralTree<AreaEmpresa>(F));
		arb4.addChild(new GeneralTree<AreaEmpresa>(G));
		arb4.addChild(new GeneralTree<AreaEmpresa>(H));
		arb4.addChild(new GeneralTree<AreaEmpresa>(I));
		
		
		System.out.println(arb1.esAncestro(M, K));
		//AnalizadorArbol analizador = new AnalizadorArbol();
		//System.out.println("El mayor promedio es: " + analizador.devolverMaximoPromedio(arb1));
		

	}

}
