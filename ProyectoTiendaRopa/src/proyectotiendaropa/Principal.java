package proyectotiendaropa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

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

        //Para que cargue primero el txt
        cargarPrendas();
        cargarAccesorios();
        
        //Inicializamos el Menu
        Menu menu = new Menu();
        menu.setVisible(true);
        
       
    }
}