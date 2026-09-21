/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectotiendaropa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //ArrayList que almacena todas las prendas registradas
        ArrayList<Ropa> listaRopa = new ArrayList<>();
        
        //Solicita el código de la nueva prenda
        Scanner teclado = new Scanner(System.in);
        
        int opcion;

        do {

            System.out.println("\n=== MENU TIENDA DE ROPA ===");
            System.out.println("1. Registrar prenda");
            System.out.println("2. Mostrar prendas");
            System.out.println("3. Buscar por codigo");
            System.out.println("4. Buscar por nombre y color");
            System.out.println("5. Salir");

            System.out.print("Ingrese opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch(opcion){

                case 1: {

                    String respuesta;

                    do{       
                        //------------ VALIDACION DE AGREGAR------------------
                        // Solicita el código de la nueva prenda
                        System.out.print("Codigo: ");
                        String codigo = teclado.nextLine();
                        //Variable que permite verificar si el código de clase Ropa ya existe
                        boolean existe = false;

                        // Recorre el ArrayList para validar que el código sea único
                        for(Ropa r : listaRopa){

                            // Compara el código ingresado con los códigos ya registrados
                            if(r.getCodigo().equalsIgnoreCase(codigo)){

                                // Si encuentra coincidencia, marca el código como existente
                                existe = true;

                                // Finaliza el recorrido
                                break;
                            }
                        }

                        //Si el código no existe, se procede a registrar la prenda
                        if(!existe){

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
                            if(precio <= 0 && stock >= 0){
                            System.out.println("Error: el precio debe ser mayor a cero.");}
                            
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
                        }
                        //Validacion de codigo existente con mensaje de error
                        else{
                        System.out.println("Error: el codigo ya existe.");}
                        
                        System.out.print("¿Desea registrar otra prenda? (S/N): ");

                        respuesta = teclado.nextLine();

                    }while(respuesta.equalsIgnoreCase("S"));
                    break;
                }
            }
        }while(opcion != 5);

        teclado.close();
    }                     
}
