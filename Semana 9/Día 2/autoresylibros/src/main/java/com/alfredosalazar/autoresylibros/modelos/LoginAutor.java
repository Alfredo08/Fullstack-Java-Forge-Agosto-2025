package com.alfredosalazar.autoresylibros.modelos;

import jakarta.validation.constraints.Email;

public class LoginAutor {
    @Email(message="Por favor proporciona un correo válido.")
    private String correo;

    private String contrasenia;

    public LoginAutor(){}

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
}
