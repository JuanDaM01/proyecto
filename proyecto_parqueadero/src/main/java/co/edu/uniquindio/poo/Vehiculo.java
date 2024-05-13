package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    public String placa;
    public String modelo;
    public String propietario;

    public Vehiculo(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

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
}