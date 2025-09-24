package com.alfredosalazar.autoresylibros.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfredosalazar.autoresylibros.modelos.Libro;

@Repository
public interface RepositorioLibros extends CrudRepository<Libro, Long>{
    /* 
     * SELECT * 
     * FROM libros;
     */
    List<Libro> findAll();

    /*
     * INSERT INTO libros()
     * VALUES();
     * 
     * UPDATE libros
     * SET libro
     * WHERE id = idLibro
     */
    Libro save(Libro nuevoLibro);

    /*
     * DELETE FROM libros
     * WHERE id = idLibro;
     */
    void deleteById(Long idLibro);
} 