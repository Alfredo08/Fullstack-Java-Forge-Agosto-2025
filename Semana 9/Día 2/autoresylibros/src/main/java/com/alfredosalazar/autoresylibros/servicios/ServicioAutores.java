package com.alfredosalazar.autoresylibros.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfredosalazar.autoresylibros.modelos.Autor;
import com.alfredosalazar.autoresylibros.repositorios.RepositorioAutores;


@Service
public class ServicioAutores {
    @Autowired
    private final RepositorioAutores repositorioAutores;

    public ServicioAutores(RepositorioAutores repositorioAutores){
        this.repositorioAutores = repositorioAutores;
    }

    public List<Autor> obtenerTodos(){
        return this.repositorioAutores.findAll();
    }

    public Autor obtenerUno(Long idAutor){
        return this.repositorioAutores.findById(idAutor).orElse(null);
    }

    public Autor obtenerUnoPorCorreoYContrasenia(String correo, String contrasenia){
        return this.repositorioAutores.findByCorreoAndContrasenia(correo, contrasenia);
    }

    public Autor agregarUno(Autor nuevoAutor){
        return this.repositorioAutores.save(nuevoAutor);
    }
}
