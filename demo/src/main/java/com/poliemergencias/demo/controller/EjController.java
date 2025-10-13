package com.poliemergencias.demo.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*") // para permitir llamados desde cualquier frontend
@RestController
@RequestMapping("ejemplo")
public class EjController {
    @GetMapping("/holamundo")
    public String holamundo(){
        return "Hola Mundo";
    }
}
