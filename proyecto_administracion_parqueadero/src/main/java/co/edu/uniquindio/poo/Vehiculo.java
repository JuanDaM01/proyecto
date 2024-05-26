package co.edu.uniquindio.poo;

/**
 * La clase abstracta Vehiculo representa un vehiculo generico en el parqueadero
 * Cada vehiculo tiene una placa, un modelo y un propietario
 */
public abstract class Vehiculo {
    public String placa; // Placa del vehiculo
    public String modelo; // Modelo del vehiculo
    public String propietario; // Propietario del vehiculo

    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /**
     * Metodo abstracto para calcular el costo del estacionamiento
     * Este metodo debe ser implementado por las subclases de Vehiculo para definir
     * como se calcula el costo del estacionamiento en funcion del tipo de vehiculo
     */
    public abstract double calcularCosto(int horas);

    public String getPropietario() {
        return propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}