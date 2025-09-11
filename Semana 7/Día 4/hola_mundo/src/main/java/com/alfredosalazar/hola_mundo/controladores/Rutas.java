package com.alfredosalazar.hola_mundo.controladores;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rutas {

    // http//localhost:8080/estudiante?nombre=Alex&apellidoPaterno=Miller
    @GetMapping("/estudiante")
	public String estudiante(@RequestParam String nombre,
                             @RequestParam String apellidoPaterno){
		return "<h1> Bienvenid@ de vuelta " + nombre + " " + apellidoPaterno + "</h1>";
	}

    // http//localhost:8080/estudiante/Alex/Miller
    @GetMapping("/estudiante/{nombre}/{apellidoPaterno}")
    public String infoEstudiante(@PathVariable String nombre, @PathVariable String apellidoPaterno){
        return "<h1> Bienvenid@ de vuelta " + nombre + " " + apellidoPaterno + "</h1>";
    }

}
