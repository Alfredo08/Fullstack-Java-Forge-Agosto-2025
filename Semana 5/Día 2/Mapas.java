import java.util.HashMap;
import java.util.Set;

public class Mapas {
    public static void main(String args []){
        HashMap<String, Integer> edadesDePersonas = new HashMap<String, Integer>();

        edadesDePersonas.put("Juan", 25);
        edadesDePersonas.put("Alan", 28);
        edadesDePersonas.put("Ana", 23);
        edadesDePersonas.put("Julieta", 30);

        edadesDePersonas.put("Ana", 38);

        System.out.println("Ana : " + edadesDePersonas.get("Ana"));
        System.out.println(edadesDePersonas.size());
        
        Set<String> propiedades = edadesDePersonas.keySet();
        for(String clave : propiedades){
            System.out.println(clave + " - " + edadesDePersonas.get(clave));
        }
    }
}
