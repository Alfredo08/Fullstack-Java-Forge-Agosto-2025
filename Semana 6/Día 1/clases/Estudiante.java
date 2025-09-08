package clases;

public class Estudiante extends Persona{
    private String curso;
    private int matricula;

    public Estudiante(String nombre, String apellidoPaterno,
                      String apellidoMaterno, int edad, 
                      String curso, int matricula){
        super(nombre, apellidoPaterno, apellidoMaterno, edad);
        this.curso = curso;
        this.matricula = matricula;
    }

    public void imprimeInformacionEstudiante(){
        super.imprimeInformacion();
        System.out.println("Curso: " + this.curso);
        System.out.println("Matricula: " + this.matricula);
    }

    @Override
    public void imprimeInformacion(){
        super.imprimeInformacion();
        System.out.println("Curso: " + this.curso);
        System.out.println("Matricula: " + this.matricula);
    }
}
