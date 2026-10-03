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
        
        //ArrayList que almacena las ventas registradas
        ArrayList<Venta> listaVentas = new ArrayList<>();

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
            System.out.println("10. Buscar cliente por codigo o nombre");
            System.out.println("11. Listar cliente");
            System.out.println("12. Elimininar cliente");
            System.out.println("\n=== MODULO ACCESORIOS ===");
            System.out.println("13. Registrar accesorio");
            System.out.println("14. Modificar accesorio");
            System.out.println("15. Eliminar accesorio");
            System.out.println("16. Buscar accesorio por codigo");
            System.out.println("17. Buscar accesorio por nombre");
            System.out.println("18. Consultar stock de accesorio");
            System.out.println("19. Listar accesorios registrados");
            System.out.println("\n=== MODULO VENTAS ===");
            System.out.println("20. Registrar venta");
            System.out.println("21. Consultar ventas realizadas");
            System.out.println("22. Buscar venta por codigo");
            System.out.println("23. Mostrar detalle de venta");
            System.out.println("24. Generar comprobante de venta");
            System.out.println("25. Salir");
            
            System.out.println("------------------");
            System.out.print("Ingrese opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1: {
                    System.out.println("\n=== REGISTRAR PRENDA ===");

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
                    System.out.println("\n=== LISTADO DE PRENDAS ===");
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
                    System.out.println("\n=== BUSCAR PRENDA POR CODIGO ===");
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
                    System.out.println("\n=== BUSCAR PRENDA POR NOMBRE ===");
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
                    System.out.println("\n=== STOCK DE PRENDAS ===");
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
                    
                    System.out.println("\n=== MODIFICAR PRENDA ===");

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
                    System.out.println("\n=== ELIMINAR PRENDA ===");
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

                    String respuesta;

                    do{

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
                        }
                        else{

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
                            } 
                            else {
                                System.out.println("Error: los datos ingresados no son validos.");
                            }
                        }

                        // Pregunta si desea registrar otro cliente
                        System.out.print("¿Desea registrar otro cliente? (S/N): ");
                        respuesta = teclado.nextLine();

                    }while(respuesta.equalsIgnoreCase("S"));

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
                            }
                        }

                    } 
                    else {
                        System.out.println("Opcion no valida.");
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
                        }
                    }
                    teclado.close();
                    if (!eliminado) {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                }
                // RF13. Registrar accesorios.
                case 13: {
                    System.out.println("\n=== REGISTRAR ACCESORIOS ===");
                    String respuesta;

                    do {
                        // Solicita el codigo del nuevo accesorio.
                        System.out.print("Codigo: ");
                        String codigo = teclado.nextLine();

                        // Verifica si el codigo ya existe.
                        boolean existe = false;

                        for(Accesorio a : listaAccesorios){
                            if(a.getCodigo().equalsIgnoreCase(codigo)){
                                existe = true;
                            }
                        }

                        if(codigo.trim().isEmpty()){
                            System.out.println("Error: el codigo es obligatorio.");
                        }
                        else if(!existe){

                            System.out.print("Nombre: ");
                            String nombre = teclado.nextLine();

                            System.out.print("Precio: ");
                            double precio = teclado.nextDouble();

                            System.out.print("Stock: ");
                            int stock = teclado.nextInt();
                            teclado.nextLine();

                            // Valida los datos antes de agregar a la lista.
                            if(!nombre.trim().isEmpty()
                                    && precio > 0 && stock >= 0){

                                // Crea el accesorio y asigna sus datos.
                                Accesorio accesorio = new Accesorio();

                                accesorio.setCodigo(codigo);
                                accesorio.setNombre(nombre);
                                accesorio.setPrecio(precio);
                                accesorio.setStock(stock);

                                // Agrega el accesorio al ArrayList.
                                listaAccesorios.add(accesorio);

                                System.out.println(
                                        "Accesorio registrado correctamente.");
                            }
                            else{
                                System.out.println(
                                        "Error: nombre obligatorio, precio mayor "
                                        + "a cero y stock no negativo.");
                            }
                        }
                        else{
                            System.out.println("Error: el codigo ya existe.");
                        }

                        System.out.print(
                                "¿Desea registrar otro accesorio? (S/N): ");
                        respuesta = teclado.nextLine();

                    }while(respuesta.equalsIgnoreCase("S"));

                    break;
                }
                  

                // RF14. Modificar accesorios.
                case 14: {
                    System.out.println("\n=== MODIFICAR ACCESORIOS ===");
                    System.out.print("Codigo del accesorio: ");
                    String codigoMod = teclado.nextLine();

                    boolean encontrado = false;

                    // Recorre los accesorios registrados.
                    for(Accesorio a : listaAccesorios){

                        if(a.getCodigo().equalsIgnoreCase(codigoMod)){

                            encontrado = true;

                            System.out.print("Nuevo precio: ");
                            double nuevoPrecio = teclado.nextDouble();

                            System.out.print("Nuevo stock: ");
                            int nuevoStock = teclado.nextInt();
                            teclado.nextLine();

                            // Verifica ambos valores antes de modificar.
                            if(nuevoPrecio > 0 && nuevoStock >= 0){

                                a.setPrecio(nuevoPrecio);
                                a.setStock(nuevoStock);

                                System.out.println("Accesorio modificado.");
                            }
                            else{
                                System.out.println(
                                        "Error: precio mayor a cero "
                                        + "y stock no negativo.");
                            }
                        }
                    }
                          
                    if(!encontrado){
                    System.out.println("Accesorio no encontrado.");
                    }
                  break;
                }
                          
                // RF15. Eliminar accesorios.
                case 15: {
                    System.out.println("\n=== ELIMINAR ACCESORIOS ===");
                    System.out.print("Codigo a eliminar: ");
                    String codigoEliminar = teclado.nextLine();

                    boolean eliminado = false;

                    // Recorre la lista utilizando un indice.
                    for(int i = 0; i < listaAccesorios.size(); i++){

                        if(listaAccesorios.get(i).getCodigo()
                                .equalsIgnoreCase(codigoEliminar)){

                            listaAccesorios.remove(i);
                            eliminado = true;

                            System.out.println("-------------------");
                            System.out.println("Accesorio eliminado.");
                        }
                    }

                    if(!eliminado){
                        System.out.println("-------------------");
                        System.out.println("Accesorio no encontrado.");
                    }

                    break;
                }

                // RF16. Buscar accesorios por codigo.
                case 16: {
                    System.out.println("\n=== BUSCAR ACCESORIOS POR CODIGO ===");
                    System.out.print("Ingrese codigo: ");
                    String codigoBuscado = teclado.nextLine();

                    boolean encontrado = false;

                    for(Accesorio a : listaAccesorios){

                        if(a.getCodigo().equalsIgnoreCase(codigoBuscado)){

                            System.out.println("-------------------");

                            // Utiliza el metodo existente en Accesorio.
                            a.buscar(codigoBuscado);
                            encontrado = true;
                        }
                    }

                    if(!encontrado){
                        System.out.println("-------------------");
                        System.out.println("Accesorio no encontrado.");
                    }
                    break;
                }

                // RF17. Buscar accesorios por nombre.
                case 17: {
                    System.out.println("\n=== BUSCAR ACCESORIOS POR NOMBRE ===");

                    System.out.print("Nombre: ");
                    String nombreBuscado = teclado.nextLine();

                    boolean encontrado = false;

                    // Muestra todos los accesorios con ese nombre.
                    for(Accesorio a : listaAccesorios){

                        if(a.getNombre().equalsIgnoreCase(nombreBuscado)){

                            System.out.println("-------------------");
                            a.mostrar();
                            encontrado = true;
                        }
                    }

                    if(!encontrado){
                        System.out.println("-------------------");
                        System.out.println("Accesorio no encontrado.");
                    }

                    break;
                }

                // RF18. Consultar stock de accesorios.
                case 18: {
                    System.out.println("\n=== STOCK DE ACCESORIOS ===");
                    System.out.print("Ingrese codigo: ");
                    String cod = teclado.nextLine();

                    boolean existe = false;

                    for(Accesorio a : listaAccesorios){

                        if(a.getCodigo().equalsIgnoreCase(cod)){

                            System.out.println(
                                    "Stock disponible: " + a.getStock());

                            existe = true;
                        }       
                    }
                    if(!existe){
                        System.out.println("-------------------");
                        System.out.println("Accesorio no encontrado.");
                    }

                    break;
                }

                // RF19. Listar accesorios registrados.
                case 19: {
                    System.out.println("\n=== LISTAR ACCESORIOS ===");

                    if(listaAccesorios.isEmpty()){
                        System.out.println("-------------------");
                        System.out.println("No hay accesorios registrados.");
                    }
                    else{
                        // Recorre y muestra todos los accesorios.
                        for(Accesorio a : listaAccesorios){
                            System.out.println("-------------------");
                            a.mostrar();
                        }
                    }
                    break;
                }
                
                case 20: {
                    System.out.println(
                            "\n=== REGISTRAR VENTA ===");

                    //Verifica que existan clientes
                    if (listaClientes.isEmpty()) {
                        System.out.println(
                                "Error: no hay clientes registrados.");                 
                    }

                    //Verifica que existan productos
                    if (listaRopa.isEmpty()
                            && listaAccesorios.isEmpty()) {
                        System.out.println(
                                "Error: no hay productos registrados.");
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
                        if (v.getCodigoVenta() != null && v.getCodigoVenta().equalsIgnoreCase(codigoVenta)) {
                            codigoRepetido = true;
                        }
                    }

                    if (codigoRepetido) {
                        System.out.println("Error: el codigo de venta ya existe.");
                    }

                    //Fecha
                    System.out.print("Fecha de la venta: ");
                    String fechaVenta = teclado.nextLine();

                    //Cliente
                    System.out.print("Codigo del cliente: ");
                    String codigoCliente = teclado.nextLine();

                    Cliente clienteEncontrado = null;

                    for (Cliente c : listaClientes) {
                        if (c.getCodigo().equalsIgnoreCase(codigoCliente)) {

                            clienteEncontrado = c;
                            break;
                        }
                    }

                    if (clienteEncontrado == null) {
                        System.out.println("Error: cliente no encontrado.");
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
                case 21: {

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

                case 22: {

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
                case 23: {
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
                case 24: {
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
                case 25: {
                    System.out.println("Hasta luego.");
                    break;
                }
            }
        }while(opcion != 25);
                      
        teclado.close();
      
    }
}
