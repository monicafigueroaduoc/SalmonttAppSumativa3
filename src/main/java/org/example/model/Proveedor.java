package org.example.model;

/**Clase {@code Proveedor} representa una planta de proceso de salmones
 * en el sistema {@code SalmonttAppSumativa3}.
 * <p>Implementa {@link Registrable} a través de {@link UnidadOperativa} y
 * añade el atributo {@code tipoProveedor} que describe el rubro
 * o servicio.
 * </p>
 * @author Monica Figueroa
 * @version 1.0
 */
public class Proveedor extends UnidadOperativa implements Registrable{
    /** Tipo o rubro del proveedor (Por ejemplo,
     * Lavado industrial, alimentos, transportes, etc.
     */
    private String tipoProveedor;

    /**
     * Constructor del proveedor.
     * @param nombre Nombre del proveedor.
     * @param comuna Comuna donde opera el proveedor.
     * @param tipoProveedor Tipo o rubro del proveedor.
     */
    public Proveedor(String nombre, String comuna, String tipoProveedor) {
        super(nombre, comuna);

        this.tipoProveedor = tipoProveedor;
    }

    /**
     * @return tipo de proveedor.
     */
    public String getTipoProveedor() {
        return tipoProveedor;
    }

    /**
     * @return resumen formateado del proveedor.
     */
    @Override
    public String mostrarResumen() {
        return "=== RESUMEN PROVEEDOR ===\n" + "Nombre: " + getNombre() +
                " | Comuna: " + getComuna() +
                " | Tipo de Proveedor: " + getTipoProveedor() + "\n";
    }
}
