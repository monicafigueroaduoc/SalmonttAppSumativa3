package org.example.model;
/**
 * Clase {@code CentroCultivo} representa un Centro de cultivo de salmones
 * en el sistema {@code SalmonttAppSumativa3}.
 * <p>
 *  Hereda de {@link UnidadOperativa} y agrega la información relacionada
 *  con la producción anual en toneladas.
 *  Implementa {@link #mostrarResumen()} con el formato del proyecto.
 * </p>
 *
 *  @author Monica Figueroa
 *  @version 1.0
 */
public class CentroCultivo extends UnidadOperativa implements Registrable {
    /** Producción anual en toneladas. */
    private double produccionAnualToneladas;

    /**
     * Constructor de la clase CentroCultivo.
     *
     * @param nombre Nombre del centro.
     * @param comuna Comuna donde se ubica el centro.
     * @param produccionAnualToneladas Produccion anual en toneladas.
     */
    public CentroCultivo(String nombre, String comuna, double produccionAnualToneladas) {

        // Llamada al constructor de la superclase para inicializar nombre y comuna.
        super(nombre, comuna);
        this.produccionAnualToneladas = produccionAnualToneladas;
    }

    /**
     * Retorna la producción anual en toneladas.
     * @return producción anual (tons).
     */
    public double getProduccionAnualToneladas() {
        return produccionAnualToneladas;
    }

    /**
     * Retorna un resumen con la información del Centro de Cultivo.
     * @return resumen del Centro de Cultivo.
     */
    @Override
    public String mostrarResumen() {
        return "=== RESUMEN CENTRO DE CULTIVO ===\n" + "Nombre: " + getNombre() +
                " | Comuna: " + getComuna() +
                " | Produccion anual: "
                + produccionAnualToneladas + " t/anio\n";

    }
}
