package com.alfredosalazar.autoresylibros.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfredosalazar.autoresylibros.modelos.Libro;
import com.alfredosalazar.autoresylibros.repositorios.RepositorioLibros;

@Service
public class ServicioLibros {
    @Autowired
    private final RepositorioLibros repositorioLibros;

    public ServicioLibros(RepositorioLibros repositorioLibros){
        this.repositorioLibros = repositorioLibros;
    }

    public List<Libro> obtenerTodos(){
        return this.repositorioLibros.findAll();
    }

    public Libro agregar(Libro nuevoLibro){
        return this.repositorioLibros.save(nuevoLibro);
    }

    public Libro obtenerUno(Long idLibro){
        return this.repositorioLibros.findById(idLibro).orElse(null);
    }
}
