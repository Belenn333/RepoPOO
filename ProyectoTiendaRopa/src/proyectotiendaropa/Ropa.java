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
    
    //-----------APLICANDO SOBRECARGA DE METODOS ------------------
    
    //Método buscar(String codigo)
    //Busca una prenda utilizando su código.
    //Si encuentra coincidencia, muestra toda la información de la prenda mediante el método mostrar().
    // Buscar por código
    public boolean buscar(String codigo){
        return this.codigo.equalsIgnoreCase(codigo);
    }
    
    //Método sobrecargado buscar(String nombre, String color)
    //Busca una prenda utilizando dos criterios: nombre y color. Si ambos coinciden,
    //se muestran los datos de la prenda.
    public boolean buscar(String nombre, String color){
        return this.nombre.equalsIgnoreCase(nombre)
                && this.color.equalsIgnoreCase(color);
    }
    
    //Método para registrar una nueva prenda
    public boolean agregar(String codigo, String nombre, String talla, String categoria, String color, double precio, int stock){
        //Verifica que el precio y el stock sean válidos
        if(precio > 0 && stock >= 0){

            this.codigo = codigo;
            this.nombre = nombre;
            this.talla = talla;
            this.categoria = categoria;
            this.color = color;
            this.precio = precio;
            this.stock = stock;

            return true;
        }

        return false;
    }
    
    //Sobrecarga para modificar datos sin alterar el stock
    public boolean agregar(String nombre,String talla, String categoria, String color, double precio){

        if(precio > 0){
            this.nombre = nombre;
            this.talla = talla;
            this.categoria = categoria;
            this.color = color;
            this.precio = precio;
            return true;
        }
        return false;
    }
    
    //Devuelve los datos para la lista
    public Object[] mostrar(boolean tabla){
        return new Object[]{
            codigo,
            nombre,
            talla,
            categoria,
            color,
            precio,
            stock
        };
    }
    
}
