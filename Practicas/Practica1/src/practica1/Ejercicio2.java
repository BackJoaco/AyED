package practica1;

public class Ejercicio2 {
	
		public int[] ejer2(int n) {
			int[] aux = new int[n];
			for (int i = 0; i < n; i++) {
				aux[i]= n * (i+1);
			}
			return aux;
		}
		
}
