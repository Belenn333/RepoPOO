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

    // Metodo de acceso al codigo del accesorio.
    public String getCodigo() {
        return codigo;
    }

    // Valida que el codigo no sea nulo ni este vacio.
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Error: el codigo es obligatorio.");
        } else {
            this.codigo = codigo;
        }
    }

    // Metodo de acceso al nombre del accesorio.
    public String getNombre() {
        return nombre;
    }

    // Valida que el nombre no sea nulo ni este vacio.
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: el nombre es obligatorio.");
        } else {
            this.nombre = nombre;
        }
    }

    // Metodo de acceso al precio del accesorio.
    public double getPrecio() {
        return precio;
    }

    // Valida que el precio no sea negativo.
    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: el precio no puede ser negativo.");
        }
    }

    // Metodo de acceso a la cantidad disponible.
    public int getStock() {
        return stock;
    }

    // Valida que el stock no sea negativo.
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Error: el stock no puede ser negativo.");
        }
    }

    // Muestra los cuatro atributos del accesorio.
    public void mostrar() {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Stock: " + stock);
    }

    //-----------APLICANDO SOBRECARGA DE METODOS------------------

    // Metodo buscar(String codigo).
    // Busca un accesorio utilizando su codigo.
    // Si encuentra coincidencia, muestra toda su informacion.
    public void buscar(String codigo) {

        // Verifica que exista un codigo asignado y compara los codigos
        // sin distinguir entre mayusculas y minusculas.
        if (this.codigo != null
                && this.codigo.equalsIgnoreCase(codigo)) {

            // Muestra los datos del accesorio encontrado.
            mostrar();
        }
    }

    // Metodo sobrecargado buscar(String nombre, int stockMinimo).
    // Busca por nombre y cantidad minima disponible.
    // Si cumple ambos criterios, devuelve el stock del accesorio.
    public int buscar(String nombre, int stockMinimo) {

        // Verifica el nombre, la cantidad solicitada y el stock.
        if (this.nombre != null
                && this.nombre.equalsIgnoreCase(nombre)
                && stockMinimo >= 0
                && this.stock >= stockMinimo) {

            // Devuelve la cantidad disponible.
            return this.stock;
        }

        // Devuelve -1 si no se encuentra una coincidencia valida.
        return -1;
    }
}