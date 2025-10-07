package com.alfredosalazar.jugos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alfredosalazar.jugos.modelos.Jugo;

import jakarta.transaction.Transactional;

@Repository
public interface RepositorioJugos extends CrudRepository<Jugo, Long>{
    Jugo save(Jugo nuevoJugo);
    /* List<Jugo> findAll(); */
    @Query(value="SELECT * FROM jugos", nativeQuery=true)
    List<Jugo> obtenerTodos();

    @Transactional
    @Modifying
    @Query(value="INSERT INTO jugos(nombre, descripcion, ingredientes, instrucciones, imagen, id_usuario) " +
                 "VALUES(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery=true)
    void insertarJugo(String nombre, String descripcion, String ingredientes, 
                     String instrucciones, String imagen, Long idUsuario);

    @Transactional
    @Modifying
    @Query(value="DELETE FROM jugos WHERE id = ?1", nativeQuery=true)
    int eliminarJugo(Long idJugo);
}
