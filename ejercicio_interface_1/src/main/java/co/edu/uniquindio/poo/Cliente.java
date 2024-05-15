package co.edu.uniquindio.poo;

public class Cliente extends Persona implements ICliente{

    private String email;

    public Cliente(String nombre, String apellido, String cedula, String email) {
        super(nombre, apellido, cedula);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    @Override
    public String toString() {
        return "nombre=" + nombre + "\napellido=" + apellido + "\nemail=" + email + "\ncedula=" + cedula;
    }

    @Override
    public int calcularMaximoCompras() {
        return 0;
    }

    
}
