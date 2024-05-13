package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private String tipo;
    private int velocidadMaxima;

    public Moto(String placa, String modelo, String propietario, String tipo, int velocidadMaxima) {
        super(placa, modelo, propietario);
        this.tipo = tipo;
        this.velocidadMaxima = velocidadMaxima;
    }

    @Override
    public double calcularCosto(int horas) {
        double tarifa = tipo.equals("clasica") ? 2000 : 1600;
        return horas > 0 ? horas * tarifa : tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
}
