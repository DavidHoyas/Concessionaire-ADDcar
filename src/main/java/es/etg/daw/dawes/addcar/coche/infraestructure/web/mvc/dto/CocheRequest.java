package es.etg.daw.dawes.addcar.coche.infraestructure.web.mvc.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Estado;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;
import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;
import es.etg.daw.dawes.addcar.coche.infraestructure.web.validation.CocheCoherente;
import es.etg.daw.dawes.addcar.coche.infraestructure.web.validation.NombradoCoche;

@CocheCoherente
public record CocheRequest(
        @NotBlank(message = "{coche.valid.modelo.no_vacio}") @NombradoCoche(message = "{coche.valid.modelo.nombrado_validation}") String modelo,
        @NotBlank(message = "{coche.valid.marca.no_vacio}") @Size(max = 50, message = "{coche.valid.marca.size}") String marca,
        @URL(regexp = "^(http|https)://.*", message = "{coche.valid.foto.url}") @Size(max = 500, message = "{coche.valid.foto.size}") String foto,
        @NotNull(message = "{coche.valid.requerido}") @DecimalMin(value = "0.01", message = "{coche.valid.precio.min}") @DecimalMax(value = "1000000", message = "{coche.valid.precio.max}") @Digits(integer = 7, fraction = 2, message = "{coche.valid.precio.formato}") BigDecimal precio,
        @NotNull(message = "{coche.valid.requerido}") @Min(value = 1900, message = "{coche.valid.anio.min}") Integer anio,
        @NotNull(message = "{coche.valid.requerido}") @PositiveOrZero(message = "{coche.valid.km.min}") @Max(value = 1000000, message = "{coche.valid.km.max}") Integer kilometros,
        @NotNull(message = "{coche.valid.requerido}") Combustion combustion,
        @NotNull(message = "{coche.valid.requerido}") Transmision transmision,
        @NotNull(message = "{coche.valid.requerido}") Traccion traccion,
        @NotNull(message = "{coche.valid.requerido}") TipoCarroceria tipoCarroceria,
        @NotNull(message = "{coche.valid.requerido}") Estado estado,
        @NotBlank(message = "{coche.valid.color.no_vacio}") @Size(max = 30, message = "{coche.valid.color.size}") String color,
        @NotNull(message = "{coche.valid.requerido}") @Min(value = 2, message = "{coche.valid.puertas.rango}") @Max(value = 5, message = "{coche.valid.puertas.rango}") Integer puertas,
        @NotNull(message = "{coche.valid.requerido}") @Min(value = 2, message = "{coche.valid.plazas.rango}") @Max(value = 9, message = "{coche.valid.plazas.rango}") Integer plazas,
        @NotNull(message = "{coche.valid.requerido}") @Min(value = 1, message = "{coche.valid.cv.rango}") @Max(value = 2000, message = "{coche.valid.cv.rango}") Integer cv,
        @NotNull(message = "{coche.valid.requerido}") @Min(value = 0, message = "{coche.valid.cilindrada.rango}") @Max(value = 8000, message = "{coche.valid.cilindrada.rango}") Integer cilindrada) {

}
