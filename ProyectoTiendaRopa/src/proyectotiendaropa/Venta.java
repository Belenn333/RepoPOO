/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotiendaropa;

/**
 *
 * @author USUARIO
 */
public class Venta {
    //Declaracion de atributos Clase Venta
    private String codigoVenta;
    private String fecha;
    private double subtotal;
    private double igv;
    private double total;

    //Aplicando encapsulamiento con getters y setters
    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    //Validación para evitar valores negativos en el subtotal
    public void setSubtotal(double subtotal) {
        if (subtotal >= 0) {
            this.subtotal = subtotal;
        }else {
            System.out.println("Error: El subtotal no puede ser negativo. ");
        }
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
   // Primera version del metodo calcularTotal: recibe el subtotal.
   // Calcula el total de la venta incluyendo el IGV del 18%.
    public double calcularTotal(double subtotal){
        return subtotal +(subtotal*0.18);
    }
    
    // Segunda version del metodo calcularTotal: recibe subtotal y descuento.
    // Aplica sobrecarga porque tiene el mismo nombre y distintos parametros.
    // Calcula el total incluyendo el IGV y aplicando un descuento.
    public double calcularTotal(double subtotal, double descuento ){
        double totalConIgv = subtotal + (subtotal * 0.18);
        return totalConIgv - descuento;
    }
    // Metodo para registrar los datos de una venta
public void registrarVenta(String codigoVenta, String fecha,
                           double subtotal, double igv) {

    // Verifica que el subtotal y el IGV sean valores validos
    if (subtotal >= 0 && igv >= 0) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = subtotal + igv;

        System.out.println("Venta registrada correctamente.");
    } else {
        System.out.println("Error: subtotal o IGV invalido.");
    }
    
   }
}
