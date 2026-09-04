/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana02;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Ejemplo04 {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Integer> listaNumeros = new ArrayList<Integer>();
        
        System.out.println("Cantidad de elementos: " + listaNumeros.size());
        
        listaNumeros.add(14);
        listaNumeros.add(10);
        listaNumeros.add(4);
        System.out.println("Cantidad de elementos: " + listaNumeros.size());

    }
}
