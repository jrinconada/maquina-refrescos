
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Simula una máquina de refrescos mediante la consola pidiendo el nombre del 
 * refresco a comprar y el dinero.
 * Controla las existencias de refrescos y se devuelve el cambio.
 */
public class MaquinaRefescos {

    // Entrada por consola
    private static final Scanner CONSOLA = new Scanner(System.in);
    
    /**
     * Se ejecuta al iniciar el programa imprimiendo por consola mensajes 
     * contextuales y llamando al pedirRefresco
     * @param args No se espera ningún argumento en este programa
     */
    public static void main(String[] args) {                               
        System.out.println("- Maquina de refrescos -");
        seleccionRefresco();
        System.out.println("- Gracias por utilizar la máquina de refrescos -");
    }
    
    /**
     * Muestra el inventario, procesa la interacción con usuario para comprar
     * un refresco, actualiza el inventario y llama a pedirDinero     
     */
    private static void seleccionRefresco() {
        Inventario inventario = new Inventario(); // Inventario de refrescos
        Cambio cambio = new Cambio(40, 4, 1); // Cambio disponible
        String entrada; // Texto introducido por el usuario
        
        inventario.mostrar();
        
        do {
            // Se obtiene el texto introducido por consola
            System.out.print("Refresco (o \"Salir\"): ");
            entrada = CONSOLA.next();
            // Se procesa el refresco introducido a menos que sea "Salir"
            if(!entrada.equalsIgnoreCase("Salir")) {
                Refresco refresco = inventario.consumir(entrada);
                // Si el refresco no es null existe y está disponible
                // Si es así ya se ha eliminado del inventario y se puede cobrar
                if(refresco != null) {
                    cobrar(refresco.precio, cambio);
                } else {
                    System.out.println("Refresco no disponible");
                }
            }           
        } while (!entrada.equalsIgnoreCase("Salir"));
    }
    
    /**
     * Con el precio del refresco y el cambio disponible procesa la interacción
     * con el usuario para obtener el dinero introducido e informa del resultado
     * del cálculo del cambio
     * @param precio Precio del refresco a comprar
     * @param cambio Cambio disponible y procesado de cálculo y muestra del 
     * cambio
     */
    private static void cobrar(float precio, Cambio cambio) {
        float dinero; // Dinero introducido por el usuario
        boolean pagado = false; // Será true cuando el refresco esté pagado
                
        do {
            // Se obtiene el precio introducido por consola
            System.out.println("Precio de refresco: " + precio);
            dinero = obtenerDinero();
            if (dinero >= precio) {
                float cambioCalculado = cambio.calcular(dinero, precio);
                if (cambioCalculado != -1) {
                    pagado = true;
                }
                cambio.mostrar();
            } else {
                System.out.println("Dinero insuficiente");
            }
        } while (!pagado);
    }
    
    /**
     * Valida que el dinero introducido esté en el formato correcto.
     * Numérico con la parte decimal separda por una coma
     * @return El dinero introducido
     */
    private static float obtenerDinero() {
        float dinero = 0; // Dinero introducido por el usuario
        boolean formatoCorrecto = false;
        
        do {
            try {
                System.out.print("Introduce el dinero: ");
                dinero = CONSOLA.nextFloat();
                formatoCorrecto = true;
            } catch (InputMismatchException excepcion) {
                CONSOLA.next();
                System.out.println("Formato incorrecto (ejemplo: 2,4)");
            }
            
        } while (!formatoCorrecto);
        
        return dinero;
    }
}