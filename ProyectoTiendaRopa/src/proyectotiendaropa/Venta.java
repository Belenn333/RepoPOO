/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotiendaropa;

import java.util.ArrayList;

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
    
    //Cliente asociado a la venta
    private Cliente cliente;
    
    //Listas de productos agregados a la venta
    private ArrayList<Ropa> prendas;
    
    private ArrayList<Accesorio> accesorios;
    
    //Constructor de la clase Venta 
    public Venta(){
        prendas = new ArrayList<>();
        
        accesorios = new ArrayList<>();
    }
    
    // Asocia un cliente a la venta
    public void asociarCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
            System.out.println("Cliente asociado correctamente.");
        } else {
            System.out.println("Error: cliente no valido.");
        }
    }
    
    // Agrega una prenda a la venta verificando su stock
    public void agregarPrenda(Ropa prenda) {
        if (prenda != null && prenda.getStock() > 0) {
            prendas.add(prenda);
            System.out.println("Prenda agregada a la venta.");
        } else {
            System.out.println("Error: prenda no disponible o sin stock.");
        }
    }
    
    // Agrega un accesorio a la venta verificando su stock
    public void agregarAccesorio(Accesorio accesorio) {
        if (accesorio != null && accesorio.getStock() > 0) {
            accesorios.add(accesorio);
            System.out.println("Accesorio agregado a la venta.");
        } else {
            System.out.println("Error: accesorio no disponible o sin stock.");
        }
    }
    
    // Calcula el subtotal sumando las prendas y accesorios de la venta
    public double calcularSubtotal() {
        double suma = 0;

        // Suma el precio de todas las prendas
        for (Ropa prenda : prendas) {
            suma += prenda.getPrecio();
        }

        // Suma el precio de todos los accesorios
        for (Accesorio accesorio : accesorios) {
            suma += accesorio.getPrecio();
        }

        this.subtotal = suma;
        return subtotal;
    }
    
    // Calcula el monto total de la venta incluyendo el IGV del 18%
    public double calcularTotal() {
        calcularSubtotal();

        this.igv = this.subtotal * 0.18;
        this.total = this.subtotal + this.igv;

        return this.total;
    }

    // Genera y muestra el comprobante de la venta
    public void generarComprobante() {
        calcularTotal();

        System.out.println("\n=== COMPROBANTE DE VENTA ===");
        System.out.println("Codigo de venta: " + codigoVenta);
        System.out.println("Fecha: " + fecha);

        // Muestra el cliente asociado
        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("DNI: " + cliente.getDni());
        }

        System.out.println("\n--- PRENDAS ---");
        for (Ropa prenda : prendas) {
            System.out.println(prenda.getNombre()
                    + " - S/ " + prenda.getPrecio());
        }

        System.out.println("\n--- ACCESORIOS ---");
        for (Accesorio accesorio : accesorios) {
            System.out.println(accesorio.getNombre()
                    + " - S/ " + accesorio.getPrecio());
        }

        System.out.println("---------------------------");
        System.out.println("Subtotal: S/ " + subtotal);
        System.out.println("IGV (18%): S/ " + igv);
        System.out.println("Total: S/ " + total);
        System.out.println("===========================");
    }

    // Muestra el detalle completo de la venta
    public void mostrarDetalle() {
        System.out.println("\n=== DETALLE DE VENTA ===");
        System.out.println("Codigo: " + codigoVenta);
        System.out.println("Fecha: " + fecha);

        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getNombre());
        } else {
            System.out.println("Cliente: No asociado");
        }

        System.out.println("\nPrendas:");
        for (Ropa prenda : prendas) {
            System.out.println("- " + prenda.getNombre()
                    + " | Precio: S/ " + prenda.getPrecio());
        }

        System.out.println("\nAccesorios:");
        for (Accesorio accesorio : accesorios) {
            System.out.println("- " + accesorio.getNombre()
                    + " | Precio: S/ " + accesorio.getPrecio());
        }

        calcularTotal();

        System.out.println("\nSubtotal: S/ " + subtotal);
        System.out.println("IGV: S/ " + igv);
        System.out.println("Total: S/ " + total);
    }
    
    // Actualiza el stock de los productos despues de realizar la venta
    public void actualizarStock() {

        // Descuenta una unidad por cada prenda agregada a la venta
        for (Ropa prenda : prendas) {
            if (prenda.getStock() > 0) {
                prenda.setStock(prenda.getStock() - 1);
            }
        }

        // Descuenta una unidad por cada accesorio agregado a la venta
        for (Accesorio accesorio : accesorios) {
            if (accesorio.getStock() > 0) {
                accesorio.setStock(accesorio.getStock() - 1);
            }
        }

        System.out.println("Stock actualizado correctamente.");
    }
    

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
    
    // Registra la venta y calcula automaticamente sus montos
    public void registrarVenta(String codigoVenta, String fecha) {
        if (codigoVenta != null && !codigoVenta.trim().isEmpty()
                && fecha != null && !fecha.trim().isEmpty()) {

            this.codigoVenta = codigoVenta;
            this.fecha = fecha;

            calcularTotal();

            System.out.println("Venta registrada correctamente.");
        } else {
            System.out.println("Error: codigo de venta o fecha no validos.");
        }
    }

    // Metodo para registrar los datos de una venta
    public void registrarVenta(String codigoVenta, String fecha, double subtotal, double igv) {

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
