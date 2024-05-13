package co.edu.uniquindio.poo;

import java.util.Scanner;

public class ParqueaderoSistema {
    private static Scanner scanner = new Scanner(System.in);
    private static Parqueadero parqueadero = new Parqueadero(3, 3);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 8) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    verificarDisponibilidad();
                    break;
                case 3:
                    obtenerPropietario();
                    break;
                case 4:
                    calcularCostos();
                    break;
                case 5:
                    imprimirReporteMensual();
                    break;
                case 6:
                    imprimirReporteDiario();
                    break;
                case 7:
                    desocuparPuesto();
                    break;
                case 8:
                    System.out.println("Salir");
                    break;
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n---- Menu del Parqueadero ----");
        System.out.println("\n1. Registrar un vehiculo en un puesto");
        System.out.println("2. Comprobar si un puesto esta libre");
        System.out.println("3. Mostrar el propietario de un vehiculo en un puesto");
        System.out.println("4. Costo de estacionamiento");
        System.out.println("5. Reporte mensual de ingresos");
        System.out.println("6. Reporte diario de ingresos");
        System.out.println("7. Desocupar un puesto");
        System.out.println("8. Salir del sistema");
        System.out.print("\nElige la opción que desea realizar: ");
    }

    private static void registrarVehiculo() {
        System.out.print("\nIngresa la fila del puesto (0 a 2): ");
        int fila = scanner.nextInt();
        System.out.print("Ingresa la columna del puesto (0 a 2): ");
        int columna = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tipo de vehiculo (carro o moto): ");
        String tipo = scanner.nextLine();
        System.out.print("Placa del vehiculo: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo del vehiculo: ");
        String modelo = scanner.nextLine();
        System.out.print("Nombre del propietario: ");
        String propietario = scanner.nextLine();

        Vehiculo vehiculo = null;
        if (tipo.equalsIgnoreCase("moto")) {
            System.out.print("Tipo de moto (clasica o hibrida): ");
            String tipoMoto = scanner.nextLine();
            System.out.print("Velocidad máxima de la moto: ");
            int velocidadMaxima = scanner.nextInt();
            vehiculo = new Moto(placa, modelo, propietario, tipoMoto, velocidadMaxima);
        } else if (tipo.equalsIgnoreCase("carro")) {
            vehiculo = new Carro(placa, modelo, propietario);
        }

        if (vehiculo != null && parqueadero.asignarVehiculoAPuesto(fila, columna, vehiculo)) {
            System.out.println("\nEl vehiculo ha sido registrado con exito.");
        } else {
            System.out.println("\nNo se pudo registrar el vehiculo, verifica la disponibilidad del puesto.");
        }
    }

    private static void verificarDisponibilidad() {
        System.out.print("\nIngresa la fila del puesto (0 a 2): ");
        int fila = scanner.nextInt();
        System.out.print("Ingresa la columna del puesto (0 a 2): ");
        int columna = scanner.nextInt();

        if (parqueadero.estaDisponible(fila, columna)) {
            System.out.println("\nEl puesto esta libre.");
        } else {
            System.out.println("\nEl puesto esta ocupado.");
        }
    }

    private static void obtenerPropietario() {
        System.out.print("\nIngresa la fila del puesto (0 a 2): ");
        int fila = scanner.nextInt();
        System.out.print("Ingresa la columna del puesto (0 a 2): ");
        int columna = scanner.nextInt();

        if (!parqueadero.estaDisponible(fila, columna)) {
            Vehiculo vehiculo = parqueadero.getPuestos()[fila][columna].obtenerVehiculo();
            System.out.println("\nEl propietario del vehiculo es: " + vehiculo.getPropietario());
        } else {
            System.out.println("\nEl puesto esta vacio.");
        }
    }

    private static void calcularCostos() {
        System.out.print("\nIngresa la fila del puesto (0 a 2): ");
        int fila = scanner.nextInt();
        System.out.print("Ingresa la columna del puesto (0 a 2): ");
        int columna = scanner.nextInt();

        double costo = parqueadero.calcularCosto(fila, columna);
        if (costo > 0) {
            System.out.println("\nCosto del estacionamiento: " + costo);
        } else {
            System.out.println("\nEl puesto esta vacio o el vehiculo no ha sido registrado correctamente.");
        }
    }

    private static void desocuparPuesto() {
        System.out.print("\nIngresa la fila del puesto (0 a 2): ");
        int fila = scanner.nextInt();
        System.out.print("Ingresa la columna del puesto (0 a 2): ");
        int columna = scanner.nextInt();

        double costo = parqueadero.desocuparPuesto(fila, columna);
        if (costo > 0) {
            System.out.println("\nVehiculo retirado, el costo del estacionamiento es: " + costo);
        } else {
            System.out.println("\nEl puesto ya estaba vacio o no se ha podido calcular el costo.");
        }
    }

    private static void imprimirReporteDiario() {
        parqueadero.imprimirReporteDiario();
    }

    private static void imprimirReporteMensual() {
        parqueadero.imprimirReporteMensual();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Parqueadero getParqueadero() {
        return parqueadero;
    }
}
