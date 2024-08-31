package com.githubfabriciorioss.zonafitsql.presentacion;

import java.util.Scanner;

import com.githubfabriciorioss.zonafitsql.Dominio.Cliente;
import com.githubfabriciorioss.zonafitsql.datos.ClienteDAO;
import com.githubfabriciorioss.zonafitsql.datos.iClienteDAO;

public class ZonaFitAPP {
    public static void main(String[] args) {
        zonaFitAPP();
    }
    
    private  static void zonaFitAPP(){
        var salida = false;
        var consola = new Scanner(System.in);

        //!Creamos un objeto de la clase clienteDAO
        
        iClienteDAO clientedao = new ClienteDAO();

        //* Creamos nuestro menu mientras la variable de salida no sea verdadera*/
        while (!salida) {
            try {
               var opcion = mostrarMenu(consola);
                salida = ejecutarOpciones(consola,opcion,clientedao);
            } catch (Exception e) {
               System.out.println("**ERROR AL EJERCUTAR OPCIONES**");
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola){
        System.out.print("""
                *** Zona Fit(GYM)
                1.Listar Clientes
                2.Buscar Cliente
                3.Agregar Cliente
                4.Modificar Cliente
                5.Eliminar Cliente
                6.Salir
                Elija una opcion:\s""");
        
        
                return Integer.parseInt(consola.nextLine());
    }

    private static boolean ejecutarOpciones(Scanner consola,int opcion, iClienteDAO clienteDAO){
        var salir = false;
        switch (opcion) {
            case 1 ->{//?-----1. LISTAR CLIENTES
                System.out.println("*** Listado de Clientes ***");
                var clientes = clienteDAO.listarCliente();
                clientes.forEach(System.out::println);
            }

            case 2 ->{//?-----2. BUSCAR CLIENTES POR ID
                    System.out.print("-Introduce el ID del Cliente a Buscar: ");
                    var idCliente = Integer.parseInt(consola.nextLine());
                    var cliente = new Cliente(idCliente);
                    var encontrado = clienteDAO.buscarClienteId(cliente);
                    if (encontrado) {
                        System.out.println("Cliente Encontrado: "+cliente);
                    }else{
                        System.out.println(" Cliente NO Enocontrado: "+cliente);
                    }
            }

            case 3 ->{//?-----3. Agregar Clientes
                    System.out.println("*** Agregar Cliente ***");
                    System.out.print("Nombre: ");
                    var nombre = consola.nextLine();
                    System.out.print("Apellido: ");
                    var apellido = consola.nextLine();
                    System.out.print("Membresia: ");
                    var membresia = consola.nextLine();

                    //!---------CREAMOS EL OBJETO CLIENTE SIN ID
                    var cliente = new Cliente(nombre,apellido,membresia);
                    var agregado = clienteDAO.agregarCliente(cliente);
                    if (agregado) {
                        System.out.println("Cliente Agregado: "+ cliente);
                    }else{
                        System.out.println("Cliente NO Agregado: "+cliente);
                    }
            }

            case 4 ->{//?---4. Modificar Cliente
                System.out.println("*** Modificar Cliente ***");
                System.out.print("ID Cliente: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Membresia: ");
                var membresia = consola.nextLine();
                var cliente = new Cliente(idCliente,nombre,apellido,membresia);
                var modicado = clienteDAO.modificarCliente(cliente);
                if (modicado) {
                    System.out.println("Cliente Modificado: "+ cliente);
                }else{
                    System.out.println("Cliente NO Modificado: "+cliente);
                }
            }

            case 5 ->{//?---5.Eliminar Cliente
                System.out.println("*** Eliminar Cliente***");
                System.out.print("ID Cliente:");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = new Cliente(idCliente);
                var eliminado = clienteDAO.eliminarCliente(cliente);
                if (eliminado) {
                    System.out.println("Cliente Eliminado: "+ cliente);
                }else{
                    System.out.println("Cliente NO Eliminado: "+ cliente);
                }
            }

            case 6->{
                System.out.println("""
                    ***MUCHAS GRACIAS***
                    ***SALIENDO DEL SISTEMA***
                        """);
               return true;
            }
        }
        return salir;
    }

}
