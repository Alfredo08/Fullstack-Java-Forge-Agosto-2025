package com.alfredosalazar.autoresylibros.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alfredosalazar.autoresylibros.modelos.Autor;
import com.alfredosalazar.autoresylibros.modelos.LoginAutor;
import com.alfredosalazar.autoresylibros.servicios.ServicioAutores;

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
                                BindingResult validaciones){
        Autor validandoLogin = this.servicioAutores.obtenerUnoPorCorreoYContrasenia(loginAutor.getCorreo(), loginAutor.getContrasenia());
        if(validandoLogin == null){
            validaciones.rejectValue("contrasenia", "credencialesIncorrectas", "Credenciales incorrectas.");
        }

        if(validaciones.hasErrors()){
            return "login";
        }

        // Agregar en sesion los datos del autor

        return "redirect:/libros";
    }

    @PostMapping("/agregar/autor")
    public String agregarAutor(@Valid @ModelAttribute("nuevoAutor") Autor nuevoAutor,
                               BindingResult validaciones){
        if(! nuevoAutor.getContrasenia().equals(nuevoAutor.getConfirmarContrasenia())){
            validaciones.rejectValue("confirmarContrasenia", "contraseniaNoCoincide", "Las constraseñas no coiciden.");
        }

        if(validaciones.hasErrors()){
            return "registro";
        }

        // Guardar el autor en la base de datos
        this.servicioAutores.agregarUno(nuevoAutor);

        // Incluir datos del autor en sesión

        return "redirect:/libros";
    }
}
