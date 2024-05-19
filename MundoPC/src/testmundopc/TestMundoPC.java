package testmundopc;

import domain.*;
import java.util.*;

public class TestMundoPC {

    public static void main(String[] args) {
        int op = 1;
        int opComputadora = 0;
        double tamañoMonitor;
        String resolucionMonitor;
        Raton mouseComputadoraAuxiliar;
        Teclado tecladoComputadoraAuxiliar;
        Monitor monitoromputadoraAuxiliar;
        ArrayList<Raton> ratones = new ArrayList<Raton>();
        ArrayList<Teclado> teclados = new ArrayList<Teclado>();
        ArrayList<Computadoras> computadoras = new ArrayList<Computadoras>();
        ArrayList<Monitor> monitores = new ArrayList<Monitor>();
        Scanner entrada = new Scanner(System.in);
        String nombre;
        String marca;
        while (op != 0) {
            System.out.println("-------------------------");
            System.out.println("1.Agregar un raton");
            System.out.println("2.Agregar un Teclado");
            System.out.println("3.Agregar un Monitor");
            System.out.println("4.Agregar una Computadora");
            System.out.println("5.Crear una Nueva Orden");
            System.out.println("-------------------------");
            System.out.printf("Ingrese la opcion que desee: ");
            op = entrada.nextInt();
            switch (op) {
                case 1 -> {
                    entrada.nextLine();
                    System.out.printf("Ingresar tipo de entrada: ");
                    nombre = entrada.nextLine();
                    System.out.printf("Ingresar marca del raton: ");
                    marca = entrada.nextLine();
                    Raton raton = new Raton(nombre, marca);
                    ratones.add(raton);
                    for (int i = 0; i < ratones.size(); i++) {
                        System.out.println(ratones.get(i));
                    }

                }

                case 2 -> {
                    entrada.nextLine();
                    System.out.printf("Ingresar tipo de entrada: ");
                    nombre = entrada.nextLine();
                    System.out.printf("Ingresar marca del Teclado: ");
                    marca = entrada.nextLine();
                    Teclado teclado = new Teclado(nombre, marca);
                    teclados.add(teclado);
                    for (int i = 0; i < teclados.size(); i++) {
                        System.out.println(teclados.get(i));
                    }

                }
                case 3 -> {
                    entrada.nextLine();
                    System.out.printf("Ingresar marca del Monitor: ");
                    marca = entrada.nextLine();
                    System.out.printf("Ingresar tanaño del Monitor por cm: ");
                    tamañoMonitor = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.printf("Ingresar la resolucion");
                    resolucionMonitor = entrada.nextLine();
                    Monitor monitor = new Monitor(marca, tamañoMonitor, resolucionMonitor);
                    monitores.add(monitor);
                    for (int i = 0; i < monitores.size(); i++) {
                        System.out.println(monitores.get(i));
                    }

                }

                case 4 -> {
                    System.out.println("------COMPUTADORAS------");
                    for (int i = 0; i < ratones.size(); i++) {
                        System.out.println(ratones.get(i));
                    }

                    System.out.println("Ingrese el ID del mause que desea en la computadora");
                    opComputadora = entrada.nextInt();
                    mouseComputadoraAuxiliar = ratones.get(opComputadora);

                    System.out.println("----------------------");
                    for (int i = 0; i < teclados.size(); i++) {
                        System.out.println(teclados.get(i));
                    }
                    System.out.println("Ingrese el ID del Teclado que desea en la computadora");
                    opComputadora = entrada.nextInt();
                    tecladoComputadoraAuxiliar = teclados.get(opComputadora);
                     System.out.println("----------------------");
                       for (int i = 0; i < monitores.size(); i++) {
                        System.out.println(monitores.get(i));
                    }
                       opComputadora =0;
                       System.out.println("Ingrese el ID del Monitor que desea en la computadora");
                       opComputadora = entrada.nextInt();
                       monitoromputadoraAuxiliar = monitores.get(opComputadora);
                       
                       Computadoras computadora = new Computadoras(monitoromputadoraAuxiliar,mouseComputadoraAuxiliar,tecladoComputadoraAuxiliar);
                       computadoras.add(computadora);
                       for (int i = 0; i < computadoras.size(); i++) {
                           System.out.println(computadoras.get(i));
                    }
                }
            }
        }
    }
}
