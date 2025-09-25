package com.alfredosalazar.autoresylibros.repositorios;

import org.springframework.stereotype.Repository;

import com.alfredosalazar.autoresylibros.modelos.Autor;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface RepositorioAutores extends CrudRepository<Autor, Long> {
    List<Autor> findAll();

    Autor save(Autor nuevoAutor);

    Autor findByCorreo(String correo);
}
