package co.edu.uniquindio.poo.interfaz_grafica_parqueadero;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Parqueadero {
    private Puesto[][] puestos;
    private Map<String, Double> ingresosDiarios = new HashMap<>();
    private Map<String, Double> ingresosMensuales = new HashMap<>();

    public Parqueadero(int filas, int columnas) {
        puestos = new Puesto[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    public boolean estaDisponible(int i, int j) {
        return !puestos[i][j].estaOcupado();
    }

    public boolean asignarVehiculoAPuesto(int i, int j, Vehiculo vehiculo) {
        if (estaDisponible(i, j)) {
            puestos[i][j].ocuparPuesto(vehiculo);
            return true;
        }
        return false;
    }

    public double desocuparPuesto(int i, int j) {
        if (!estaDisponible(i, j)) {
            double costo = calcularCosto(i, j);
            String tipoVehiculo = puestos[i][j].obtenerVehiculo().getClass().getSimpleName();
            ingresosDiarios.merge(tipoVehiculo, costo, Double::sum);
            String mesActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
            ingresosMensuales.merge(mesActual, costo, Double::sum);
            puestos[i][j].desocuparPuesto();
            return costo;
        }
        return 0;
    }

    public double calcularCosto(int i, int j) {
        if (!estaDisponible(i, j)) {
            LocalDateTime ahora = LocalDateTime.now();
            long horas = ChronoUnit.HOURS.between(puestos[i][j].obtenerHoraInicio(), ahora);
            if (horas == 0) {
                horas = 1;
            }
            double costo = puestos[i][j].obtenerVehiculo().calcularCosto((int) horas);
            return costo;
        }
        return 0;
    }

    public void imprimirReporteDiario() {
        if (ingresosDiarios.isEmpty()) {
            System.out.println("No se han registrado ingresos hoy.");
        } else {
            System.out.println("Reporte diario de Ingresos:");
            ingresosDiarios.forEach((tipo, ingreso) -> System.out.println(tipo + ": " + ingreso));
        }
    }

    public void imprimirReporteMensual() {
        if (ingresosMensuales.isEmpty()) {
            System.out.println("No se han registrado ingresos este mes.");
        } else {
            System.out.println("Reporte mensual de Ingresos:");
            ingresosMensuales.forEach((mes, ingreso) -> System.out.println(mes + ": " + ingreso));
        }
    }

    public Puesto[][] getPuestos() {
        return puestos;
    }

    public Map<String, Double> getIngresosDiarios() {
        return ingresosDiarios;
    }

    public Map<String, Double> getIngresosMensuales() {
        return ingresosMensuales;
    }
}
