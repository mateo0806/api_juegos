package com.example.api_juegos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.example.api_juegos.dto.VideojuegoDTO;

@RestController
public class JuegoController {

    @GetMapping("/videojuegos")
    public String obtenerVideojuegos() {
        return "Lista de videojuegos";
    }

    @GetMapping("/videojuegos/{id}")
    public String obtenerVideojuegoPorId(@PathVariable int id) {
        return "Videojuego encontrado con ID: " + id;
    }

    @GetMapping("/buscar")
    public String buscarVideojuego(@RequestParam String nombre) {
        return "Buscando videojuego: " + nombre;
    }

    @PostMapping("/videojuegos")
    public ResponseEntity<String> crearVideojuego(@RequestBody VideojuegoDTO videojuego) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Videojuego creado: " + videojuego.nombre());
    }
}