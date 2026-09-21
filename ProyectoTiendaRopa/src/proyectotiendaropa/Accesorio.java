/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotiendaropa;

/**
 *
 * @author Ivan
 */
public class Accesorio {

    // Declaracion de los cuatro atributos de la clase Accesorio.
    // Se utiliza private para aplicar encapsulamiento.
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Metodos de acceso al codigo que identifica al accesorio.
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Metodos de acceso al nombre del accesorio.
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Metodos de acceso al precio del accesorio.
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Metodos de acceso a la cantidad disponible del accesorio.
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
