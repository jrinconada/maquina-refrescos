
import java.util.ArrayList;
import java.util.List;

/**
 * Inventario representa los refrescos disponibles en la máquina
 */
public class Inventario {
    private final List<Refresco> refrescos; // Refrescos disponibles
    
    /**
     * Se crea un inventario con algunos refrescos de ejemplo
     */
    public Inventario(){
        refrescos = new ArrayList<>();
        // Cuatro refrescos de ejemplo con distintos precios y cantidades
        refrescos.add(new Refresco("CocaCola", 1, 4));
        refrescos.add(new Refresco("Fanta", 1.5f, 2));
        refrescos.add(new Refresco("RedBull", 2, 1));
        refrescos.add(new Refresco("Agua", 0.5f, 3));
    }
   
    /**
     * Quita de refresco del inventario
     * @param refresco El refresco a consumir
     * @return El refresco seleccionado, null si no se ha encontrado el refresco
     * o no hay existencias
     */
    public Refresco consumir(String refresco) {        
        for (int i = 0; i < refrescos.size(); i++) {
            if(refrescos.get(i).nombre.equalsIgnoreCase(refresco)) {
                if(refrescos.get(i).cantidad > 0) {
                    refrescos.get(i).cantidad--;
                    return refrescos.get(i);
                } else {
                    return null;
                }                
            }
        }
        return null;
    }
    
    /**
     * Muestra todos los refrescos del inventario
     */
    public void mostrar() {
        System.out.println("-- Inventario --");
        for(Refresco refresco : refrescos){
            System.out.println(refresco);
        }
        System.out.println("----------------");
    }
}
