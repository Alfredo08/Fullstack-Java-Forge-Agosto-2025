import clases.Estudiante;
import clases.Persona;

public class Aplicacion {
    public static void main(String args []){
        Persona marco = new Persona("Marco", "Gómez", 
                                    "Sáncez", 25);
        Persona martha = new Persona();
        Estudiante alex = new Estudiante("Alex", "Miller", 
                                    "Robinson", 24, 
                                    "Java/Spring", 123456);
        martha.imprimeInformacion();
        System.out.println("-----");
        marco.imprimeInformacion();
        System.out.println("-----");
        alex.imprimeInformacionEstudiante();
    }
}
