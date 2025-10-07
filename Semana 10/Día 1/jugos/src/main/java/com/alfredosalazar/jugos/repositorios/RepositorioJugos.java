package com.alfredosalazar.jugos.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfredosalazar.jugos.modelos.Jugo;

@Repository
public interface RepositorioJugos extends CrudRepository<Jugo, Long>{
    Jugo save(Jugo nuevoJugo);
    List<Jugo> findAll();
}
