package com.alura.conversor.principal;

import com.alura.conversor.conversion.ConsultaDivisa;
import com.alura.conversor.conversion.Divisas;
import java.util.Scanner;
public class Principal {
        public static void main(String[] args) {
                Scanner teclado = new Scanner(System.in);
                ConsultaDivisa consulta = new ConsultaDivisa();
                boolean calcular = false;
                String monedaBase = "", monedaCambio = "";
                double monto = 0;
                //Menu
                String menu = """
                        ****************************************
                        Bienvenido(a) al Conversor de Moneda  :D
                                        
                        1) Dólar -----------> Peso Argentino
                        2) Peso Argentino --> Dólar
                        3) Dólar -----------> Real Brasileño
                        4) Real Brasileño --> Dólar
                        5) Dólar -----------> Peso Colombiano
                        6) Peso Colombiano -> Dólar
                                       
                        0) ----- Salir ----------------------
                                        
                        Elija una opción del menú:
                        ****************************************""";
                System.out.println(menu);
                System.out.println("Escoja que tipo de cambio desea hacer");
                System.out.println(Divisas.class.toString());

                int opcion = teclado.nextInt();

                while (opcion != 9) {
                        if (opcion >= 1 && opcion <= 8) {
                                System.out.print("\nPor favor ingrese el Monto que desea cambiar: ");
                                monto = teclado.nextDouble();
                                calcular = true;
                                switch (opcion) {
                                        case 1:
                                                monedaBase = "USD";
                                                monedaCambio = "ARS";

                                                break;
                                        case 2:
                                                monedaBase = "ARS";
                                                monedaCambio = "USD";
                                                break;
                                        case 3:
                                                monedaBase = "USD";
                                                monedaCambio = "BLR";
                                                break;
                                        case 4:
                                                monedaBase = "BLR";
                                                monedaCambio = "USD";
                                                break;
                                        case 5:
                                                monedaBase = "USD";
                                                monedaCambio = "COP";
                                                break;
                                        case 6:
                                                monedaBase = "COP";
                                                monedaCambio = "USD";
                                                break;

                                        case 9:
                                                System.out.println("\n \nGracias por usar nuestro sistema...\n \n");
                                                calcular = false;
                                                break;
                                        default:
                                                System.out.println("\n \nLa opcion debe estar entre 1 y 6...\n \n");
                                                calcular = false;
                                }
                                if (calcular == true) {
                                        Divisas divisa = consulta.calculaDivisa(monedaBase, monedaCambio, monto);
                                        System.out.println("--------------------------------------------------------------------------------------------------------");
                                        System.out.println(divisa);
                                        System.out.println("--------------------------------------------------------------------------------------------------------");
                                        System.out.println("\n Presione <ENTER> para volver al menu \n");
                                        new Scanner(System.in).nextLine();
                                }
                        }
                }
        }
}
