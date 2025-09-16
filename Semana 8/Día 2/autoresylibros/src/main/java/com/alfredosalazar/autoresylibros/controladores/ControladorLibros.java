package com.alfredosalazar.autoresylibros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alfredosalazar.autoresylibros.modelos.Libro;
import com.alfredosalazar.autoresylibros.servicios.ServicioLibros;

import jakarta.validation.Valid;



@Controller
public class ControladorLibros {
    @Autowired
    private final ServicioLibros servicioLibros;

    public ControladorLibros(ServicioLibros servicioLibros){
        this.servicioLibros = servicioLibros;
    }

    @GetMapping("/libros")
    public String libros(Model modelo){
        List<Libro> listaLibros = this.servicioLibros.obtenerTodos();
        modelo.addAttribute("listaLibros", listaLibros);
        return "libros";
    }

    @GetMapping("/formulario/libro")
    public String formularioLibro(@ModelAttribute("nuevoLibro") Libro nuevoLibro){
        return "formularioLibro";
    }

    @GetMapping("/detalle/libro/{idLibro}")
    public String detalleLibro(@PathVariable Long idLibro,
                               Model modelo){
        Libro libro = this.servicioLibros.obtenerUno(idLibro);
        if(libro == null){
            return "redirect:/libros";
        }
        modelo.addAttribute("libro", libro);
        return "detalleLibro";
    }

    @PostMapping("/agregar/libro")
    public String agregarLibro(@Valid @ModelAttribute("nuevoLibro") Libro nuevoLibro,
                               BindingResult validaciones){
        if(validaciones.hasErrors()){
            return "formularioLibro";
        }
        this.servicioLibros.agregar(nuevoLibro);
        return "redirect:/libros";
    }
}
