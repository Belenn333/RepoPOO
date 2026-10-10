package proyectotiendaropa;

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
    
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    
    
    public static ArrayList<Venta> listaVentas = new ArrayList<>();

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

    // Presenta los datos en consola utilizando los getters de Ropa.
    // Compatible con la clase Ropa que usan los formularios de NetBeans.
    private static void mostrarPrendaEnConsola(Ropa r) {
        System.out.println("Codigo: " + r.getCodigo());
        System.out.println("Nombre: " + r.getNombre());
        System.out.println("Talla: " + r.getTalla());
        System.out.println("Categoria: " + r.getCategoria());
        System.out.println("Color: " + r.getColor());
        System.out.println("Precio: " + r.getPrecio());
        System.out.println("Stock: " + r.getStock());
    }
      

    public static void main(String[] args) {

        //ArrayList que almacena todas las prendas registradas
        ArrayList<Ropa> listaRopa = new ArrayList<>();

        // ArrayList que almacena los clientes registrados
        

        //ArrayList que almacena los accesorios registrados
        ArrayList<Accesorio> listaAccesorios = new ArrayList<Accesorio>();
        
        //ArrayList que almacena las ventas registradas
        ArrayList<Venta> listaVentas = new ArrayList<>();

        //Permite ingresar datos
        Scanner teclado = new Scanner(System.in);

        // ArrayList que almacena los accesorios registrados.
        // La lista compartida de accesorios se declara al inicio de Principal.
        // Lista de ventas conservada del modulo de main.
        //ArrayList<Venta> listaVentas = new ArrayList<>();

        //Para que cargue primero el txt
        cargarPrendas();
        cargarAccesorios();
        
        //Inicializamos el Menu
        Menu menu = new Menu();
        menu.setVisible(true);
        
        //Permite ingresar datos
        //Scanner teclado = new Scanner(System.in);

        int opcion;

        do {

            
            System.out.println("\n=== MODULO CLIENTES ===");
            System.out.println("8. Registrar cliente");
            System.out.println("9. Modificar cliente");
            System.out.println("10. Buscar cliente por codigo o nombre");
            System.out.println("11. Listar cliente");
            System.out.println("12. Elimininar cliente");
            
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
                
                
          
                
            }
        }while(opcion != 25);
                      
        teclado.close();
      
        }
}