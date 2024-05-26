package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

/*
 * Metodo a Probar                          | Entrada                       | Salida Esperada
 * -----------------------------------------|-------------------------------|------------------------------------------------
 * TestPuestoOcupado()                      | Carro con placa unica         | Puesto ocupado despues de añadir carro
 * TestOcuparPuesto()                       | Carro con placa unica         | Puesto ocupado, carro asignado al puesto
 * TestDesocuparPuesto()                    | Carro en puesto               | Puesto desocupado, vehiculo en puesto es nulo
 */

public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    @Test
    public void testPuestoOcupado() {
        LOG.info("Iniciando testPuestoOcupado");

        // Crear un puesto vacio en la posicion [1, 1]
        Puesto puesto = new Puesto(1, 1);
        // Verificar que el puesto vacio no este ocupado
        assertFalse(puesto.estaOcupado());

        // Crear un propietario
        Propietario propietario = new Propietario("Juan");
        // Crear un carro con el propietario
        Carro carro = new Carro("QWE456", "Mazda 3", propietario.getNombre());

        // Ocupar el puesto con el carro
        puesto.ocuparPuesto(carro);

        // Verificar que el puesto ahora este ocupado
        assertTrue(puesto.estaOcupado());

        LOG.info("Finalizando testPuestoOcupado");
    }

    @Test
    public void testOcuparPuesto() {
        LOG.info("Iniciando testOcuparPuesto");

        // Crear un puesto vacio en la posicion [1, 1]
        Puesto puesto = new Puesto(1, 1);
        assertFalse(puesto.estaOcupado());

        Propietario propietario = new Propietario("Juan");
        Carro carro = new Carro("QWE456", "Mazda 3", propietario.getNombre());
        // Ocupar el puesto con el carro
        puesto.ocuparPuesto(carro);
        // Verificar que el puesto este ocupado despues de ocuparlo con el carro
        assertTrue(puesto.estaOcupado());
        // Verificar que el vehiculo en el puesto sea el carro que se uso para ocupar el
        // puesto
        assertEquals(carro, puesto.getVehiculo());

        LOG.info("Finalizando testOcuparPuesto");
    }

    @Test
    public void testDesocuparPuesto() {
        LOG.info("Iniciando testDesocuparPuesto");

        // Crear un propietario y un carro
        Propietario propietario = new Propietario("Juan");
        Carro carro = new Carro("QWE456", "Mazda 3", propietario.getNombre());

        // Crear un puesto y ocuparlo con el carro
        Puesto puesto = new Puesto(0, 0);
        puesto.ocuparPuesto(carro);

        // Verificar que el puesto este ocupado
        assertTrue(puesto.estaOcupado());

        // Desocupar el puesto
        puesto.desocuparPuesto();

        // Verificar que el puesto no este ocupado despues de liberarlo
        assertFalse(puesto.estaOcupado());

        // Verificar que el vehiculo en el puesto sea nulo despues de desocuparlo
        assertEquals(null, puesto.getVehiculo());

        LOG.info("Finalizando testDesocuparPuesto");
    }
}
