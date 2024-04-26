/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio7;

import java.util.*;

/**
 *
 * @author joaqu
 */
public class EjercicioSucesion {
    public static List<Integer> calcularSucesion(int n){
        List<Integer> aux = new LinkedList<>();
        aux.add(n);
        while (n != 1) {
            if ((n % 2) == 0){
                n= n % 2;
                aux.add(n);
            } else{
                n= 3*n + 1;
                aux.add(n);
            }
        }
        System.out.println("Resultado:");
        for (int numeros : aux) {
            System.out.println(numeros + " ");
        }
        return aux;
    }
}
