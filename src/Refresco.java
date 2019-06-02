
/**
 * Representa un refresco en la máquina con su nombre, precio y existencias
 */
public class Refresco {
    public final String nombre;
    public final float precio;
    public int cantidad;
    
    /**
     * Crea un refresco
     * @param nombre El nombre del refresco
     * @param precio El precio del refresco
     * @param cantidad Las existencias del tipo de refresco
     */
    Refresco(String nombre, float precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Devuelve la información del refresco en formato String
     * @return Un String con el nombre, precio y existencias del refresco
     */
    @Override
    public String toString(){
      return nombre + " vale " + precio + " hay " + cantidad;
    }
}
