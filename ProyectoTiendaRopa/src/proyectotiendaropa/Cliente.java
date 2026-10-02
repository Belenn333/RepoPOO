/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotiendaropa;

/**
 *
 * @author USUARIO
 */
public class Cliente {
    //Declaracion de atributos Clase Cliente
    private String codigo;
    private String nombre;
    private String dni;
    private String telefono;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    // Método sin parámetros. Muestra toda la información del cliente.
public void mostrar() {
    System.out.println("Codigo: " + codigo);
    System.out.println("Nombre: " + nombre);
    System.out.println("DNI: " + dni);
    System.out.println("Telefono: " + telefono);
}

// Sobrecarga de métodos para buscar clientes por diferentes criterios

// Primera versión del método buscar: recibe un código.
public void buscar(String codigo) {
    if (this.codigo != null && this.codigo.equalsIgnoreCase(codigo)) {
        mostrar();
    }
}

// Segunda versión del método buscar: recibe nombre y DNI.
public void buscar(String nombre, String dni) {
    if (this.nombre != null
            && this.nombre.equalsIgnoreCase(nombre)
            && this.dni != null
            && this.dni.equals(dni)) {
        mostrar();
    }
}

// Validación de datos del cliente
public boolean validarDatos() {
    if (codigo == null || codigo.isEmpty()) {
        return false;
    }

    if (nombre == null || nombre.isEmpty()) {
        return false;
    }

    if (dni == null || dni.isEmpty()) {
        return false;
    }

    if (telefono == null || telefono.isEmpty()) {
        return false;
    }

    return true;
}
}
