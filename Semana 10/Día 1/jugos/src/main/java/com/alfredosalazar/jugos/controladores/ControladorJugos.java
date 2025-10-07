package com.alfredosalazar.jugos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alfredosalazar.jugos.modelos.Jugo;
import com.alfredosalazar.jugos.modelos.Usuario;
import com.alfredosalazar.jugos.servicios.ServicioJugos;
import com.alfredosalazar.jugos.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorJugos {
    @Autowired
    private final ServicioJugos servicioJugos;
    private final ServicioUsuarios servicioUsuarios;

    public ControladorJugos(ServicioJugos servicioJugos,
                            ServicioUsuarios servicioUsuarios){
        this.servicioJugos = servicioJugos;
        this.servicioUsuarios = servicioUsuarios;
    }

    @GetMapping("/jugos")
    public String jugos(Model modelo){
        List<Jugo> listaJugos = this.servicioJugos.obtenerTodos();
        modelo.addAttribute("listaJugos", listaJugos);
        return "jugos";
    }

    @GetMapping("/formulario/jugo")
    public String formularioJugo(@ModelAttribute("nuevoJugo") Jugo nuevoJugo){
        return "formularioJugo";
    }

    @PostMapping("/agregar/jugo")
    public String agregarJugo(@Valid @ModelAttribute("nuevoJugo") Jugo nuevoJugo,
                              BindingResult validaciones, HttpSession sesion){
        if(validaciones.hasErrors()){
            return "formularioJugo";
        }
        Long idUsuario = (Long)sesion.getAttribute("id_usuario");
        Usuario usuario = this.servicioUsuarios.obtenerPorId(idUsuario);
        
        nuevoJugo.setUsuario(usuario);
        this.servicioJugos.agregarUno(nuevoJugo);

        return "redirect:/jugos";
    }

    @DeleteMapping("/eliminar/jugo/{idJugo}")
    public String eliminarJugo(@PathVariable Long idJugo){
        this.servicioJugos.eliminarUno(idJugo);
        return "redirect:/jugos";
    }
}
