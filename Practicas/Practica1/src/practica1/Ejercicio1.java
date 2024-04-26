package practica1;

public class Ejercicio1 {
	
	public static void metodo1(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}
	}

	public static void metodo2(int a, int b) {
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void metodo3(int a, int b) {
		if (a <= b) {
			System.out.println(a);
			Ejercicio1.metodo3(++a, b);
		}
	}
}
