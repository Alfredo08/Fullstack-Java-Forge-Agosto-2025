import clases.FuncionesAritmeticas;
import java.util.Date;

public class Aplicacion {
    public static void main(String args []){
        double num1 = 20.5;
        double num2 = 75.8;
        double resultado;

        resultado = FuncionesAritmeticas.sumaDosNumeros(num1, num2);
        System.out.println(resultado);
        resultado = FuncionesAritmeticas.restaDosNumeros(num1, num2);
        System.out.println(resultado);
        resultado = FuncionesAritmeticas.multiplicaDosNumeros(num1, num2);
        System.out.println(resultado);
        resultado = FuncionesAritmeticas.divideDosNumeros(num1, num2);
        System.out.println(resultado);

        Date fechaActual = new Date();
        System.out.println(fechaActual);
    }
}
