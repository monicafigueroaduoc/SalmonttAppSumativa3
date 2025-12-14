package org.example.model;
/**
 * Clase {@code PlantaProceso} representa una planta de proceso de salmones
 * en el sistema {@code SalmonttAppSumativa3}.
 * <p>
 * Hereda de {@link UnidadOperativa} y agrega la capacidad anual de procesamiento.
 * Implementa {@link #mostrarResumen()} con el formato del proyecto.
 * </p>
 * @author Monica Figueroa
 * @version 1.0
 */
public class PlantaProceso extends UnidadOperativa implements Registrable {

    /** Capacidad anual estimada en toneladas*/
    private double capacidadAnualToneladas;

    /**
     * Constructor de la planta de proceso.
     *
     * @param nombre Nombre de la planta.
     * @param comuna Comuna donde se ubica la planta.
     * @param capacidadAnualToneladas Capacidad de proceso anual
     * en toneladas.
     */
    public PlantaProceso(String nombre, String comuna, double capacidadAnualToneladas) {

        // Llamada al constructor de la superclase para inicializar nombre y comuna.
        super(nombre, comuna);
        this.capacidadAnualToneladas = capacidadAnualToneladas;
    }

    /**
     * Retorna la capacidad anual de la planta en toneladas.
     * @return capacidad anual (tons).
     */
    public double getCapacidadAnualToneladas() {
        return capacidadAnualToneladas;
    }

    /**
     * @return resumen formateado de la planta de proceso.
     */
    @Override
    public String mostrarResumen() {
        return "=== RESUMEN PLANTA DE PROCESO ===\n" + "Nombre: " + getNombre() +
                " | Comuna: " + getComuna() +
                " | Capacidad Anual: " + capacidadAnualToneladas + " t/anio\n";

    }
}
