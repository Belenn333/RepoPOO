/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotiendaropa;

/**
 *
 * @author USUARIO
 */
public class Ropa {
    //Declaracion de atributos Clase Ropa
    private String codigo;
    private String nombre;
    private String talla;
    private String categoria;
    private String color;
    private double precio;
    private int stock;

    //Aplicando encapsulamiento con getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Metodo sin parámetros. Muestra toda la información de la prenda.
    public void mostrar(){
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Talla: " + talla);
        System.out.println("Categoria: " + categoria);
        System.out.println("Color: " + color);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }
    
    //-----------APLICANDO SOBRECARGA DE METODOS ------------------
    
    //Método buscar(String codigo)
    //Busca una prenda utilizando su código.
    //Si encuentra coincidencia, muestra toda la información de la prenda mediante el método mostrar().
    public void buscar(String codigo){

        //Compara el código ingresado con el código de la prenda
        if(this.codigo.equalsIgnoreCase(codigo)){

            //Muestra los datos de la prenda encontrada
            mostrar();
        }
    }
    
    //Método sobrecargado buscar(String nombre, String color)
    //Busca una prenda utilizando dos criterios: nombre y color. Si ambos coinciden,
    //se muestran los datos de la prenda.
    public void buscar(String nombre, String color){

        //Verifica que el nombre y el color coincidan
        if(this.nombre.equalsIgnoreCase(nombre)
                && this.color.equalsIgnoreCase(color)){

            //Muestra los datos de la prenda encontrada
            mostrar();
        }
    }
    
}
