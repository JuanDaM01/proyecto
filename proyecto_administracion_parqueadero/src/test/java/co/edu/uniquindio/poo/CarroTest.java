package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/*
 * Metodo a Probar                       | Entrada                       | Salida Esperada
 * --------------------------------------|-------------------------------|----------------------------------------------------
 * TestCarroDatosCompletos()             | Carro con datos completos     | Los datos del carro son correctamente obtenidos
 * TestCarroDatosNulos()                 | Carro con datos nulos         | Se lanza una excepcion al pasar datos nulos
 * TestCarroDatosVacios()                | Carro con datos vacios        | Se lanza una excepcion al pasar datos vacios
 * TestCalcularCostoParqueaderoCarro()   | Carro y tiempo estacionado    | El costo calculado es igual al costo esperado
 */

public class CarroTest {
    private static final Logger LOG = Logger.getLogger(CarroTest.class.getName());

    @Test
    public void TestCarroDatosCompletos() {
        LOG.info("Iniciando TestCarroDatosCompletos");

        // Crear instancia de Carro con datos completos
        Carro carro = new Carro("QWE456", "Mazda 3", "Juan");

        // Verifica que los datos del carro son los esperados
        assertEquals("QWE456", carro.getPlaca());
        assertEquals("Mazda 3", carro.getModelo());
        assertEquals("Juan", carro.getPropietario());

        LOG.info("Finalizando TestCarroDatosCompletos");
    }

    @Test
    public void TestCarroDatosNulos() {
        LOG.info("Inicio TestCarroDatosNulos");

        // Verifica que se lanza una excepcion al pasar datos nulos
        assertThrows(Throwable.class, () -> new Carro(null, null, null));

        LOG.info("Finalización TestCarroDatosNulos");
    }

    @Test
    public void TestCarroDatosVacios() {
        LOG.info("Inicio TestCarroDatosVacios");

        // Verifica que se lanza una excepcion al pasar datos vacios
        assertThrows(Throwable.class, () -> new Carro("", "", ""));

        LOG.info("Finalización TestCarroDatosVacios");
    }

    @Test
    void TestCalcularCostoParqueaderoCarro() {
        LOG.info("Iniciando TestCalcularCostoParqueaderoCarro");

        // Crear carro
        Carro carro = new Carro("QWE456", "Mazda 3", "Juan");

        // Crear una instancia de parqueadero
        Parqueadero parqueadero = new Parqueadero(1, 1);

        // Ocupar el puesto con el carro (asumiendo que ocuparPuesto registra la
        // entrada)
        Puesto puesto = parqueadero.getPuestos()[0][0]; // [0][0] se usa para acceder a un elemento especifico dentro de
                                                        // la matriz
        puesto.ocuparPuesto(carro);

        // Simular el tiempo estacionado (asumimos 2 horas)
        int horasEstacionado = 2;

        // Calcular el costo
        double costoCalculado = carro.calcularCosto(horasEstacionado);

        // Verificar el costo esperado
        double costoEsperado = 6000.0; // 2 horas * 3000 por hora
        assertEquals(costoEsperado, costoCalculado);

        LOG.info("Finalizando TestCalcularCostoParqueaderoCarro");
    }
}
