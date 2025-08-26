import java.util.ArrayList;

public class Arreglos{
    public static void main(String args []){
        String [] nombres = new String[5];
        String [] apellidos = {"Sánchez", "Gómez", "Torres", "Méndez", "Santos"};

        nombres[0] = "Alex";
        nombres[1] = "Martha";
        nombres[2] = "Roger";
        nombres[3] = "Julieta";
        nombres[4] = "Roberto";
        
        System.out.println(nombres[0]);
        System.out.println(apellidos[0]);

        ArrayList<String> nombresCompletos = new ArrayList<String>();
        nombresCompletos.add("Alex Miller");
        nombresCompletos.add("Martha Gómez");
        nombresCompletos.add("Julieta Vargas");

        System.out.println(nombresCompletos.size());
        System.out.println(nombresCompletos.get(1));

        nombresCompletos.remove(0);
        System.out.println(nombresCompletos.size());
        System.out.println(nombresCompletos.get(0));

    }
}