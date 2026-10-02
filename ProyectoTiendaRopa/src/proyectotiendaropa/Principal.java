/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectotiendaropa;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        //ArrayList que almacena todas las prendas registradas
        ArrayList<Ropa> listaRopa = new ArrayList<>();

        //ArrayList que almacena los clientes registrados
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        //ArrayList que almacena los accesorios registrados
        ArrayList<Accesorio> listaAccesorios = new ArrayList<Accesorio>();

        //ArrayList que almacena las ventas registradas
        ArrayList<Venta> listaVentas = new ArrayList<>();

        //Permite ingresar datos
        Scanner teclado = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n=== MENU TIENDA DE ROPA ===");

            System.out.println("\n=== MODULO ROPA ===");
            System.out.println("1. Registrar prenda");
            System.out.println("2. Mostrar prendas");
            System.out.println("3. Buscar por codigo");
            System.out.println("4. Buscar por nombre y color");
            System.out.println("5. Consultar stock");
            System.out.println("6. Modificar prenda");
            System.out.println("7. Eliminar prenda");

            System.out.println("\n=== MODULO CLIENTES ===");
            System.out.println("8. Registrar cliente");
            System.out.println("9. Modificar cliente");
            System.out.println("10. Buscar cliente por __");
            System.out.println("11. Listar cliente");
            System.out.println("12. Elimininar cliente");

            System.out.println("\n=== MODULO VENTAS ===");
            System.out.println("13. Registrar venta");
            System.out.println("14. Consultar ventas realizadas");
            System.out.println("15. Buscar venta por codigo");
            System.out.println("16. Mostrar detalle de venta");
            System.out.println("17. Generar comprobante de venta");
            System.out.println("18. Salir");

            System.out.println("------------------");
            System.out.print("Ingrese opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                //==================================================
                // MODULO ROPA
                //==================================================

                case 1: {

                    String respuesta;

                    do {

                        //------------ VALIDACION DE AGREGAR ------------------
                        System.out.print("Codigo: ");
                        String codigo = teclado.nextLine();

                        boolean existe = false;

                        for (Ropa r : listaRopa) {

                            if (r.getCodigo().equalsIgnoreCase(codigo)) {
                                existe = true;
                                break;
                            }
                        }

                        if (!existe) {

                            System.out.print("Nombre: ");
                            String nombre = teclado.nextLine();

                            System.out.print("Talla: ");
                            String talla = teclado.nextLine();

                            System.out.print("Categoria: ");
                            String categoria = teclado.nextLine();

                            System.out.print("Color: ");
                            String color = teclado.nextLine();

                            System.out.print("Precio: ");
                            double precio = teclado.nextDouble();

                            System.out.print("Stock: ");
                            int stock = teclado.nextInt();

                            if (precio <= 0 && stock >= 0) {
                                System.out.println(
                                        "Error: el precio debe ser mayor a cero.");
                            }

                            teclado.nextLine();

                            Ropa ropa = new Ropa();

                            ropa.agregar(
                                    codigo,
                                    nombre,
                                    talla,
                                    categoria,
                                    color,
                                    precio,
                                    stock
                            );

                            listaRopa.add(ropa);

                        } else {
                            System.out.println(
                                    "Error: el codigo ya existe.");
                        }

                        System.out.print(
                                "¿Desea registrar otra prenda? (S/N): ");

                        respuesta = teclado.nextLine();

                    } while (respuesta.equalsIgnoreCase("S"));

                    break;
                }

                case 2: {

                    if (listaRopa.isEmpty()) {

                        System.out.println("-------------------");
                        System.out.println(
                                "No hay prendas registradas.");

                    } else {

                        for (Ropa r : listaRopa) {

                            System.out.println("-------------------");
                            r.mostrar();
                        }
                    }

                    break;
                }

                case 3: {

                    System.out.print("Ingrese codigo: ");
                    String codigoBuscado = teclado.nextLine();

                    boolean encontrado = false;

                    for (Ropa r : listaRopa) {

                        if (r.getCodigo()
                                .equalsIgnoreCase(codigoBuscado)) {

                            System.out.println("-------------------");

                            r.buscar(codigoBuscado);

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {

                        System.out.println("-------------------");
                        System.out.println("Prenda no encontrada.");
                        System.out.println("-------------------");
                    }

                    break;
                }

                case 4: {

                    System.out.print("Nombre: ");
                    String nombreBuscado = teclado.nextLine();

                    System.out.print("Color: ");
                    String colorBuscado = teclado.nextLine();

                    boolean existePrenda = false;

                    for (Ropa r : listaRopa) {

                        if (r.getNombre()
                                .equalsIgnoreCase(nombreBuscado)
                                && r.getColor()
                                        .equalsIgnoreCase(colorBuscado)) {

                            System.out.println("-------------------");

                            r.buscar(nombreBuscado, colorBuscado);

                            existePrenda = true;
                        }
                    }

                    if (!existePrenda) {

                        System.out.println("-------------------");
                        System.out.println("Prenda no encontrada.");
                        System.out.println("-------------------");
                    }

                    break;
                }

                case 5: {

                    System.out.print("Ingrese codigo: ");
                    String cod = teclado.nextLine();

                    boolean existe = false;

                    for (Ropa r : listaRopa) {

                        if (r.getCodigo().equalsIgnoreCase(cod)) {

                            System.out.println(
                                    "Stock disponible: "
                                    + r.getStock());

                            existe = true;
                        }
                    }

                    if (!existe) {

                        System.out.println("-------------------");
                        System.out.println("Prenda no encontrada.");
                        System.out.println("-------------------");
                    }

                    break;
                }

                case 6: {

                    System.out.print("Codigo de la prenda: ");
                    String codigoMod = teclado.nextLine();

                    boolean modificada = false;

                    for (Ropa r : listaRopa) {

                        if (r.getCodigo()
                                .equalsIgnoreCase(codigoMod)) {

                            System.out.print("Nuevo precio: ");
                            double nuevoPrecio =
                                    teclado.nextDouble();

                            System.out.print("Nuevo stock: ");
                            int nuevoStock =
                                    teclado.nextInt();

                            teclado.nextLine();

                            r.setPrecio(nuevoPrecio);
                            r.setStock(nuevoStock);

                            System.out.println(
                                    "Prenda modificada.");

                            modificada = true;
                        }
                    }

                    if (!modificada) {
                        System.out.println(
                                "Prenda no encontrada.");
                    }

                    break;
                }

                case 7: {

                    System.out.print(
                            "Codigo a eliminar: ");

                    String codigoEliminar =
                            teclado.nextLine();

                    boolean eliminada = false;

                    for (int i = 0;
                            i < listaRopa.size();
                            i++) {

                        if (listaRopa.get(i)
                                .getCodigo()
                                .equalsIgnoreCase(
                                        codigoEliminar)) {

                            listaRopa.remove(i);

                            eliminada = true;

                            System.out.println(
                                    "-------------------");

                            System.out.println(
                                    "Prenda eliminada.");

                            break;
                        }
                    }

                    if (!eliminada) {

                        System.out.println(
                                "-------------------");

                        System.out.println(
                                "Prenda no encontrada.");
                    }

                    break;
                }


                //==================================================
                // MODULO VENTAS
                //==================================================

                case 13: {

                    System.out.println(
                            "\n=== REGISTRAR VENTA ===");

                    //Verifica que existan clientes
                    if (listaClientes.isEmpty()) {

                        System.out.println(
                                "Error: no hay clientes registrados.");

                        break;
                    }

                    //Verifica que existan productos
                    if (listaRopa.isEmpty()
                            && listaAccesorios.isEmpty()) {

                        System.out.println(
                                "Error: no hay productos registrados.");

                        break;
                    }

                    Venta nuevaVenta = new Venta();

                    //Codigo de venta
                    System.out.print(
                            "Codigo de venta: ");

                    String codigoVenta =
                            teclado.nextLine();

                    //Valida codigo duplicado
                    boolean codigoRepetido = false;

                    for (Venta v : listaVentas) {

                        if (v.getCodigoVenta() != null
                                && v.getCodigoVenta()
                                        .equalsIgnoreCase(
                                                codigoVenta)) {

                            codigoRepetido = true;
                            break;
                        }
                    }

                    if (codigoRepetido) {

                        System.out.println(
                                "Error: el codigo de venta ya existe.");

                        break;
                    }

                    //Fecha
                    System.out.print(
                            "Fecha de la venta: ");

                    String fechaVenta =
                            teclado.nextLine();

                    //Cliente
                    System.out.print(
                            "Codigo del cliente: ");

                    String codigoCliente =
                            teclado.nextLine();

                    Cliente clienteEncontrado = null;

                    for (Cliente c : listaClientes) {

                        if (c.getCodigo()
                                .equalsIgnoreCase(
                                        codigoCliente)) {

                            clienteEncontrado = c;
                            break;
                        }
                    }

                    if (clienteEncontrado == null) {

                        System.out.println(
                                "Error: cliente no encontrado.");

                        break;
                    }

                    nuevaVenta.asociarCliente(
                            clienteEncontrado);


                    //==============================================
                    // AGREGAR PRENDAS
                    //==============================================

                    if (!listaRopa.isEmpty()) {

                        System.out.print(
                                "¿Desea agregar prendas? (S/N): ");

                        String deseaPrenda =
                                teclado.nextLine();

                        if (deseaPrenda.equalsIgnoreCase("S")) {

                            String agregarOtraPrenda;

                            do {

                                System.out.print(
                                        "Codigo de la prenda: ");

                                String codigoPrenda =
                                        teclado.nextLine();

                                Ropa prendaEncontrada = null;

                                for (Ropa r : listaRopa) {

                                    if (r.getCodigo()
                                            .equalsIgnoreCase(
                                                    codigoPrenda)) {

                                        prendaEncontrada = r;
                                        break;
                                    }
                                }

                                if (prendaEncontrada != null) {

                                    nuevaVenta.agregarPrenda(
                                            prendaEncontrada);

                                } else {

                                    System.out.println(
                                            "Error: prenda no encontrada.");
                                }

                                System.out.print(
                                        "¿Desea agregar otra prenda? (S/N): ");

                                agregarOtraPrenda =
                                        teclado.nextLine();

                            } while (agregarOtraPrenda
                                    .equalsIgnoreCase("S"));
                        }
                    }


                    //==============================================
                    // AGREGAR ACCESORIOS
                    //==============================================

                    if (!listaAccesorios.isEmpty()) {

                        System.out.print(
                                "¿Desea agregar accesorios? (S/N): ");

                        String deseaAccesorio =
                                teclado.nextLine();

                        if (deseaAccesorio
                                .equalsIgnoreCase("S")) {

                            String agregarOtroAccesorio;

                            do {

                                System.out.print(
                                        "Codigo del accesorio: ");

                                String codigoAccesorio =
                                        teclado.nextLine();

                                Accesorio accesorioEncontrado =
                                        null;

                                for (Accesorio a
                                        : listaAccesorios) {

                                    if (a.getCodigo()
                                            .equalsIgnoreCase(
                                                    codigoAccesorio)) {

                                        accesorioEncontrado = a;
                                        break;
                                    }
                                }

                                if (accesorioEncontrado != null) {

                                    nuevaVenta.agregarAccesorio(
                                            accesorioEncontrado);

                                } else {

                                    System.out.println(
                                            "Error: accesorio no encontrado.");
                                }

                                System.out.print(
                                        "¿Desea agregar otro accesorio? (S/N): ");

                                agregarOtroAccesorio =
                                        teclado.nextLine();

                            } while (agregarOtroAccesorio
                                    .equalsIgnoreCase("S"));
                        }
                    }


                    //Registra la venta
                    nuevaVenta.registrarVenta(
                            codigoVenta,
                            fechaVenta);

                    //Actualiza el stock
                    nuevaVenta.actualizarStock();

                    //Guarda la venta
                    listaVentas.add(nuevaVenta);

                    System.out.println(
                            "-------------------");

                    System.out.println(
                            "Total de la venta: S/ "
                            + nuevaVenta.getTotal());

                    System.out.println(
                            "Venta guardada correctamente.");

                    break;
                }


                //==================================================
                // CONSULTAR VENTAS REALIZADAS
                //==================================================

                case 14: {

                    System.out.println(
                            "\n=== VENTAS REALIZADAS ===");

                    if (listaVentas.isEmpty()) {

                        System.out.println(
                                "No hay ventas registradas.");

                    } else {

                        for (Venta v : listaVentas) {

                            System.out.println(
                                    "-------------------");

                            System.out.println(
                                    "Codigo: "
                                    + v.getCodigoVenta());

                            System.out.println(
                                    "Fecha: "
                                    + v.getFecha());

                            System.out.println(
                                    "Total: S/ "
                                    + v.getTotal());
                        }
                    }

                    break;
                }


                //==================================================
                // BUSCAR VENTA POR CODIGO
                //==================================================

                case 15: {

                    System.out.println(
                            "\n=== BUSCAR VENTA ===");

                    System.out.print(
                            "Ingrese codigo de venta: ");

                    String codigoBuscarVenta =
                            teclado.nextLine();

                    Venta ventaEncontrada = null;

                    for (Venta v : listaVentas) {

                        if (v.getCodigoVenta()
                                .equalsIgnoreCase(
                                        codigoBuscarVenta)) {

                            ventaEncontrada = v;
                            break;
                        }
                    }

                    if (ventaEncontrada != null) {

                        System.out.println(
                                "Venta encontrada.");

                        ventaEncontrada.mostrarDetalle();

                    } else {

                        System.out.println(
                                "Venta no encontrada.");
                    }

                    break;
                }


                //==================================================
                // MOSTRAR DETALLE DE VENTA
                //==================================================

                case 16: {

                    System.out.println(
                            "\n=== DETALLE DE VENTA ===");

                    System.out.print(
                            "Ingrese codigo de venta: ");

                    String codigoDetalle =
                            teclado.nextLine();

                    Venta ventaDetalle = null;

                    for (Venta v : listaVentas) {

                        if (v.getCodigoVenta()
                                .equalsIgnoreCase(
                                        codigoDetalle)) {

                            ventaDetalle = v;
                            break;
                        }
                    }

                    if (ventaDetalle != null) {

                        ventaDetalle.mostrarDetalle();

                    } else {

                        System.out.println(
                                "Venta no encontrada.");
                    }

                    break;
                }


                //==================================================
                // GENERAR COMPROBANTE
                //==================================================

                case 17: {

                    System.out.println(
                            "\n=== GENERAR COMPROBANTE ===");

                    System.out.print(
                            "Ingrese codigo de venta: ");

                    String codigoComprobante =
                            teclado.nextLine();

                    Venta ventaComprobante = null;

                    for (Venta v : listaVentas) {

                        if (v.getCodigoVenta()
                                .equalsIgnoreCase(
                                        codigoComprobante)) {

                            ventaComprobante = v;
                            break;
                        }
                    }

                    if (ventaComprobante != null) {

                        ventaComprobante
                                .generarComprobante();

                    } else {

                        System.out.println(
                                "Venta no encontrada.");
                    }

                    break;
                }


                //==================================================
                // SALIR
                //==================================================

                case 18: {

                    System.out.println(
                            "Saliendo del sistema...");

                    break;
                }

            }

        } while (opcion != 18);

        teclado.close();
    }
}