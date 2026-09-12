package com.example.api_juegos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {

    // Consulta personalizada para la actividad (filtrar por género)
    List<Juego> findByGeneroIgnoreCase(String genero);
}