package co.edu.uniquindio.poo;

public class Empleado extends Persona{
    private double salario;

    public Empleado(String nombre, String apellido, String cedula, double salario) {
        super(nombre, apellido, cedula);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
    return "nombre=" + nombre + "\nsalario=" + salario + "\napellido=" + apellido + "\ncedula=" + cedula;
    }
    
}
