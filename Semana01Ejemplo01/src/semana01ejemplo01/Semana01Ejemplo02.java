/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana01ejemplo01;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Semana01Ejemplo02 {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            System.out.println(i);

        }
        
        Scanner teclado = new Scanner(System.in);
        
        int numero;
        System.out.print("Ingrese un numero: ");
        numero = teclado.nextInt();
        
        while(numero!=0){
            System.out.println(numero*2);
            System.out.println("Ingrese un numero: ");
            numero = teclado.nextInt();
        }
                
        
        System.out.print("Fin el problema ");

    }
}
