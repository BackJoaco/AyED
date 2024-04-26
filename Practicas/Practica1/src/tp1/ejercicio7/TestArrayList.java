package tp1.ejercicio7;

import java.util.*;

public class TestArrayList {
    public static void main(String[] args) {
         // Crear una lista ArrayList para almacenar los números
        ArrayList<Integer> numeros = new ArrayList<>();

        // Agregar los números proporcionados como argumentos al programa a la lista
        for (String arg : args) {
            int num = Integer.parseInt(arg);
            numeros.add(num);
        }

        // Imprimir el contenido de la lista
        System.out.println("Contenido de la lista:");
        for (int num : numeros) {
            System.out.println(num);
        }
        
        punto7D();
        List<Integer> aux;
        aux = EjercicioSucesion.calcularSucesion(6);
        System.out.println("Resultado:");
        for (int numero : aux) {
            System.out.println(numero + " ");
        }
    }
   
    
    public static void punto7D(){
        // Crear una lista que contenga 3 estudiantes
        List<String> listaOriginal = new ArrayList<>();
        listaOriginal.add("Estudiante 1");
        listaOriginal.add("Estudiante 2");
        listaOriginal.add("Estudiante 3");
        
        // Generar una nueva lista que sea una copia de la lista original
        List<String> nuevaLista = new ArrayList<>(listaOriginal);
        
        // Imprimir el contenido de la lista original y la nueva lista
        System.out.println("Contenido de la lista original:");
        for (String estudiante : listaOriginal) {
            System.out.println(estudiante);
        }
        
        System.out.println("\nContenido de la nueva lista:");
        for (String estudiante : nuevaLista) {
            System.out.println(estudiante);
        }
        
        // Modificar algún dato de los estudiantes
        listaOriginal.set(0, "Estudiante 1 Modificado");
        
        // Imprimir el contenido de la lista original y la nueva lista después de la modificación
        System.out.println("\nContenido de la lista original después de la modificación:");
        for (String estudiante : listaOriginal) {
            System.out.println(estudiante);
        }
        
        System.out.println("\nContenido de la nueva lista después de la modificación:");
        for (String estudiante : nuevaLista) {
            System.out.println(estudiante);
        }
        
        String nuevoEstudiante = "Estudiante 3";
        boolean ok = true;
        for (String estudiante : listaOriginal) {
            if (estudiante.equals(nuevoEstudiante)){
                System.out.println("\nEstudiante repetido");
                ok=false;
                break;
            }
        }
        if (ok){
            listaOriginal.add(nuevoEstudiante);
        }
        System.out.println("\nContenido de la lista original luego de agregar:");
        for (String estudiante : listaOriginal) {
            System.out.println(estudiante);
        }
    }
}
