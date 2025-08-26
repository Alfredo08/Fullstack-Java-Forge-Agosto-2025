public class MetodosEstaticos {
    public static void main(String args []){
        int num1 = 20;
        int num2 = 30;

        int resultado = sumaDosNumeros(num1, num2);
        System.out.println(resultado);
        resultado = sumaDosNumeros(60, 110);
        System.out.println(resultado);
        desplegarMensaje("Alex");
    }

    public static int sumaDosNumeros(int num1, int num2){
        int resultado = num1 + num2;
        return resultado;
    }

    public static void desplegarMensaje(String nombre){
        System.out.println("Hola " + nombre + ", ¿cómo estás?");
    }
}
