package com.alfredosalazar.jugos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorJugos {
    @GetMapping("/jugos")
    public String jugos(){
        return "jugos";
    }
}
