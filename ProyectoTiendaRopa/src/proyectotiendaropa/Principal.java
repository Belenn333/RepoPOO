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

        // ArrayList que almacena los clientes registrados
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        // ArrayList que almacena los accesorios registrados.
        ArrayList<Accesorio> listaAccesorios = new ArrayList<Accesorio>();

        // Permite ingresar datos
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
            System.out.println("13. Salir");

            System.out.println("------------------");
            System.out.print("Ingrese opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1: {

                    String respuesta;

                    do {
                        //------------ VALIDACION DE AGREGAR------------------
                        //Solicita el código de la nueva prenda
                        System.out.print("Codigo: ");
                        String codigo = teclado.nextLine();
                        //Variable que permite verificar si el código de clase Ropa ya existe
                        boolean existe = false;

                        //Recorre el ArrayList para validar que el código sea único
                        for (Ropa r : listaRopa) {

                            //Compara el código ingresado con los códigos ya registrados
                            if (r.getCodigo().equalsIgnoreCase(codigo)) {

                                //Si encuentra coincidencia, marca el código como existente
                                existe = true;

                                //Finaliza el recorrido
                                break;
                            }
                        }

                        //Si el código no existe, se procede a registrar la prenda
                        if (!existe) {

                            //Solicita el nombre de la prenda
                            System.out.print("Nombre: ");
                            String nombre = teclado.nextLine();

                            //Solicita la talla
                            System.out.print("Talla: ");
                            String talla = teclado.nextLine();

                            //Solicita la categoría de la prenda
                            System.out.print("Categoria: ");
                            String categoria = teclado.nextLine();

                            //Solicita el color de la prenda
                            System.out.print("Color: ");
                            String color = teclado.nextLine();

                            //Solicita el precio de venta
                            System.out.print("Precio: ");
                            double precio = teclado.nextDouble();

                            //Solicita la cantidad disponible en stock
                            System.out.print("Stock: ");
                            int stock = teclado.nextInt();

                            //Valida que el precio Y stock sea mayor a cero
                            if (precio <= 0 && stock >= 0) {
                                System.out.println("Error: el precio debe ser mayor a cero.");
                            }

                            //Limpia el buffer
                            teclado.nextLine();

                            //Crea un nuevo objeto de la clase Ropa
                            Ropa ropa = new Ropa();

                            //Registra los datos de la nueva prenda
                            ropa.agregar(codigo,
                                    nombre,
                                    talla,
                                    categoria,
                                    color,
                                    precio,
                                    stock);

                            // Agrega la prenda al ArrayList
                            listaRopa.add(ropa);
                        } //Validacion de codigo existente con mensaje de error
                        else {
                            System.out.println("Error: el codigo ya existe.");
                        }

                        System.out.print("¿Desea registrar otra prenda? (S/N): ");

                        respuesta = teclado.nextLine();

                    } while (respuesta.equalsIgnoreCase("S"));
                    break;
                }
                case 2: {
                    //Verifica si existen prendas registradas               
                    if (listaRopa.isEmpty()) {
                        System.out.println("-------------------");
                        System.out.println("No hay prendas registradas.");
                    } else {
                        //Recorre y muestra todas las prendas registradas
                        for (Ropa r : listaRopa) {
                            System.out.println("-------------------");
                            r.mostrar();
                        }
                    }
                    break;
                }

                case 3: {
                    //Solicita el código de la prenda a buscar
                    System.out.print("Ingrese codigo: ");
                    String codigoBuscado = teclado.nextLine();

                    //Variable que indica si se encontró la prenda
                    //Se inicializa en false
                    boolean encontrado = false;

                    //Se recorre todas las prendas registradas
                    for (Ropa r : listaRopa) {
                        //Compara el código ingresado con el código de la prenda
                        if (r.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                            System.out.println("-------------------");
                            //Llama al método buscar de la clase Ropa
                            r.buscar(codigoBuscado);
                            //Marca la prenda como encontrada
                            encontrado = true;
                        }
                    }
                    //Si no se encontró ninguna coincidencia, muestra un mensaje
                    if (!encontrado) {
                        System.out.println("-------------------");
                        System.out.println("Prenda no encontrada.");
                        System.out.println("-------------------");
                    }
                    break;
                }
                case 4: {
                    //Solicita el nombre de la prenda
                    System.out.print("Nombre: ");
                    String nombreBuscado = teclado.nextLine();

                    //Solicita el color de la prenda
                    System.out.print("Color: ");
                    String colorBuscado = teclado.nextLine();

                    //Variable que indica si se encontró una coincidencia
                    boolean existePrenda = false;

                    for (Ropa r : listaRopa) {
                        if (r.getNombre().equalsIgnoreCase(nombreBuscado)
                                && r.getColor().equalsIgnoreCase(colorBuscado)) {
                            System.out.println("-------------------");
                            //Llama al método sobrecargado buscar(nombre, color)
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

                    //Solicita el código de la prenda
                    System.out.print("Ingrese codigo: ");
                    String cod = teclado.nextLine();

                    //Variable para verificar si la prenda existe
                    boolean existe = false;

                    //Recorre la lista de prendas
                    for (Ropa r : listaRopa) {

                        //Compara el código ingresado con el código registrado
                        if (r.getCodigo().equalsIgnoreCase(cod)) {

                            //Muestra la cantidad disponible en stock
                            System.out.println("Stock disponible: "
                                    + r.getStock());

                            //Marca la prenda como encontrada
                            existe = true;
                        }
                    }

                    //Si no se encontró la prenda
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
                    //Recorre la lista de prendas
                    for (Ropa r : listaRopa) {

                        if (r.getCodigo().equalsIgnoreCase(codigoMod)) {

                            System.out.print("Nuevo precio: ");
                            double nuevoPrecio = teclado.nextDouble();

                            System.out.print("Nuevo stock: ");
                            int nuevoStock = teclado.nextInt();
                            teclado.nextLine();

                            r.setPrecio(nuevoPrecio);
                            r.setStock(nuevoStock);

                            System.out.println("Prenda modificada.");

                            modificada = true;
                        }
                    }

                    if (!modificada) {
                        System.out.println("Prenda no encontrada.");
                    }

                    break;
                }
                case 7: {
                    //Solicita el código de la prenda que se desea eliminar
                    System.out.print("Codigo a eliminar: ");
                    String codigoEliminar = teclado.nextLine();
                    //Variable que indica si la prenda fue eliminada
                    boolean eliminada = false;

                    //Recorre la lista de prendas registradas
                    for (int i = 0; i < listaRopa.size(); i++) {
                        //Compara el código ingresado con el código de la prenda
                        if (listaRopa.get(i).getCodigo().equalsIgnoreCase(codigoEliminar)) {
                            //Elimina la prenda encontrada del ArrayList
                            listaRopa.remove(i);
                            //Marca la prenda como eliminada
                            eliminada = true;

                            System.out.println("-------------------");
                            System.out.println("Prenda eliminada.");
                            break;
                        }
                    }
                    //Si no se encontró la prenda, muestra un mensaje de error
                    if (!eliminada) {
                        System.out.println("-------------------");
                        System.out.println("Prenda no encontrada.");
                    }
                    break;
                }
                case 8: {
                    System.out.println("\n=== REGISTRAR CLIENTE ===");

                    System.out.print("Codigo: ");
                    String codigo = teclado.nextLine();

                    // Verifica que el codigo no este repetido
                    boolean existe = false;

                    for (Cliente c : listaClientes) {
                        if (c.getCodigo().equalsIgnoreCase(codigo)) {
                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Error: el codigo del cliente ya existe.");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("DNI: ");
                    String dni = teclado.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = teclado.nextLine();

                    // Crea el objeto Cliente
                    Cliente cliente = new Cliente();

                    // Registra los datos del cliente
                    cliente.agregar(codigo, nombre, dni, telefono);

                    // Valida los datos ingresados
                    if (cliente.validarDatos()) {
                        listaClientes.add(cliente);
                        System.out.println("Cliente registrado correctamente.");
                    } else {
                        System.out.println("Error: los datos ingresados no son validos.");
                    }

                    break;
                }
                case 9: {
                    System.out.println("\n=== MODIFICAR CLIENTE ===");

                    System.out.print("Codigo del cliente: ");
                    String codigoMod = teclado.nextLine();

                    boolean modificado = false;

                    for (Cliente c : listaClientes) {
                        if (c.getCodigo().equalsIgnoreCase(codigoMod)) {

                            System.out.print("Nuevo nombre: ");
                            String nombre = teclado.nextLine();

                            System.out.print("Nuevo DNI: ");
                            String dni = teclado.nextLine();

                            System.out.print("Nuevo telefono: ");
                            String telefono = teclado.nextLine();

                            c.modificar(nombre, dni, telefono);

                            System.out.println("Cliente modificado correctamente.");
                            modificado = true;
                            break;
                        }
                    }

                    if (!modificado) {
                        System.out.println("Cliente no encontrado.");
                    }

                    break;
                }
                case 10: {
                    System.out.println("\n=== BUSCAR CLIENTE ===");

                    System.out.println("1. Buscar por codigo");
                    System.out.println("2. Buscar por nombre y DNI");
                    System.out.print("Seleccione una opcion: ");

                    int tipoBusqueda = teclado.nextInt();
                    teclado.nextLine();

                    boolean encontrado = false;

                    if (tipoBusqueda == 1) {

                        System.out.print("Codigo del cliente: ");
                        String codigoBuscado = teclado.nextLine();

                        // Recorre la lista de clientes
                        for (Cliente c : listaClientes) {

                            // Verifica si el codigo coincide
                            if (c.getCodigo().equalsIgnoreCase(codigoBuscado)) {

                                // Llama al método buscar(String codigo)
                                c.buscar(codigoBuscado);

                                encontrado = true;
                                break;
                            }
                        }

                    } else if (tipoBusqueda == 2) {

                        System.out.print("Nombre del cliente: ");
                        String nombreBuscado = teclado.nextLine();

                        System.out.print("DNI del cliente: ");
                        String dniBuscado = teclado.nextLine();

                        // Recorre la lista de clientes
                        for (Cliente c : listaClientes) {

                            // Verifica si coinciden el nombre y el DNI
                            if (c.getNombre().equalsIgnoreCase(nombreBuscado)
                                    && c.getDni().equals(dniBuscado)) {

                                // Llama al método buscar(String nombre, String dni)
                                c.buscar(nombreBuscado, dniBuscado);

                                encontrado = true;
                                break;
                            }
                        }

                    } else {
                        System.out.println("Opcion no valida.");
                        break;
                    }

                    if (!encontrado) {
                        System.out.println("Cliente no encontrado.");
                    }

                    break;
                }
                case 11: {
                    System.out.println("\n=== LISTAR CLIENTES ===");

                    if (listaClientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {

                        // Recorre y muestra todos los clientes registrados
                        for (Cliente c : listaClientes) {
                            System.out.println("-------------------");
                            c.mostrar();
                        }
                    }

                    break;
                }
                case 12: {
                    System.out.println("\n=== ELIMINAR CLIENTE ===");

                    System.out.print("Codigo del cliente: ");
                    String codigoEliminar = teclado.nextLine();

                    boolean eliminado = false;

                    for (int i = 0; i < listaClientes.size(); i++) {
                        if (listaClientes.get(i).getCodigo().equalsIgnoreCase(codigoEliminar)) {

                            Cliente cliente = listaClientes.get(i);

                            // Elimina los datos del cliente
                            cliente.eliminar();

                            // Elimina el cliente del ArrayList
                            listaClientes.remove(i);

                            System.out.println("Cliente eliminado correctamente.");
                            eliminado = true;
                            break;
                        }
                    }

                    if (!eliminado) {
                        System.out.println("Cliente no encontrado.");
                    }

                    break;
                }
            }
        } while (opcion != 13);

        teclado.close();

    }
}
