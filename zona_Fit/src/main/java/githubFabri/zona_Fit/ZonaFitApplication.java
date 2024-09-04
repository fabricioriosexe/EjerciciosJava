package githubFabri.zona_Fit;

import java.util.List;
import java.util.Scanner;

import githubFabri.zona_Fit.modelo.Cliente;
import githubFabri.zona_Fit.servicio.ClienteServicio;
import githubFabri.zona_Fit.servicio.IClienteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {
//?inyectamos una dependecia

    @Autowired
    private IClienteServicio clienteservicio;

    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

    String nl = System.lineSeparator();

    public static void main(String[] args) {
        //levanta la fabrica de spring
        logger.info("\niniciando la aplicacion\n");
        SpringApplication.run(ZonaFitApplication.class, args);
        logger.info("finalizada");
    }

    @Override
    public void run(String... args) throws Exception {
        zonaFitAPP();
    }

    private void zonaFitAPP() {
        logger.info(nl + "***Aplicacion Zona Fit (GYM)***" + nl);
        var salida = false;
        var consola = new Scanner(System.in);
        while (!salida) {
            try {
                var opcion = mostrarMenu(consola);
                salida = ejecutarOpciones(consola, opcion);
            } catch (Exception e) {
                System.out.println("**ERROR AL EJERCUTAR OPCIONES**" + e.getMessage());
            }
            System.out.println();
        }
    }

    private static int mostrarMenu(Scanner consola) {
        System.out.print("""
                *** Zona Fit(GYM)***
                1.Listar Clientes
                2.Buscar Cliente
                3.Agregar Cliente
                4.Modificar Cliente
                5.Eliminar Cliente
                6.Salir
                Elija una opcion:\s""");

        return Integer.parseInt(consola.nextLine());
    }

    private boolean ejecutarOpciones(Scanner consola, int opcion) {
        var salir = false;
        switch (opcion) {
            case 1 -> {
                logger.info(nl + "*** Listado de Clientes ***" + nl);
                List<Cliente> clientes = clienteservicio.listarCliente();
                clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
            }

            case 2 -> {
                logger.info(nl + "*** Buscar Cliente por ID***" + nl);
                logger.info("Id del Cliente a Buscar: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cl = clienteservicio.buscarClienteID(idCliente);
                if (cl != null) {
                    logger.info(nl + "Cliente Encontrado: " + cl + nl);
                }
            }

            case 3 -> {
                logger.info(nl + "*** Agregar Cliente****" + nl);
                logger.info("Nombre: ");
                var nombre = consola.nextLine();
                logger.info("Apellido: ");
                var apellido = consola.nextLine();
                logger.info("Membresia: ");
                var membresia = consola.nextLine();
                var cliente = new Cliente();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setMembresia(membresia);
                clienteservicio.guardarCliente(cliente);
                logger.info("Cliente Agregado" + cliente + nl);
            }

            case 4 -> {
                logger.info(nl + "*** Modificar Cliente****" + nl);
                logger.info("Id cliente: ");
                var idCliente = Integer.parseInt(consola.nextLine());
                Cliente cliente = clienteservicio.buscarClienteID(idCliente);
                if (cliente != null) {
                    logger.info("Nombre: ");
                    var nombre = consola.nextLine();
                    logger.info("Apellido: ");
                    var apellido = consola.nextLine();
                    logger.info("Membresia: ");
                    var membresia = consola.nextLine();
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setMembresia(membresia);
                    clienteservicio.guardarCliente(cliente);
                    logger.info("Cliente Modificado" + cliente + nl);
                } else {
                    logger.info("Cliente No Encontrado" + nl);
                }
            }

            case 5 -> {
                logger.info("***Eliminar Cliente***");
                logger.info("id Cliente");
                var idCliente = Integer.parseInt(consola.nextLine());
                var cliente = clienteservicio.buscarClienteID(idCliente);
                if (cliente != null) {
                    clienteservicio.eliminarCliente(cliente);
                    logger.info("cliente eliminado: " + cliente + nl);
                } else {
                    logger.info("Cliente No Eliminado" + cliente + nl);
                }

            }

            case 6 -> {
                System.out.println("""
                    ***MUCHAS GRACIAS***
                    ***SALIENDO DEL SISTEMA***
                        """);
                return true;
            }
            default -> {
                return true;
            }
        }
        return salir;
    }
}
