package com.alfredosalazar.jugos.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfredosalazar.jugos.modelos.Usuario;
import com.alfredosalazar.jugos.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
    @Autowired
    private final RepositorioUsuarios repositorioUsuarios;

    public ServicioUsuarios(RepositorioUsuarios repositorioUsuarios){
        this.repositorioUsuarios = repositorioUsuarios;
    }

    public Usuario obtenerPorCorreo(String correo){
        return this.repositorioUsuarios.findByCorreo(correo);
    }

    public Usuario agregarUno(Usuario nuevoUsuario){
        String contraseniaEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasenia(), BCrypt.gensalt());
        nuevoUsuario.setContrasenia(contraseniaEncriptada);
        
        return this.repositorioUsuarios.save(nuevoUsuario); 
    }
}
