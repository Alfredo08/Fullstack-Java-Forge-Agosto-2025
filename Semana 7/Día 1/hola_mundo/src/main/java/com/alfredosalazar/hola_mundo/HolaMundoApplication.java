package com.alfredosalazar.hola_mundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HolaMundoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoApplication.class, args);
	}

	@GetMapping("/")
	public String inicio(){
		return "Hola desde nuestra primera aplicación de Spring.";
	}

	@GetMapping("/perfil")
	public String perfil(){
		return "<h1> Tu perfil está en construcción. Volver más tarde. </h1>";
	}
}
