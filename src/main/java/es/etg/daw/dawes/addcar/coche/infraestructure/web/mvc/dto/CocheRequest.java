package es.etg.daw.dawes.addcar.coche.infraestructure.web.mvc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import es.etg.daw.dawes.addcar.coche.infraestructure.web.validation.NombradoCoche;

public record CocheRequest(
                @NotBlank(message = "{coche.valid.nombre.no_vacio}") @NombradoCoche(message = "{coche.valid.nombre.nombrado_validation}") String nombre,
                @NotBlank(message = "{coche.valid.tipo.no_vacio}") String tipo, String foto,
                @Min(value = 0, message = "{coche.valid.precio.min}") @Max(value = 100, message = "{coche.valid.precio.max}") double precio) {

}