package org.example.model;

/**
 * Interfaz que define el comportamiento mínimo requerido
 * para que una entidad pueda ser registrada y mostrada en el sistema.
 * <p> Contiene un único método {@code mostrarResumen()} que devuelve
 * un {@code String} con la información formateada de la entidad.
 * </p>
 * @author Monica Figueroa
 * @version 1.0
 */
public interface Registrable {

    /**
     * Retorna un resumen de la entidad en formato texto.
     * @return resumen de la entidad.
     */
    public String mostrarResumen();
}
