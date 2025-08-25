public class VariablesYTiposDeDatos {
    public static void main(String args []){
        String nombre = "Alex";
        String apellidoMaterno;
        String apellidoPaterno = null;
        char inicial = 'A';
        Character inicialObjeto = 'A';
        Integer edadObjeto = 25;
        int edadEntera = 25;
        long edad = 25;
        double calificacion = 9.7;
        boolean certificado = false;

        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoPaterno);
        // System.out.println("Apellido materno: " + apellidoMaterno);
        System.out.println("Inicial: " + inicialObjeto);
        System.out.println("Edad: " + edad);
        System.out.println("Califación: " + calificacion);
        System.out.println("Certificado: " + certificado);

        System.out.println("Nombre tiene " + nombre.length() + " caracteres.");
    } 
}
