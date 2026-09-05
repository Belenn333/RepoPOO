/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana02;

/**
 *
 * @author USUARIO
 */
public class Ejemplo02 {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Alumno 1", 14, 16, 20, 20, 20);
        System.out.println("Promedio Alumno 1: " + alumno1.calcularPromedio());
        System.out.println("===================");
        
        Alumno alumno2 = new Alumno("Alumno 2", 14, 16, 20, 20, 20);
        System.out.println("Promedio Alumno 2: " + alumno2.calcularPromedio(6,4,2,1,1));
        System.out.println("===================");
        
        Alumno alumno3 = new Alumno("Alumno 3", 0, 0, 0, 20, 20);
        System.out.println("Promedio Alumno 3: " + alumno3.calcularPromedio("ASISTENCIA"));
        System.out.println("===================");
        
        // primer commit
        Alumno alumno4 = new Alumno("Alumno 4", 14, 16, 19, 10, 10);
        System.out.println("Promedio Alumno 4: " + alumno4.calcularPromedio(6,4,2,1,1));
        System.out.println("===================");
        
    }
}
