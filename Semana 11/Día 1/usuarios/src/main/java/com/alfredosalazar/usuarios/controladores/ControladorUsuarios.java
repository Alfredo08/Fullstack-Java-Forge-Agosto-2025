package com.alfredosalazar.usuarios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alfredosalazar.usuarios.modelos.LoginUsuario;
import com.alfredosalazar.usuarios.modelos.Usuario;
import com.alfredosalazar.usuarios.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
    @Autowired
    private final ServicioUsuarios servicioUsuarios;

    public ControladorUsuarios(ServicioUsuarios servicioUsuarios){
        this.servicioUsuarios = servicioUsuarios;
    }

    @GetMapping("/registro")
    public String registro(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario){
        return "registro";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginUsuario") LoginUsuario loginUsuario){
        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(HttpSession sesion){
        if(sesion.getAttribute("correo") == null){
            return "redirect:/login";
        }
        return "inicio";
    }

    @PostMapping("/agregar/usuario")
    public String agregarUsuario(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
                                 BindingResult validaciones, HttpSession sesion){
        if(validaciones.hasErrors()){
            return "registro";
        }
        nuevoUsuario = this.servicioUsuarios.agregarUno(nuevoUsuario);
        sesion.setAttribute("correo", nuevoUsuario.getCorreo());
        sesion.setAttribute("id_usuario", nuevoUsuario.getId());

        return "redirect:/inicio";
    }

    @PostMapping("/procesar/login")
    public String procesarLogin(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
                                BindingResult validaciones, HttpSession sesion){
        if(validaciones.hasErrors()){
            return "login";
        }
        Usuario usuario = this.servicioUsuarios.obtenerUnoPorCorreoYContrasenia(loginUsuario.getCorreo(), 
                                                                            loginUsuario.getContrasenia());
        if(usuario == null){
            validaciones.rejectValue("contrasenia", "credencialesInvalidas", "Credenciales incorrectas");
        }

        sesion.setAttribute("correo", usuario.getCorreo());
        sesion.setAttribute("id_usuario", usuario.getId());

        return "redirect:/inicio";

    }
}
