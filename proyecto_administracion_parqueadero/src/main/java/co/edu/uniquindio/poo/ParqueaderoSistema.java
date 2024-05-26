package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * La clase ParqueaderoSistema gestiona el sistema de parqueadero permitiendo
 * registrar vehiculos
 * verifica disponibilidad de puestos, calcular costos, desocupar puestos y
 * generar reportes de ingresos
 */

public class ParqueaderoSistema {
    private static Scanner scanner = new Scanner(System.in);
    private static Parqueadero parqueadero = new Parqueadero(3, 3);

    public static void main(String[] args) {
        int opcion = 0;

        while (opcion != 8) {
            mostrarMenu();
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige la opcion que desea realizar:"));

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
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        JOptionPane.showMessageDialog(null,
                "              Menu del Parqueadero       \n" +
                        "\n1. Registrar un vehiculo en un puesto" +
                        "\n2. Comprobar si un puesto esta libre" +
                        "\n3. Mostrar el propietario de un vehiculo en un puesto" +
                        "\n4. Costo de estacionamiento" +
                        "\n5. Reporte mensual de ingresos" +
                        "\n6. Reporte diario de ingresos" +
                        "\n7. Desocupar un puesto" +
                        "\n8. Salir del sistema");
    }

    /**
     * Registra un vehiculo en un puesto del parqueadero
     */
    private static void registrarVehiculo() {
        // Solicita al usuario ingresar la fila y columna del puesto
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la fila del puesto (0 a 2):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la columna del puesto (0 a 2):"));
        // Solicita al usuario ingresar los detalles del vehiculo y su propietario
        String tipo = JOptionPane.showInputDialog("Tipo de vehiculo (carro o moto):");
        String placa = JOptionPane.showInputDialog("Placa del vehiculo:");
        String modelo = JOptionPane.showInputDialog("Modelo del vehiculo:");
        String propietario = JOptionPane.showInputDialog("Nombre del propietario:");

        Vehiculo vehiculo = null;
        if (tipo.equalsIgnoreCase("moto")) {
            // Si el vehiculo es una moto, pedir detalles adicionales
            String tipoMoto = JOptionPane.showInputDialog("Tipo de moto (clasica o hibrida):");
            int velocidadMaxima = Integer.parseInt(JOptionPane.showInputDialog("Velocidad máxima de la moto:"));
            vehiculo = new Moto(placa, modelo, propietario, tipoMoto, velocidadMaxima);
        } else if (tipo.equalsIgnoreCase("carro")) {
            // Si el vehiculo es un carro, crear un objeto Carro
            vehiculo = new Carro(placa, modelo, propietario);
        }
        // Asigna el vehiculo al puesto si es posible
        if (vehiculo != null && parqueadero.asignarVehiculoAPuesto(fila, columna, vehiculo)) {
            JOptionPane.showMessageDialog(null, "El vehiculo ha sido registrado con exito");
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se pudo registrar el vehiculo, verifica la disponibilidad del puesto");
        }
    }

    /**
     * Verifica la disponibilidad de un puesto en el parqueadero
     */
    private static void verificarDisponibilidad() {
        // Solicita al usuario ingresar la fila y columna del puesto
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la fila del puesto (0 a 2):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la columna del puesto (0 a 2):"));
        // Verifica si el puesto esta disponible
        if (parqueadero.estaDisponible(fila, columna)) {
            JOptionPane.showMessageDialog(null, "El puesto esta libre");
        } else {
            JOptionPane.showMessageDialog(null, "El puesto esta ocupado");
        }
    }

    /**
     * Obtiene el propietario de un vehiculo en un puesto especifico
     */
    private static void obtenerPropietario() {
        // Solicita al usuario ingresar la fila y columna del puesto
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la fila del puesto (0 a 2):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la columna del puesto (0 a 2):"));

        // Comprobar si el puesto esta ocupado
        if (!parqueadero.estaDisponible(fila, columna)) {
            // Obtener el vehiculo en el puesto y mostrar el propietario
            Vehiculo vehiculo = parqueadero.getPuestos()[fila][columna].obtenerVehiculo();
            JOptionPane.showMessageDialog(null, "El propietario del vehiculo es: " + vehiculo.getPropietario());
        } else {
            JOptionPane.showMessageDialog(null, "El puesto esta vacio");
        }
    }

    /**
     * Calcula el costo del estacionamiento en un puesto especifico
     */
    private static void calcularCostos() {
        // Se pide la fila y columna del puesto
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la fila del puesto (0 a 2):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la columna del puesto (0 a 2):"));

        // Calcular el costo del estacionamiento
        double costo = parqueadero.calcularCosto(fila, columna);
        if (costo > 0) {
            JOptionPane.showMessageDialog(null, "Costo del estacionamiento: " + costo);
        } else {
            JOptionPane.showMessageDialog(null,
                    "El puesto esta vacio o el vehiculo no ha sido registrado correctamente");
        }
    }

    /**
     * Desocupa un puesto en el parqueadero y muestra el costo del estacionamiento
     */
    private static void desocuparPuesto() {
        // Se pide la fila y columna del puesto
        int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la fila del puesto (0 a 2):"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la columna del puesto (0 a 2):"));

        // Desocupar el puesto y mostrar el costo del estacionamiento
        double costo = parqueadero.desocuparPuesto(fila, columna);
        if (costo > 0) {
            JOptionPane.showMessageDialog(null, "Vehiculo retirado, el costo del estacionamiento es: " + costo);
        } else {
            JOptionPane.showMessageDialog(null, "El puesto ya estaba vacio o no se ha podido calcular el costo");
        }
    }

    /**
     * Imprime el reporte diario de ingresos del parqueadero
     */
    private static void imprimirReporteDiario() {
        parqueadero.imprimirReporteDiario();
    }

    /**
     * Imprime el reporte mensual de ingresos del parqueadero
     */
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
