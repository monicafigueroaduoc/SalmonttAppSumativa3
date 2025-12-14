package org.example.ui;
import javax.swing.SwingUtilities;

/**
 * Punto de entrada del sistema.
 * <p>
 * Inicia la aplicación gráfica.
 * </p>
 */
public class Main {
    /**
     * Método principal del programa.
     * @param args argumentos de línea de comando (no utilizados).
     * */
    public static void main(String[] args) {

        /**
         * {@code SwingUtilities.invokeLater()} se utiliza para que
         * la interfaz gráfica se cree y actualice de forma segura
         * en el hilo de de ejecución adecuado.
         * Es una forma de decirle a Java que ejecute el código
         * relacionado con la interfaz gráfica después que el sistema
         * haya terminado de hacer otras tareas. De esta manera se evita
         * que el sistema se congele o cause errores cuando se ejecuta.
         */
        SwingUtilities.invokeLater(() -> {
            // Se crea la ventana principal de la aplicación.
            RegistroGUI gui = new RegistroGUI();
            // Se hace visible la nterfaz.
            gui.setVisible(true);
        });
    }
}
