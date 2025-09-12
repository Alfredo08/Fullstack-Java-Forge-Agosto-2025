package com.alfredosalazar.autoresylibros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alfredosalazar.autoresylibros.modelos.Libro;
import com.alfredosalazar.autoresylibros.servicios.ServicioLibros;



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
}
