package clases;

public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int edad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
    }

    public Persona(){
        this.nombre = "N/A";
        this.apellidoMaterno = "N/A";
        this.apellidoPaterno = "N/A";
        this.edad = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void imprimeInformacion(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido paterno: " + this.apellidoPaterno);
        System.out.println("Apellido materno: " + this.apellidoMaterno);
        System.out.println("Edad: " + this.edad);
    }
    
}
