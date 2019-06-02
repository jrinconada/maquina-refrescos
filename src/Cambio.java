
/**
 * Representa las monedas que tiene almacenadas la máquina
 */
public class Cambio {
    // Monedas disponibles
    private int de1; // Número de monedas de 1 céntimo
    private int de50; // Número de monedas de 50 céntimos
    private int de100; // Número de monedas de 1 euro
    private int cambio1; // Número de monedas de 1 céntimo para el cambio
    private int cambio50; // Número de monedas de 50 céntimos para el cambio
    private int cambio100; // Número de monedas de 1 euro para el cambio
    private int cambio; // Cambio como número decimal (redondeado a céntimos)
    
    /**
     * Inicializa las variables de cambio a 0 y usa los parámetros para indicar
     * el cambio disponible
     * @param de1 Número de monedas de 1 céntimo
     * @param de50 Número de monedas de 50 céntimos
     * @param de100 Número de monedas de 1 euro
     */
    Cambio(int de1, int de50, int de100){
        this.de1 = de1;
        this.de50 = de50;
        this.de100 = de100;
        cambio1 = 0;
        cambio50 = 0;
        cambio100 = 0;
        cambio = 0;
    }
    
    /**
     * 
     * A partir del precio y el dinero introducido calcula las monedas que se
     * dan de cambio
     * @param dinero Cantidad introducida para el pago en euros
     * @param precio Precio del producto en euros
     * @return El cambio o -1 si no hay cambio suficiente
     */
    public float calcular(float dinero, float precio) {
        // Cálculo del cambio en céntimos de euros      
        cambio = Math.round(100 * dinero) - Math.round(100 * precio);
        // Se inicializan las variables de cambio a cero
        cambio1 = 0;
        cambio50 = 0;
        cambio100 = 0;
        // Se guardan los valores iniciales para restaurarlos en caso de no 
        // haber cambio suficiente
        int de1Inicial = de1;
        int de50Inicial = de50;
        int de100Inicial = de100;
        
        // Mientras quede cambio por devolver y monedas en la máquina 
        // se va devolviendo cambio
        while(cambio > 0) {
            // Hay que devolver 1 euro o más y hay monedas de 1 euro
            if(cambio >= 100 && de100 > 0) {
                devolver100();
            // Hay que devolver 50 céntimos o más y hay monedas de 50 céntimos
            } else if(cambio >= 50 && de50 > 0) {
                devolver50();
            // Hay que devolver 1 céntimo o más y hay monedas de 1 céntimo
            } else if (de1 > 0){
                devolver1();
            // No hay monedas suficientes para devolver el cambio
            } else {
                cambio = -1;
            }
        }
        
        // Si no hay cambio suficiente no se devuelve nada por lo que se
        // restauran los valores iniciales
        if(cambio == -1) {
            de1 = de1Inicial;
            de50 = de50Inicial;
            de100 = de100Inicial;
            return -1;
        } else {
            return dinero - precio;
        }
    }
    
    /**
     * Resta el valor de 1 euro del cambio a devolver
     * Quita una moneda de 1 euro del cambio disponible
     * Suma una moneda de 1 euro al cambio que se va a devolver
     */
    private void devolver100() {
        cambio = cambio - 100;
        de100--;
        cambio100++;
    }
    
    /**
     * Resta el valor de 50 céntimos del cambio a devolver
     * Quita una moneda de 50 céntimos del cambio disponible
     * Suma una moneda de 50 céntimos al cambio que se va a devolver
     */
    private void devolver50() {
        cambio = cambio - 50;
        de50--;
        cambio50++;
    }
    
    /**
     * Resta el valor de 1 céntimo del cambio a devolver
     * Quita una moneda de 1 céntimo del cambio disponible
     * Suma una moneda de 1 céntimo al cambio que se va a devolver
     */
    private void devolver1() {        
        cambio = cambio - 1;
        de1--;
        cambio1++;
    }

    /**
     * Muestra por consola el resultado del cálculo del cambio
     */
    public void mostrar() {
        if (cambio == -1) {
            System.out.println("No hay cambio suficiente");
        } else {
            System.out.println("-- Cambio --");
            System.out.println("Monedas de 1 euro: " + cambio100);
            System.out.println("Monedas de 50 céntimos: " + cambio50);
            System.out.println("Monedas de 1 céntimo: " + cambio1);
            System.out.println("------------");
        }        
    }
}
