package com.alfredosalazar.jugos.controladores;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alfredosalazar.jugos.modelos.LoginUsuario;
import com.alfredosalazar.jugos.modelos.Usuario;
import com.alfredosalazar.jugos.servicios.ServicioUsuarios;

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

    @GetMapping("/logout")
    public String logout(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/agregar/usuario")
    public String agregarUsuario(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
                                 BindingResult validaciones, HttpSession sesion){
        // Validar que las contraseñas coincidan
        if(! nuevoUsuario.getContrasenia().equals(nuevoUsuario.getConfirmarContrasenia())){
            validaciones.rejectValue("confirmarContrasenia", "contraseniaNoCoincida", "Las contraseñas no coinciden.");
        }

        // Validar que el correo del usuario sea único
        if(this.servicioUsuarios.obtenerPorCorreo(nuevoUsuario.getCorreo()) != null){
            validaciones.rejectValue("correo", "correoDuplicado", "Este correo ya está en uso.");
        }

        if(validaciones.hasErrors()){
            return "registro";
        }

        // Agregamos el usuario a la base de datos
        nuevoUsuario = this.servicioUsuarios.agregarUno(nuevoUsuario);

        // Creamos la sesion del usuario
        sesion.setAttribute("id_usuario", nuevoUsuario.getId());
        sesion.setAttribute("nombre", nuevoUsuario.getNombre() + " " + nuevoUsuario.getApellido());
        
        return "redirect:/jugos";
    }

    @PostMapping("/procesar/login")
    public String procesarLogin(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
                                BindingResult validaciones, HttpSession sesion){
        Usuario usuario = this.servicioUsuarios.obtenerPorCorreo(loginUsuario.getCorreo());
        if(usuario == null){
            validaciones.rejectValue("correo", "correoNoExistente", "Correo no existente.");
        }
        else{
            if(! BCrypt.checkpw(loginUsuario.getContrasenia(), usuario.getContrasenia())){
                validaciones.rejectValue("contrasenia", "credencialesIncorrectas", "Credenciales incorrectas.");
            }
            if(validaciones.hasErrors()){
                return "login";
            }
        }

        // Creamos la sesion del usuario
        sesion.setAttribute("id_usuario", usuario.getId());
        sesion.setAttribute("nombre", usuario.getNombre() + " " + usuario.getApellido());

        return "redirect:/jugos";
    }
}
