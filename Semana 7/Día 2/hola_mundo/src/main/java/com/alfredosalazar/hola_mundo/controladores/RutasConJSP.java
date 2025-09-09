package com.alfredosalazar.hola_mundo.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
