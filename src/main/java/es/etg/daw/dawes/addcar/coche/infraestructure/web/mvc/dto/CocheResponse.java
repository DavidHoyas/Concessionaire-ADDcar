package es.etg.daw.dawes.addcar.coche.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record CocheResponse(int id, String nombre, String tipo, String foto,
        double precio, LocalDateTime createdAt) {

}