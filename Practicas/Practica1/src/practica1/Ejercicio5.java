package practica1;

public class Ejercicio5 {
	
	public static Datos a(int[] arreglo) {
		int max = 0, min = 0, cont = 0, sum = 0;
		for (int i = 0; i < arreglo.length; i++) {
			cont++;
			sum += arreglo[i];
			if (arreglo[i] > max) max = arreglo[i];
			if (arreglo[i] < min) min = arreglo[i];
		}
		int prom = sum / cont;
		Datos obj = new Datos();
		obj.setMax(max);
		obj.setMin(min);
		obj.setProm(prom);
		return obj;
	}
	
}
