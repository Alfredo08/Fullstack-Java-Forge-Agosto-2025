package com.alfredosalazar.hola_mundo.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RutasConJSP {
    private static ArrayList<String> estudiantes = new ArrayList<String>();

    public RutasConJSP(){
        estudiantes.add("Alex Miller");
        estudiantes.add("Martha Gómez");
        estudiantes.add("Julieta Vargas");
        estudiantes.add("Roger Infante");
        estudiantes.add("Roberto López");
    }

    @GetMapping("/primerJSP")
    public String primerJSP(){
        return "index";
    }

    @GetMapping("/estudiantes")
    public String estudiantes(Model modelo){
        modelo.addAttribute("titulo", "Listado de estudiantes.");
        modelo.addAttribute("estudiantes", estudiantes);
        return "estudiantes";
    }

    @GetMapping("/formulario/estudiante")
    public String formularioEstudiante(){
        return "nuevoEstudiante";
    }

    @PostMapping("/agregar/estudiante")
    public String agregarEstudiante(@RequestParam String nombre,
                                    @RequestParam String apellidoPaterno,
                                    @RequestParam String apellidoMaterno){
        String nombreCompleto = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
        estudiantes.add(nombreCompleto);
        System.out.println("Nombre agregado: " + nombreCompleto);
        return "redirect:/estudiantes";
    }
}
