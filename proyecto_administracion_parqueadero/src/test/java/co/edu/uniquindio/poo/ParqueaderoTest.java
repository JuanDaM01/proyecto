package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.logging.Logger;

/*
 * Metodo a Probar                          | Entrada                       | Salida Esperada
 * -----------------------------------------|-------------------------------|--------------------------------------------------
 * TestAgregarCarroAlParqueadero()          | Carro con placa unica         | Carro agregado al parqueadero
 * TestAgregarMotoAlParqueadero()           | Moto con placa unica          | Moto agregada al parqueadero
 * TestAgregarCarroRepetido()               | Dos carros con misma placa    | Excepcion lanzada
 * TestAgregarMotoRepetida()                | Dos motos con misma placa     | Excepcion lanzada
 * testObtenerPropietarioCarro()            | Carro en el parqueadero       | Propietario del carro es obtenido correctamente
 * testObtenerPropietarioMoto()             | Moto en el parqueadero        | Propietario de la moto es obtenido correctamente
 */

public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void TestAgregarCarroAlParqueadero() {
        LOG.info("Iniciando TestAgregarCarroAlParqueadero");

        // Crear instancia de Parqueadero y asegurar inicialización de la coleccion de
        // carros
        Parqueadero parqueadero = new Parqueadero(1, 1);
        parqueadero.setCarros(new LinkedList<>());
        Carro carro = new Carro("QWE456", "Mazda 3", "Juan");

        // Agregar el carro al parqueadero
        parqueadero.agregarCarroAlParqueadero(carro);

        // Verifica que el carro esta presente en la coleccion de carros
        assertTrue(parqueadero.getCarros().contains(carro));

        LOG.info("Finalizando TestAgregarCarroAlParqueadero");
    }

    @Test
    public void TestAgregarMotoAlParqueadero() {
        LOG.info("Iniciando TestAgregarMotoAlParqueadero");

        // Crear instancia de Parqueadero y asegurar inicializacion de la coleccion de
        // motos
        Parqueadero parqueadero = new Parqueadero(1, 2);
        parqueadero.setMotos(new LinkedList<>());
        Moto moto = new Moto("ABC15G", "Pulsar 200", "Roberto", "clasica", 150);

        // Agregar la moto al parqueadero
        parqueadero.agregarMotoAlParqueadero(moto);

        // Verifica que la moto esta presente en la coleccion de motos
        assertTrue(parqueadero.getMotos().contains(moto));

        LOG.info("Finalizando TestAgregarMotoAlParqueadero");
    }

    @Test
    public void TestAgregarCarroRepetido() {
        LOG.info("Iniciando TestAgregarCarroRepetido");

        // Crear instancia de Parqueadero y asegurar inicializacion de la coleccion de
        // carros
        Parqueadero parqueadero = new Parqueadero(1, 1);
        parqueadero.setCarros(new LinkedList<>());
        Carro carro1 = new Carro("QWE456", "Mazda 3", "Juan");
        Carro carro2 = new Carro("QWE456", "Chevrolet Onix", "Alan");

        // Agregar el primer carro al parqueadero
        parqueadero.agregarCarroAlParqueadero(carro1);

        // Verifica que se lanza una excepcion al intentar agregar el segundo carro con
        // la misma placa
        assertThrows(Throwable.class, () -> parqueadero.agregarCarroAlParqueadero(carro2));

        LOG.info("Finalizando TestAgregarCarroRepetido");
    }

    @Test
    public void TestAgregarMotoRepetida() {
        LOG.info("Iniciando TestAgregarMotoRepetida");

        // Crear instancia de Parqueadero y asegurar inicializacion de la coleccion de
        // motos
        Parqueadero parqueadero = new Parqueadero(1, 2);
        parqueadero.setMotos(new LinkedList<>());
        Moto moto1 = new Moto("ABC15G", "Pulsar 200", "Roberto", "clasica", 150);
        Moto moto2 = new Moto("ABC15G", "Dominar 400", "Ryan", "clasica", 180);

        // Agregar la primera moto al parqueadero
        parqueadero.agregarMotoAlParqueadero(moto1);

        // Verifica que se lanza una excepcion al intentar agregar la segunda moto con
        // la misma placa
        assertThrows(Throwable.class, () -> parqueadero.agregarMotoAlParqueadero(moto2));

        LOG.info("Finalizando TestAgregarMotoRepetida");
    }

    @Test
    public void testObtenerPropietarioCarro() {
        LOG.info("Iniciando testObtenerPropietarioCarro");

        // Crear instancia de Parqueadero y agregar un carro
        Parqueadero parqueadero = new Parqueadero(1, 1);
        parqueadero.setCarros(new LinkedList<>());
        Carro carro = new Carro("QWE456", "Mazda 3", "Juan");
        parqueadero.agregarCarroAlParqueadero(carro);

        // Verifica que el nombre del propietario obtenido sea "Juan"
        assertEquals("Juan", carro.getPropietario());

        LOG.info("Finalizando testObtenerPropietarioCarro");
    }

    @Test
    public void testObtenerPropietarioMoto() {
        LOG.info("Iniciando testObtenerPropietarioMoto");

        // Crear instancia de Parqueadero y agregar una moto
        Parqueadero parqueadero = new Parqueadero(1, 2);
        parqueadero.setMotos(new LinkedList<>());
        Moto moto = new Moto("ABC15G", "Pulsar 200", "Roberto", "clasica", 150);
        parqueadero.agregarMotoAlParqueadero(moto);

        // Verifica que el nombre del propietario obtenido sea "Roberto"
        assertEquals("Roberto", moto.getPropietario());

        LOG.info("Finalizando testObtenerPropietarioMoto");
    }
}