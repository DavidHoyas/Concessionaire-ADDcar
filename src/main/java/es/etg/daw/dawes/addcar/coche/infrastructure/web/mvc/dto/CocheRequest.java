package es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto;

import es.etg.daw.dawes.addcar.coche.infrastructure.web.validation.NombradoCoche;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CocheRequest(
                @NotBlank(message = "{coche.valid.modelo.no_vacio}") @NombradoCoche(message = "{coche.valid.modelo.nombrado_validation}") String modelo,
                @NotBlank(message = "{coche.valid.marca.no_vacio}") String marca, String foto,
                @Min(value = 0, message = "{coche.valid.precio.min}") @Max(value = 1000000, message = "{coche.valid.precio.max}") double precio) {

}