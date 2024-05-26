package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

/**
 * La clase Puesto representa un puesto de estacionamiento en el parqueadero
 * Cada puesto tiene coordenadas (i, j), un estado de ocupacion, un vehiculo
 * asignado y una hora de inicio de ocupacion
 */
public class Puesto {
    private int i, j; // Coordenadas del puesto en la matriz del parqueadero
    private boolean ocupado; // Indica si el puesto esta ocupado
    private Vehiculo vehiculo; // Vehiculo asignado al puesto
    private LocalDateTime horaInicio; // Hora de inicio de la ocupacion del puesto

    /**
     * Inicializa un puesto de estacionamiento con sus coordenadas
     */
    public Puesto(int i, int j) {
        this.i = i;
        this.j = j;
        this.ocupado = false;
        this.vehiculo = null;
        this.horaInicio = null;
    }

    /**
     * Verifica si el puesto esta ocupado
     * true si el puesto esta ocupado, false en caso contrario
     */
    public boolean estaOcupado() {
        return ocupado;
    }

    /**
     * Este metodo asigna el vehiculo al puesto, marca el puesto como ocupado y
     * establece la hora de inicio de la ocupacion
     */
    public void ocuparPuesto(Vehiculo vehiculo) {
        this.vehiculo = vehiculo; // El vehiculo que ocupara el puesto
        this.ocupado = true;
        this.horaInicio = LocalDateTime.now();
    }

    /**
     * Este metodo elimina el vehiculo asignado, marca el puesto como desocupado y
     * reinicia la hora de inicio de la ocupacion
     */
    public void desocuparPuesto() {
        this.vehiculo = null;
        this.ocupado = false;
        this.horaInicio = null;
    }

    /**
     * Obtiene el vehiculo asignado al puesto
     */
    public Vehiculo obtenerVehiculo() {
        return vehiculo;
    }

    /**
     * Obtiene la hora de inicio de la ocupacion del puesto
     */
    public LocalDateTime obtenerHoraInicio() {
        return horaInicio;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }
}
