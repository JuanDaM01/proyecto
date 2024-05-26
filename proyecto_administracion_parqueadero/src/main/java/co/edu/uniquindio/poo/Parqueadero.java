package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * La clase Parqueadero gestiona un conjunto de puestos de estacionamiento para
 * carros y motos y realiza operaciones relacionadas como asignar vehiculos a
 * puestos, calcular costos y generar reportes de ingresos
 */

public class Parqueadero {
    private Puesto[][] puestos; // Matriz de puestos del parqueadero
    private Map<String, Double> ingresosDiarios = new HashMap<>(); // Mapa de ingresos diarios del parqueadero
    private Map<String, Double> ingresosMensuales = new HashMap<>(); // Mapa de ingresos mensuales del parqueadero
    private Collection<Carro> carros; // Lista de carros
    private Collection<Moto> motos; // Lista de motos
    

    public Parqueadero(Puesto[][] puestos, Map<String, Double> ingresosDiarios, Map<String, Double> ingresosMensuales) {
        this.puestos = puestos;
        this.ingresosDiarios = ingresosDiarios;
        this.ingresosMensuales = ingresosMensuales;
        this.carros = new LinkedList<>();
        this.motos = new LinkedList<>();
    }

    // Agrega un carro al parqueadero

    public void agregarCarroAlParqueadero(Carro carro) {
        assert validarPlacaExista(carro.getPlaca()) == false; // El carro a agregar
        carros.add(carro);
    }

    // Verifica si una placa de carro ya existe en el parqueadero

    private boolean validarPlacaExista(String placa) {
        boolean exista = false;
        for (Carro carro : carros) { // La placa a verificar
            if (carro.getPlaca().equals(placa)) { // true si la placa ya existe, false en caso contrario
                exista = true;
            }
        }
        return exista;
    }

    // Agrega una moto al parqueadero

    public void agregarMotoAlParqueadero(Moto moto) {
        assert validarPlacaExiste(moto.getPlaca()) == false; // La moto a agregar
        motos.add(moto);
    }

    // Verifica si una placa de moto ya existe en el parqueadero

    private boolean validarPlacaExiste(String placa) {
        boolean exista = false;
        for (Moto moto : motos) { // La placa a verificar
            if (moto.getPlaca().equals(placa)) { // true si la placa ya existe, false en caso contrario
                exista = true;
            }
        }
        return exista;
    }

    /**
     * Se inicializa un Parqueadero con una cantidad especificada de filas y
     * columnas de puestos
     * Este constructor crea una matriz de objetos Puesto con las dimensiones
     * especificadas por los parametros
     * filas y columnas, cada elemento de la matriz se inicializa como un nuevo
     * objeto Puesto con sus respectivas
     * coordenadas (i, j)
     */

    public Parqueadero(int filas, int columnas) {
        puestos = new Puesto[filas][columnas];
        for (int i = 0; i < filas; i++) { // numero de filas de puestos
            for (int j = 0; j < columnas; j++) { // numero de columnas de puestos
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    // Verifica si un puesto esta disponible, i Fila del puesto y j Columna del
    // puesto

    public boolean estaDisponible(int i, int j) {
        return !puestos[i][j].estaOcupado(); // Operador terniario, true si el puesto esta disponible, false en caso
                                             // contrario
    }

    // Asigna un vehículo a un puesto especifico, i Fila del puesto y j Columna del
    // puesto

    public boolean asignarVehiculoAPuesto(int i, int j, Vehiculo vehiculo) {
        if (estaDisponible(i, j)) {
            puestos[i][j].ocuparPuesto(vehiculo); // true si el vehículo fue asignado exitosamente, false en caso
                                                  // contrario
            return true;
        }
        return false;
    }

    /**
     * Desocupa un puesto y calcula el costo del estacionamiento
     * Este metodo realiza los siguientes pasos:
     * 1. Verifica si el puesto esta ocupado
     * 2. Si el puesto esta ocupado:
     * a. Calcula el costo del estacionamiento utilizando el metodo calcularCosto
     * b. Obtiene el tipo de vehiculo estacionado en el puesto (Carro o Moto)
     * c. Actualiza los ingresos diarios sumando el costo calculado al ingreso
     * correspondiente al tipo de vehiculo
     * d. Obtiene el mes actual y actualiza los ingresos mensuales sumando el costo
     * calculado
     * e. Desocupa el puesto utilizando el metodo desocuparPuesto del objeto Puesto
     * f. Retorna el costo del estacionamiento
     * 3. Si el puesto ya estaba desocupado retorna 0
     */

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

    // Calcula el costo del estacionamiento en un puesto especifico
    /**
     * Si el puesto esta ocupado, Obtiene la hora actual y calcula el tiempo que el
     * vehiculo ha estado estacionado en horas
     * Si el tiempo es menor a una hora, lo ajusta a una hora minima, la base es 0
     * Calcula el costo del estacionamiento basado en el tiempo estacionado y la
     * tarifa del vehiculo y retorna el costo
     */
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

    /**
     * Verifica si el mapa de ingresos diarios esta vacio
     * Si el mapa de ingresos diarios esta vacio, imprime un mensaje indicando que
     * no se han registrado ingresos hoy
     * Si el mapa de ingresos diarios no esta vacio, imprime un encabezado para el
     * reporte diario de ingresos
     * Recorre cada entrada en el mapa de ingresos diarios e imprime el tipo de
     * vehiculo y el ingreso correspondiente
     */

    public void imprimirReporteDiario() {
        if (ingresosDiarios.isEmpty()) {
            System.out.println("No se han registrado ingresos hoy.");
        } else {
            System.out.println("Reporte diario de Ingresos:");
            ingresosDiarios.forEach((tipo, ingreso) -> System.out.println(tipo + ": " + ingreso));
        }
    }

    /**
     * Verifica si el mapa de ingresos mensuales esta vacio, si el mapa de ingresos
     * mensuales esta vacio, imprime un mensaje indicando que no se han registrado
     * ingresos este mes
     * Si el mapa de ingresos mensuales no esta vacio, imprime un encabezado para el
     * reporte mensual de ingresos y recorre cada entrada en el mapa de ingresos
     * mensuales e imprime el mes y el ingreso correspondiente
     */

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

    public Collection<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Collection<Carro> carros) {
        this.carros = carros;
    }

    public Collection<Moto> getMotos() {
        return motos;
    }

    public void setMotos(Collection<Moto> motos) {
        this.motos = motos;
    }
}
