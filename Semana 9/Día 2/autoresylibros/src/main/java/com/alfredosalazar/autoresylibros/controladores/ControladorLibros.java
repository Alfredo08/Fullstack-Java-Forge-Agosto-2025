package com.alfredosalazar.autoresylibros.controladores;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alfredosalazar.autoresylibros.modelos.Autor;
import com.alfredosalazar.autoresylibros.modelos.Libro;
import com.alfredosalazar.autoresylibros.servicios.ServicioAutores;
import com.alfredosalazar.autoresylibros.servicios.ServicioLibros;

import jakarta.validation.Valid;



@Controller
public class ControladorLibros {
    @Autowired
    private final ServicioLibros servicioLibros;

    @Autowired
    private final ServicioAutores servicioAutores;

    public ControladorLibros(ServicioLibros servicioLibros, 
                             ServicioAutores servicioAutores){
        this.servicioLibros = servicioLibros;
        this.servicioAutores = servicioAutores;
    }

    @GetMapping("/libros")
    public String libros(Model modelo){
        List<Libro> listaLibros = this.servicioLibros.obtenerTodos();
        modelo.addAttribute("listaLibros", listaLibros);
        return "libros";
    }

    @GetMapping("/formulario/libro")
    public String formularioLibro(@ModelAttribute("nuevoLibro") Libro nuevoLibro, Model modelo){
        List<Autor> autores = this.servicioAutores.obtenerTodos();
        modelo.addAttribute("autores", autores);
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

    @GetMapping("/formulario/actualizar/libro/{idLibro}")
    public String formularioEditarLibro(@PathVariable Long idLibro,
                                        Model modelo){
        Libro libro = this.servicioLibros.obtenerUno(idLibro);
        modelo.addAttribute("libro", libro);
        return "formularioEditarLibro";
    }

    @PostMapping("/agregar/libro")
    public String agregarLibro(@Valid @ModelAttribute("nuevoLibro") Libro nuevoLibro,
                               BindingResult validaciones, @RequestParam Long idAutor){
        if(validaciones.hasErrors()){
            return "formularioLibro";
        }
        Autor autor = this.servicioAutores.obtenerUno(idAutor);
        nuevoLibro.setAutor(autor);

        this.servicioLibros.agregar(nuevoLibro);
        return "redirect:/libros";
    }

    @DeleteMapping("/eliminar/libro/{idLibro}")
    public String eliminarLibro(@PathVariable Long idLibro){
        this.servicioLibros.eliminarUno(idLibro);
        return "redirect:/libros";
    }

    @PutMapping("/editar/libro/{idLibro}")
    public String actualizarLibro(@Valid @ModelAttribute("libro") Libro libro,
                                  BindingResult validaciones, 
                                  @PathVariable Long idLibro){
        if(validaciones.hasErrors()){
            return "formularioEditarLibro";
        }
        libro.setId(idLibro);
        this.servicioLibros.actualizarUno(libro);
        return "redirect:/detalle/libro/" + idLibro;
    }
}
