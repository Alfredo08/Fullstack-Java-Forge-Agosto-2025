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

    public void agregarUno(Jugo nuevoJugo){
        this.repositorioJugos.insertarJugo(nuevoJugo.getNombre(), nuevoJugo.getDescripcion(),
        nuevoJugo.getIngredientes(), nuevoJugo.getInstrucciones(), nuevoJugo.getImagen(), nuevoJugo.getUsuario().getId());
    }

    public List<Jugo> obtenerTodos(){
        return this.repositorioJugos.obtenerTodos();
    }

    public void eliminarUno(Long idJugo){
        this.repositorioJugos.eliminarJugo(idJugo);
    }

    public Jugo obtenerUno(Long idJugo){
        return this.repositorioJugos.findById(idJugo).orElse(null);
    }

    public Jugo actualizarUno(Jugo jugo){
        return this.repositorioJugos.save(jugo);
    }
}
