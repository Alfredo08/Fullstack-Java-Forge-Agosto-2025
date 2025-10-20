package com.alfredosalazar.jugos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alfredosalazar.jugos.modelos.Jugo;
import com.alfredosalazar.jugos.modelos.Usuario;
import com.alfredosalazar.jugos.servicios.ServicioJugos;
import com.alfredosalazar.jugos.servicios.ServicioUsuarios;

@RestController // Agregar restcontroller
public class ControladorAPI {
    @Autowired
    private final ServicioJugos servicioJugos;
    private final ServicioUsuarios servicioUsuarios;

    public ControladorAPI(ServicioJugos servicioJugos,
                            ServicioUsuarios servicioUsuarios){
        this.servicioJugos = servicioJugos;
        this.servicioUsuarios = servicioUsuarios;
    }

    @GetMapping("/api/jugos")
    // Nuevo tipo de retorno ResponseEntity<>
    public ResponseEntity<List<Jugo>> apiMostrarJugos(){
        List<Jugo> jugos = this.servicioJugos.obtenerTodos();
        return new ResponseEntity<>(jugos, HttpStatus.OK);
    }

    @GetMapping("/api/usuario/{idUsuario}")
    public ResponseEntity<Usuario> apiMostrarInfoUsuario(@PathVariable Long idUsuario){
        Usuario usuario = this.servicioUsuarios.obtenerPorId(idUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
