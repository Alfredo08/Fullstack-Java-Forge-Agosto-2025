package com.alfredosalazar.hola_mundo.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

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

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/procesa/login")
    public String procesaLogin(@RequestParam String nombreUsuario,
                               @RequestParam String contraseña,
                               HttpSession sesion,
                               RedirectAttributes flash){
        boolean hayError = false;
        if(nombreUsuario.length() < 3){
            flash.addFlashAttribute("errorNombreUsuario", "Por favor proporciona tu nombre de usuario");
            hayError = true;
        }
        if(! contraseña.equals("secreto123")){
            flash.addFlashAttribute("errorContraseña", "La contraseña es inválida.");
            hayError = true;
        }
        if(hayError){
            return "redirect:/login";
        }
        sesion.setAttribute("nombreUsuario", nombreUsuario);
        return "redirect:/inicio";
    }

    @GetMapping("/inicio")
    public String inicio(HttpSession sesion){
        String usuario = (String)sesion.getAttribute("nombreUsuario");

        if(usuario != null){
            return "inicio";
        }
        return "redirect:/login";
    }

    @PostMapping("/procesa/logout")
    public String procesaLogout(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/login";
    }
}
