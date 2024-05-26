package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/*
 * Metodo a Probar                          | Entrada                       | Salida Esperada
 * -----------------------------------------|-------------------------------|----------------------------------------------------
 * TestNombrePropietarioCompleto()          | Nombre de propietario completo| Nombre del propietario es igual al nombre completo
 * TestNombrePropietarioNulo()              | Nombre de propietario nulo    | Se lanza una excepción al pasar nombre nulo
 * TestNombrePropietarioVacio()             | Nombre de propietario vacío   | Se lanza una excepción al pasar nombre vacío
 */

public class PropietarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void TestNombrePropietarioCompleto() {
        LOG.info("Iniciando TestNombrePropietarioCompleto");

        // Crear propietario con nombre completo
        Propietario propietario = new Propietario("Sebastian Amaya");

        // Verifica que el nombre del propietario es el esperado
        assertEquals("Sebastian Amaya", propietario.getNombre());

        LOG.info("Finalizando TestNombrePropietarioCompleto");
    }

    @Test
    public void TestNombrePropietarioNulo() {
        LOG.info("Iniciando TestNombrePropietarioNulo");

        // Verifica que se lanza una excepcion al pasar nombre nulo
        assertThrows(Throwable.class, () -> new Propietario(null));

        LOG.info("Finalizando TestNombrePropietarioNulo");
    }

    @Test
    public void TestNombrePropietarioVacio() {
        LOG.info("Iniciando TestNombrePropietarioVacio");

        // Verifica que se lanza una excepcion al pasar nombre vacio
        assertThrows(Throwable.class, () -> new Propietario(""));

        LOG.info("Finalizando TestNombrePropietarioVacio");
    }
}
