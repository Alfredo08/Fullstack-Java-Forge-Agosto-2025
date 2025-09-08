import clases.Circulo;
import clases.Cuadrado;

public class Aplicacion {
    public static void main(String args []){
        Cuadrado cuadro1 = new Cuadrado(20.0);
        Cuadrado cuadro2 = new Cuadrado(7.5);
        Circulo circulo1 = new Circulo(9.0);
        Circulo circulo2 = new Circulo(2.5);

        cuadro1.imprimeInformacion();
        System.out.println("------");
        cuadro2.imprimeInformacion();
        System.out.println("------");
        circulo1.imprimeInformacion();
        System.out.println("------");
        circulo2.imprimeInformacion();
    }
}
