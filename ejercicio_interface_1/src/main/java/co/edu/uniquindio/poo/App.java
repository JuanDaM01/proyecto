package co.edu.uniquindio.poo;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("Juan", "Perez", "16412345", "juanPerezabc");
        JOptionPane.showMessageDialog(null, cliente);

        Empleado empleado = new Empleado("Pedro", "Rios", "44568541", 2000000);
        JOptionPane.showMessageDialog(null, empleado);
    }
}
