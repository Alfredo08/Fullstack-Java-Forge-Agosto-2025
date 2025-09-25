package com.alfredosalazar.autoresylibros.controladores;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alfredosalazar.autoresylibros.modelos.Autor;
import com.alfredosalazar.autoresylibros.modelos.LoginAutor;
import com.alfredosalazar.autoresylibros.servicios.ServicioAutores;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorAutores {
    @Autowired
    private final ServicioAutores servicioAutores;

    public ControladorAutores(ServicioAutores servicioAutores){
        this.servicioAutores = servicioAutores;
    }

    @GetMapping("/registro")
    public String registro(@ModelAttribute("nuevoAutor") Autor nuevoAutor){
        return "registro";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginAutor") LoginAutor loginAutor){
        return "login";
    }

    @PostMapping("/procesar/login")
    public String procesarLogin(@Valid @ModelAttribute("loginAutor") LoginAutor loginAutor,
                                BindingResult validaciones, HttpSession sesion){
        Autor validandoLogin = this.servicioAutores.obtenerUnoPorCorreo(loginAutor.getCorreo());
        if(validandoLogin == null){
            validaciones.rejectValue("contrasenia", "credencialesIncorrectas", "Correo inválido.");
        }
        else{
            if(! BCrypt.checkpw(loginAutor.getContrasenia(), validandoLogin.getContrasenia())){
                validaciones.rejectValue("contrasenia", "credencialesIncorrectas", "Credenciales incorrectas.");
            }
        }

        if(validaciones.hasErrors()){
            return "login";
        }

        // Agregar en sesion los datos del autor
        sesion.setAttribute("id_autor", validandoLogin.getId());
        sesion.setAttribute("nombre_autor", validandoLogin.getNombre());
        
        return "redirect:/libros";
    }

    @PostMapping("/agregar/autor")
    public String agregarAutor(@Valid @ModelAttribute("nuevoAutor") Autor nuevoAutor,
                               BindingResult validaciones,
                               HttpSession sesion){
        if(! nuevoAutor.getContrasenia().equals(nuevoAutor.getConfirmarContrasenia())){
            validaciones.rejectValue("confirmarContrasenia", "contraseniaNoCoincide", "Las constraseñas no coiciden.");
        }

        if(validaciones.hasErrors()){
            return "registro";
        }

        // Guardar el autor en la base de datos
        nuevoAutor = this.servicioAutores.agregarUno(nuevoAutor);

        // Incluir datos del autor en sesión
        sesion.setAttribute("id_autor", nuevoAutor.getId());
        sesion.setAttribute("nombre_autor", nuevoAutor.getNombre());

        return "redirect:/libros";
    }

    @GetMapping("/logout")
    public String logout(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/login";
    }
}
