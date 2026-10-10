package proyectotiendaropa;

import proyectotiendaropa.vistaPrenda.RegistrarPrenda;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
    public static ArrayList<Ropa> listaRopa = new ArrayList<>();

    // Lista compartida para el modulo Accesorios y sus formularios.
    public static ArrayList<Accesorio> listaAccesorios = new ArrayList<>();

    // Permite cargar el TXT una sola vez al abrir los formularios.
    private static boolean accesoriosCargados = false;

    public static void asegurarCargaAccesorios() {
        if (!accesoriosCargados) {
            cargarAccesorios();
        }
    }
    
    public static void guardarTodasLasPrendas() {

        try {

            FileWriter archivo = new FileWriter("D:\\Tecnicas de POO\\ProyectoFinal\\ProyectoTiendaRopa\\src\\TXTs\\prendas.txt");

            for(Ropa r : listaRopa){

                archivo.write(
                        r.getCodigo() + ";" +
                        r.getNombre() + ";" +
                        r.getTalla() + ";" +
                        r.getCategoria() + ";" +
                        r.getColor() + ";" +
                        r.getPrecio() + ";" +
                        r.getStock() + "\n"
                );
            }
            archivo.close();

        } catch(Exception e){
            System.out.println(
                    "Error al guardar las prendas");
        }
    }
    
    public static void cargarPrendas() {

        try {

            BufferedReader lector =
                    new BufferedReader(new FileReader("D:\\Tecnicas de POO\\ProyectoFinal\\ProyectoTiendaRopa\\src\\TXTs\\prendas.txt"));

            String linea;

            while((linea = lector.readLine()) != null){

                String[] datos = linea.split(";");

                Ropa ropa = new Ropa();

                ropa.agregar(
                        datos[0], // codigo
                        datos[1], // nombre
                        datos[2], // talla
                        datos[3], // categoria
                        datos[4], // color
                        Double.parseDouble(datos[5]),
                        Integer.parseInt(datos[6])
                );

                listaRopa.add(ropa);
            }

            lector.close();

        } catch(Exception e){

            System.out.println("No existe archivo o está vacío.");
        }
    }

    // Guarda los cinco atributos de todos los accesorios en un archivo TXT.
    public static void guardarTodosLosAccesorios() {

        try {
            // Ruta relativa al proyecto de NetBeans, evita usar rutas de otra PC.
            File archivoAccesorios = new File("src/TXTs/accesorios.txt");
            File carpeta = archivoAccesorios.getParentFile();

            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            FileWriter archivo = new FileWriter(archivoAccesorios);

            for (Accesorio a : listaAccesorios) {
                archivo.write(
                        a.getCodigo() + ";" +
                        a.getNombre() + ";" +
                        a.getColor() + ";" +
                        a.getPrecio() + ";" +
                        a.getStock() + "\n"
                );
            }

            archivo.close();

        } catch (Exception e) {
            System.out.println("Error al guardar los accesorios: " + e.getMessage());
        }
    }

    // Recupera los accesorios guardados cuando se inicia el programa.
    public static void cargarAccesorios() {
        accesoriosCargados = true;

        File archivoAccesorios = new File("src/TXTs/accesorios.txt");

        if (!archivoAccesorios.exists()) {
            return; // La primera vez todavia no existe el TXT.
        }

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoAccesorios));
            String linea;

            listaAccesorios.clear();

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";", -1);

                if (datos.length == 5) {
                    try {
                        Accesorio accesorio = new Accesorio();

                        if (accesorio.agregar(
                                datos[0], // codigo
                                datos[1], // nombre
                                datos[2], // color
                                Double.parseDouble(datos[3]),
                                Integer.parseInt(datos[4]))) {

                            listaAccesorios.add(accesorio);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Registro de accesorio no valido: " + linea);
                    }
                }
            }

            lector.close();

        } catch (Exception e) {
            System.out.println("Error al cargar los accesorios: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        //ArrayList que almacena todas las prendas registradas
        //ArrayList<Ropa> listaRopa = new ArrayList<>();

        // ArrayList que almacena los clientes registrados
        ArrayList<Cliente> listaClientes = new ArrayList<>();

        // ArrayList que almacena los accesorios registrados.
        // La lista de accesorios esta declarada al inicio de Principal.

        //Para que cargue primero el txt
        cargarPrendas();
        cargarAccesorios();
        
        //Inicializamos el Menu
        Menu menu = new Menu();
        menu.setVisible(true);
        
        //Inicializamos el formulario Registrar Prenda
        RegistrarPrenda formRegistrarPrenda = new RegistrarPrenda();
        
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
            System.out.println("\n=== MODULO ACCESORIOS ===");
            System.out.println("13. Registrar accesorio");
            System.out.println("14. Modificar nombre y color de accesorio");
            System.out.println("15. Eliminar accesorio");
            System.out.println("16. Buscar accesorio por codigo");
            System.out.println("17. Buscar accesorio por nombre");
            System.out.println("18. Consultar stock de accesorio");
            System.out.println("19. Listar accesorios registrados");
            System.out.println("20. Salir");
            
            System.out.println("------------------");
            System.out.print("Ingrese opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

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
                    if (!eliminado) {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                }
                // RF13. Registrar accesorios.
                case 13: {
                    System.out.println("\n=== REGISTRAR ACCESORIO ===");
                    String respuesta;

                    do {
                        System.out.print("Codigo: ");
                        String codigo = teclado.nextLine();

                        boolean existe = false;

                        for (Accesorio a : listaAccesorios) {
                            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                                existe = true;
                                break;
                            }
                        }

                        if (codigo.trim().isEmpty()) {
                            System.out.println("Error: el codigo es obligatorio.");
                        } else if (existe) {
                            System.out.println("Error: el codigo ya existe.");
                        } else {
                            System.out.print("Nombre: ");
                            String nombre = teclado.nextLine();

                            System.out.print("Color: ");
                            String color = teclado.nextLine();

                            System.out.print("Precio: ");
                            double precio = teclado.nextDouble();

                            System.out.print("Stock: ");
                            int stock = teclado.nextInt();
                            teclado.nextLine();

                            Accesorio accesorio = new Accesorio();

                            // Utiliza el metodo agregar con cinco atributos.
                            if (accesorio.agregar(codigo, nombre, color, precio, stock)) {
                                listaAccesorios.add(accesorio);
                                guardarTodosLosAccesorios();
                                System.out.println("Accesorio registrado correctamente.");
                            } else {
                                System.out.println("Error: nombre y color obligatorios, "
                                        + "precio mayor a cero y stock no negativo.");
                            }
                        }

                        System.out.print("¿Desea registrar otro accesorio? (S/N): ");
                        respuesta = teclado.nextLine();

                    } while (respuesta.equalsIgnoreCase("S"));

                    break;
                }

                // RF14. Modificar solamente nombre y color del accesorio.
                case 14: {
                    System.out.println("\n=== MODIFICAR ACCESORIO ===");
                    System.out.print("Codigo del accesorio: ");
                    String codigoMod = teclado.nextLine();
                    boolean encontrado = false;

                    for (Accesorio a : listaAccesorios) {
                        if (a.getCodigo().equalsIgnoreCase(codigoMod)) {
                            encontrado = true;

                            System.out.println("Nombre actual: " + a.getNombre());
                            System.out.println("Color actual: " + a.getColor());

                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = teclado.nextLine();

                            System.out.print("Nuevo color: ");
                            String nuevoColor = teclado.nextLine();

                            // Sobrecarga para modificar solo nombre y color.
                            // No modifica el codigo, precio ni stock.
                            if (a.agregar(nuevoNombre, nuevoColor)) {
                                guardarTodosLosAccesorios();
                                System.out.println("Accesorio modificado correctamente.");
                            } else {
                                System.out.println("Error: nombre y color son obligatorios.");
                            }
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Accesorio no encontrado.");
                    }
                    break;
                }

                // RF15. Eliminar accesorio por codigo.
                case 15: {
                    System.out.println("\n=== ELIMINAR ACCESORIO ===");
                    System.out.print("Codigo a eliminar: ");
                    String codigoEliminar = teclado.nextLine();
                    boolean eliminado = false;

                    for (int i = 0; i < listaAccesorios.size(); i++) {
                        if (listaAccesorios.get(i).eliminar(codigoEliminar)) {
                            listaAccesorios.remove(i);
                            guardarTodosLosAccesorios();
                            eliminado = true;
                            System.out.println("Accesorio eliminado correctamente.");
                            break;
                        }
                    }

                    if (!eliminado) {
                        System.out.println("Accesorio no encontrado.");
                    }
                    break;
                }

                // RF16. Buscar accesorio por codigo.
                case 16: {
                    System.out.println("\n=== BUSCAR ACCESORIO POR CODIGO ===");
                    System.out.print("Ingrese codigo: ");
                    String codigoBuscado = teclado.nextLine();
                    boolean encontrado = false;

                    for (Accesorio a : listaAccesorios) {
                        if (a.getCodigo().equalsIgnoreCase(codigoBuscado)) {
                            System.out.println("-------------------");
                            encontrado = a.buscar(codigoBuscado);
                            break;
                        }
                    }

                    if (!encontrado) {
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

                    // Busca por nombre utilizando la sobrecarga con stock minimo.
                    for (Accesorio a : listaAccesorios) {
                        if (a.buscar(nombreBuscado, 0) >= 0) {
                            System.out.println("-------------------");
                            a.mostrar();
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Accesorio no encontrado.");
                    }
                    break;
                }

                // RF18. Consultar stock del accesorio por codigo.
                case 18: {
                    System.out.println("\n=== CONSULTAR STOCK DE ACCESORIO ===");
                    System.out.print("Ingrese codigo: ");
                    String codigoStock = teclado.nextLine();
                    boolean encontrado = false;

                    for (Accesorio a : listaAccesorios) {
                        if (a.getCodigo().equalsIgnoreCase(codigoStock)) {
                            System.out.println("Stock disponible: " + a.getStock());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Accesorio no encontrado.");
                    }
                    break;
                }

                // RF19. Listar accesorios registrados.
                case 19: {
                    System.out.println("\n=== LISTAR ACCESORIOS ===");

                    if (listaAccesorios.isEmpty()) {
                        System.out.println("No hay accesorios registrados.");
                    } else {
                        for (Accesorio a : listaAccesorios) {
                            System.out.println("-------------------");
                            a.mostrar();
                        }
                    }
                    break;
                }

                // RF20. Salir del programa.
                case 20: {
                    System.out.println("Hasta luego.");
                    break;
                }
            }
        }while(opcion != 20);
                      
        teclado.close();
        
    }
}
