package org.example.model;
/**
 * Super clase abstracta que representa una unidad operativa
 * de la empresa Salmontt.
 * <p>
 * Contiene atributos comunes a todas las unidades como nombre y comuna.
 * Obliga a las subclases a implementar {@link #mostrarResumen()} que devuelve
 * un resumen formateado de la entidad.
 * La clase permanece {@code abstract} para evitar que sea instanciada directamente.
 * </p>
 * @author Monica Figueroa
 * @version 1.0
 */
public abstract class UnidadOperativa implements Registrable {

    /** Nombre de la unidad operativa*/
    private String nombre;

    /** Comuna donde se ubica la unidad operativa*/
    private String comuna;

    /**
     * Constructor base que analiza atributos comunes.
     * @param nombre Nombre de la unidad operativa.
     * @param comuna Comuna donde se ubica la unidad operativa.
     */
    public UnidadOperativa(String nombre, String comuna) {
        this.nombre = nombre;
        this.comuna = comuna;
    }

    /** @return nombre de la unidad operativa */
    public String getNombre() {
        return nombre;
    }

    /** @return comuna donde se ubica la unidad operativa */
    public String getComuna() {
        return comuna;
    }

    /**
     * Método que deben implementar las subclases para
     * devolver el resumen fotmateado con la información
     * específica de cada tipo de unidad.
     */
    public abstract String mostrarResumen();
}

