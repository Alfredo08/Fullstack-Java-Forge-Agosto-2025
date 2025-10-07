package com.alfredosalazar.usuarios.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfredosalazar.usuarios.modelos.Usuario;
import com.alfredosalazar.usuarios.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
    @Autowired
    private final RepositorioUsuarios repositorioUsuarios;

    public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios){
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public Usuario agregarUno(Usuario nuevoUsuario){
        return this.repositorioUsuarios.save(nuevoUsuario);
    }

    public Usuario obtenerUnoPorCorreoYContrasenia(String correo, String contrasenia){
        return this.repositorioUsuarios.findByCorreoAndContrasenia(correo, contrasenia);
    }
}
