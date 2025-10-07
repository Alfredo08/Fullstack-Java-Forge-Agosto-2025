package com.alfredosalazar.usuarios.modelos;

import jakarta.validation.constraints.Email;

public class LoginUsuario {
    @Email(message="Por favor ingresa un correo válido.")
    private String correo;

    private String contrasenia;

    public LoginUsuario(){}

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