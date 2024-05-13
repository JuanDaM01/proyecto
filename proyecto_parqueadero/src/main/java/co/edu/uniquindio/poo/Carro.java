package co.edu.uniquindio.poo;

public class Carro extends Vehiculo {
    public Carro(String placa, String modelo, String propietario) {
        super(placa, modelo, propietario);
    }

    @Override
    public double calcularCosto(int horas) {
        double tarifa = 3000;
        return horas > 0 ? horas * tarifa : tarifa;
    }
}
