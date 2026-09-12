package com.example.api_juegos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/juegos")
public class JuegoController {

    private final JuegoRepository repository;

    // Inyección de dependencias por constructor
    public JuegoController(JuegoRepository repository) {
        this.repository = repository;
    }

    // 1. Crear un nuevo juego (POST /juegos)
    @PostMapping
    public ResponseEntity<Juego> crearJuego(@RequestBody Juego juego) {
        Juego nuevoJuego = repository.save(juego);
        return new ResponseEntity<>(nuevoJuego, HttpStatus.CREATED);
    }

    // 2. Consultar todos los juegos (GET /juegos)
    @GetMapping
    public ResponseEntity<List<Juego>> obtenerTodos() {
        List<Juego> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    // 3. Consultar un juego por ID (GET /juegos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Juego> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(juego -> ResponseEntity.ok(juego))
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. Consulta personalizada por género usando @RequestParam (GET /juegos/buscar?genero=accion)
    @GetMapping("/buscar")
    public ResponseEntity<List<Juego>> buscarPorGenero(@RequestParam String genero) {
        List<Juego> resultado = repository.findByGeneroIgnoreCase(genero);
        return ResponseEntity.ok(resultado);
    }

    // 5. Actualizar un juego existente (PUT /juegos/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Juego> actualizarJuego(@PathVariable Long id, @RequestBody Juego juegoDetalles) {
        return repository.findById(id)
                .map(juegoExistente -> {
                    juegoExistente.setTitulo(juegoDetalles.getTitulo());
                    juegoExistente.setGenero(juegoDetalles.getGenero());
                    juegoExistente.setPrecio(juegoDetalles.getPrecio());
                    juegoExistente.setPlataforma(juegoDetalles.getPlataforma());
                    Juego actualizado = repository.save(juegoExistente);
                    return ResponseEntity.ok(actualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 6. Eliminar un juego (DELETE /juegos/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJuego(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}