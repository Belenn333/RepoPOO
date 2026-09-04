/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semana02;

/**
 *
 * @author USUARIO
 */
public class Alumno {
    private String nombre;
    private int n1;
    private int n2;
    private int n3;
    private int n4;
    private int n5;
    private int promedio;

    public Alumno(String nombre, int n1, int n2, int n3, int n4, int n5) {
        this.nombre = nombre;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getN3() {
        return n3;
    }

    public void setN3(int n3) {
        this.n3 = n3;
    }

    public int getN4() {
        return n4;
    }

    public void setN4(int n4) {
        this.n4 = n4;
    }

    public int getN5() {
        return n5;
    }

    public void setN5(int n5) {
        this.n5 = n5;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
    
    public int calcularPromedio(){
        double sumaNotas = n1 + n2 + n3 + n4 + n5;
        double promedio = sumaNotas/5;
        int promedioEntero = (int)Math.round(promedio);
        return promedioEntero;
    }

    public int calcularPromedio(int p1, int p2, int p3, int p4, int p5){
        double sumaNotas = (p1*n1) + (p2*n2) + (p3*n3) + (p4*n4) + (p5*n5);
        double promedio = sumaNotas/(p1 + p2 + p3 + p4 + p5);
        int promedioEntero = (int)Math.round(promedio);
        return promedioEntero;
    }
    
    public int calcularPromedio(String condicion){
        if(condicion.equals("ASISTENCIA")){
            int notasCero = contarNotasIgualCero();
            if(notasCero >= 3) return 0;
            else{
                double sumaNotas = n1 + n2 + n3 + n4 + n5;
                double promedio = sumaNotas/5;
                int promedioEntero = (int)Math.round(promedio);
                return promedioEntero;
            }
        }
        return 0;
    }
    
    private int contarNotasIgualCero(){
        int suma = 0;
        if(n1 == 0) suma++;
        if(n2 == 0) suma++;
        if(n3 == 0) suma++;
        if(n4 == 0) suma++;
        if(n5 == 0) suma++;
        return suma;
    }
}
