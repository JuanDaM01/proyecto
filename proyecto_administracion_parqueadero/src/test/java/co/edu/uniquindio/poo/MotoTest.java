package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/*
 * Metodo a Probar                       | Entrada                       | Salida Esperada
 * --------------------------------------|-------------------------------|----------------------------------------------------
 * TestMotoDatosCompletos()              | Moto con datos completos      | Los datos de la moto son correctamente obtenidos
 * TestMotoDatosNulos()                  | Moto con datos nulos          | Se lanza una excepcion al pasar datos nulos
 * TestMotoDatosVacios()                 | Moto con datos vacios         | Se lanza una excepcion al pasar datos vacios
 * TestMotoVelocidadMaximaNegativa()     | Moto con velocidad negativa   | Se lanza una excepcion al pasar velocidad negativa
 * TestCalcularCostoParqueaderoMoto()    | Moto y tiempo estacionado     | El costo calculado es igual al costo esperado
 */

public class MotoTest {
    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());

    @Test
    public void TestMotoDatosCompletos() {
        LOG.info("Iniciando TestMotoDatosCompletos");

        // Crear instancia de Moto con datos completos
        Moto moto = new Moto("ABC15G", "Pulsar 200", "Roberto", "clasica", 150);

        // Verifica que los datos de la moto son los esperados
        assertEquals("ABC15G", moto.getPlaca());
        assertEquals("Pulsar 200", moto.getModelo());
        assertEquals("Roberto", moto.getPropietario());
        assertEquals("clasica", moto.getTipo());
        assertEquals(150, moto.getVelocidadMaxima());

        LOG.info("Finalizando TestMotoDatosCompletos");
    }

    @Test
    public void TestMotoDatosNulos() {
        LOG.info("Iniciando TestMotoDatosNulos");

        // Verifica que se lanza una excepcion al pasar datos nulos
        assertThrows(Throwable.class, () -> new Moto(null, null, null, null, 150));

        LOG.info("Finalizando TestMotoDatosNulos");
    }

    @Test
    public void TestMotoDatosVacios() {
        LOG.info("Iniciando TestMotoDatosVacios");

        // Verifica que se lanza una excepción al pasar datos vacios
        assertThrows(Throwable.class, () -> new Moto("", "", "", "", 150));

        LOG.info("Finalizando TestMotoDatosVacios");
    }

    @Test
    public void TestMotoVelocidadMaximaNegativa() {
        LOG.info("Iniciando TestMotoVelocidadMaximaNegativa");

        // Verificar que se lanza una excepcion al pasar velocidad negativa
        assertThrows(Throwable.class, () -> new Moto("ABC15G", "Pulsar 200", "Roberto", "clasica", -150));

        LOG.info("Finalizando TestMotoVelocidadMaximaNegativa");
    }

    @Test
    void TestCalcularCostoParqueaderoMoto() {
        LOG.info("Iniciando TestCalcularCostoParqueaderoMoto");

        // Crear moto
        Moto moto = new Moto("ABC15G", "Pulsar 200", "Roberto", "clasica", 150);

        // Crear una instancia de parqueadero
        Parqueadero parqueadero = new Parqueadero(1, 1);

        // Ocupar el puesto con la moto
        Puesto puesto = parqueadero.getPuestos()[0][0]; // [0][0] se usa para acceder a un elemento especifico dentro de
                                                        // la matriz
        puesto.ocuparPuesto(moto);

        // Simular el tiempo estacionado (asumimos 2 horas)
        int horasEstacionado = 2;

        // Calcular el costo
        double costoCalculado = moto.calcularCosto(horasEstacionado);

        // Verificar el costo esperado
        double costoEsperado = 2 * 2000; // 2 horas * 2000 por hora para una moto clasica
        assertEquals(costoEsperado, costoCalculado);

        LOG.info("Finalizando TestCalcularCostoParqueaderoMoto");
    }
}
