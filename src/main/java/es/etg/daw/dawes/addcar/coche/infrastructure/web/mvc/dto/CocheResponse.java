package es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto;

import java.time.LocalDateTime;

public record CocheResponse(int id, String marca, String modelo, String foto,
                double precio, LocalDateTime createdAt) {

}