import java.util.ArrayList;

public class Ciclos {
    public static void main(String args []){
        ArrayList<String> nombresCompletos = new ArrayList<String>();
        nombresCompletos.add("Alex Miller");
        nombresCompletos.add("Martha Gómez");
        nombresCompletos.add("Julieta Vargas");

        for(int i = 1; i <= 3; i ++){
            System.out.println(i);
        }
        System.out.println("-----");
        int j = 1;
        while(j <= 3){
            System.out.println(j);
            j ++;
        }
        System.out.println("-----");
        for(int i = 0; i < nombresCompletos.size(); i ++){
            System.out.println(i + " - " + nombresCompletos.get(i));
        }
        System.out.println("-----");
        for(String nombre : nombresCompletos){
            System.out.println(nombre);
        }
    }
}
