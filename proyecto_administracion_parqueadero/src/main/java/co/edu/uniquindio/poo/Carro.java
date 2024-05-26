package co.edu.uniquindio.poo;

/**
 * La clase Carro representa un vehiculo tipo carro que se puede estacionar en
 * un parqueadero
 * Extiende la clase Vehiculo y añade validaciones específicas para las
 * propiedades de un carro
 */

public class Carro extends Vehiculo {
    public Carro(String placa, String modelo, String propietario) {
        super(placa, modelo, propietario);
        if (placa == null || placa.isBlank()) { // La placa del carro no debe ser nula ni vacia
            throw new IllegalArgumentException("Ingrese una placa valida");
        }
        if (modelo == null || modelo.isBlank()) { // El modelo del carro no debe ser nulo ni vacio
            throw new IllegalArgumentException("Ingrese un modelo valido");
        }
        if (propietario == null || propietario.isBlank()) { // El propietario del carro no debe ser nulo ni vacio
            throw new IllegalArgumentException("Ingrese un propietario valido");
        }
    } // IllegalArgumentException hace una excepcion si cualquiera de los parametros
      // es nulo o vacio

    /**
     * El metodo calcula el costo del estacionamiento del carro en función de las
     * horas que ha estado estacionado.
     * Si las horas son mayores a 0 el costo es horas multiplicado por la tarifa, de
     * lo contrario el costo es la tarifa básica
     */

    @Override
    public double calcularCosto(int horas) {
        double tarifa = 3000;
        return horas > 0 ? horas * tarifa : tarifa;
    }
}
