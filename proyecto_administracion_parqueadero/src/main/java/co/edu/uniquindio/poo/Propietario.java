package co.edu.uniquindio.poo;

/**
 * La clase Propietario representa al propietario de un vehiculo en el
 * parqueadero
 */
public class Propietario {
    private String nombre;

    public Propietario(String nombre) {
        this.nombre = nombre;
        assert nombre != null && !nombre.isBlank() : "Ingrese un nombre valido: "; // assert si el nombre es nulo o esta
                                                                                   // vacio

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}