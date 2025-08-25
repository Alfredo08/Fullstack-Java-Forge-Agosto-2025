public class Condicionales {
    public static void main(String args []){
        /* 
          ()
          !
          * /
          + -
          > >= < <= == !=
          &&
          ||
          =
         */
        double calificacion = 10.0;
        if(calificacion >= 8.0){
            System.out.println("Aprobaste el examen.");
            if(calificacion == 10.0){
                System.out.println("Obtuviste la nota más alta posible.");
            }
        }
        else{
            System.out.println("No aprobaste, mucha suerte en tu siguiente intento");
        }

        String nombreA = new String("Alex Miller");
        String nombreB = new String("Alex Miller");

        boolean resultado = nombreA.equals(nombreB);

        System.out.println(nombreA + " " + nombreB + " = " + resultado);
    }
}
