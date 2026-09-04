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
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void mostrarDatos(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido: " + this.apellido);
        System.out.println("Edad: " + this.edad);
    }
    private void mostrarCondicion(){
        if(this.edad >= 18){
            System.out.println("La persona es MAYOR de edad");
        }else{
            System.out.println("La persona es MENOR de edad");
        }
    }
    
    public void ingresarDatos(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        this.nombre = teclado.nextLine();
        
        System.out.print("Ingrese el apellido: ");
        this.apellido = teclado.nextLine();
        
        System.out.print("Ingrese la edad: ");
        this.edad = teclado.nextInt();
    }

    
}
