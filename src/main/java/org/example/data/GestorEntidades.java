package org.example.data;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestor que administra la colección genérica de entidades del sistema.
 * <p>
 * Proporciona métodos para añadir entidades, recuperar la lista y
 * mostrar detalles en consola (uso de instanceof para la lógica diferenciada).
 * </p>
 * @author Monica Figueroa
 * @version 1.0
 */
public class GestorEntidades {
    /**
     * Lista genérica que almacena objetos que implementan
     * {@link Registrable}
     * <p> Se declara como {@code final} para asegurar que
     * la referencia a la lista no sea reasignada, manteniendo
     * un único contenedor de datos durante la ejecución del
     * programa.
     * </p>
     * Aunque la referencia es final, el contendio de la lista
     * puede modificarse libremente.
     *
     * @return lista de entidades operativas.
     */
    private final List<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
        cargarEntidades();
    }

    /**
     * Método privado que carga ejemplos de entidades en
     * la colección.
     * <p> Útil para que al iniciar la aplicación haya datos
     * con los que probar la GUI.</p>
     */
    private void cargarEntidades() {

    // Instanciación de centros de cultivo utilizando polimorfismo.
    entidades.add(new CentroCultivo("Centro AquaChile",
            "Quellon", 200000.0));
    entidades.add(new CentroCultivo("Centro Salmones Austral",
            "Calbuco", 60000.0));
    entidades.add(new CentroCultivo("Centro Blumar",
            "Puerto Montt", 85000.0));

    // Instanciación de  plantas de proceso utilizando la misma referencia padre.
    entidades.add(new PlantaProceso("Planta Camanchaca",
            "Calbuco", 140000.0));
    entidades.add(new PlantaProceso("Planta AquaChile",
            "Quellón", 110000.0));

    // Instanciación de proveedores
    entidades.add(new Proveedor("NetCare Chile", "Calbuco",
            "Lavado industrial y reparacion de redes"));
    entidades.add(new Proveedor("AquaLab Diagnosticos acuicolas",
"Puerto Varas", "Laboratorio veterinario/analisis sanitarios"));
}

    /**
     * Agrega una engtidad a la lista.
      * @param entidad entidad que implementa Registrable.
     */
public void agregarEntidad(Registrable entidad) {
    // Se agrega la entidad a la colección sin importar su tipo concreto.
        entidades.add(entidad);
    }

    /**
     * Retorna la lista completa de entidades registradas.
     * @return lista de entidades.
     */
    public List<Registrable> getEntidades() {
        return entidades;
    }

    /** Recorre la lista de entidades e identifica su tipo
     * utilizando instance of.
     * <p> Este método se incluye para demostrar el uso de
     * instance of sobre una colección polimórfica.
     * </p>
     */
    public void mostrarEntidadesDetalladas() {
        System.out.println("===RESUMEN GENERAL DE ENTIDADES===\n");
        // Se recorre la lista usando un ciclo for-each.
        for (Registrable entidad : entidades) {
            // Se ejecuta el metodo mostrarInformacion() según el tipo real del objeto.
            System.out.println(entidad.mostrarResumen()); //Poliforfismo.

            if (entidad instanceof CentroCultivo) {
                System.out.println("Este es un Centro de Cultivo");
            }
            else if (entidad instanceof PlantaProceso) {
                System.out.println("Esta es una Planta de Proceso");
            }
            else if (entidad instanceof Proveedor) {
                System.out.println("Este es un Proveedor");
            }
        }
    }

    /* Método que devuelve un String con todos los resumenes. */
    public String obtenerResumenEntidades() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ENTIDADES REGISTRADAS ===\n\n");
        for (Registrable r : entidades) {
            sb.append(r.mostrarResumen()).append("\n");
        }
        return sb.toString();
    }
}
