/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana01ejemplo01;

/**
 *
 * @author USUARIO
 */
public class Semana01Ejemplo03 {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.setNombre("Luis");
        persona1.setApellido("Romero");
        persona1.setEdad(44);
        
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Apellido: " + persona1.getApellido());
        System.out.println("Edad: " + persona1.getEdad());
        
        Persona persona2 = new Persona();
        persona2.setNombre("Ana");
        persona2.setApellido("Romero");
        persona2.setEdad(24);
        
        persona2.mostrarDatos();
        
        Persona persona3 = new Persona();
        persona3.ingresarDatos();
        persona3.mostrarDatos();
    }
}
