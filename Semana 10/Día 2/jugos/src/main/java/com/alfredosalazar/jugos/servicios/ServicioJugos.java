package com.alfredosalazar.jugos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfredosalazar.jugos.modelos.Jugo;
import com.alfredosalazar.jugos.repositorios.RepositorioJugos;

@Service
public class ServicioJugos {
    @Autowired
    private final RepositorioJugos repositorioJugos;

    public ServicioJugos(RepositorioJugos repositorioJugos){
        this.repositorioJugos = repositorioJugos;
    }

    public Jugo agregarUno(Jugo nuevoJugo){
        return this.repositorioJugos.save(nuevoJugo);
    }

    public List<Jugo> obtenerTodos(){
        return this.repositorioJugos.findAll();
    }

    public void eliminarUno(Long idJugo){
        this.repositorioJugos.deleteById(idJugo);
    }

    public Jugo obtenerUno(Long idJugo){
        return this.repositorioJugos.findById(idJugo).orElse(null);
    }

    public Jugo actualizarUno(Jugo jugo){
        return this.repositorioJugos.save(jugo);
    }
}
