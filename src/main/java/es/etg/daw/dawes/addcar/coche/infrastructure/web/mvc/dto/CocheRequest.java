package es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.validation.CocheCoherente;

@CocheCoherente
public record CocheRequest(

        @NotBlank(message = MSG_MARCA_NO_VACIA) String marca,

        @NotBlank(message = MSG_MODELO_NO_VACIO) String modelo,

        @URL(regexp = REGEX_URL, message = MSG_FOTO_URL) String foto,

        @Min(value = PRECIO_MIN, message = MSG_PRECIO_MIN) @Max(value = PRECIO_MAX, message = MSG_PRECIO_MAX) double precio,

        @Min(value = ANIO_MIN, message = MSG_ANIO_MIN) int anio,

        @NotNull(message = MSG_COMBUSTION_OBLIGATORIA) Combustion combustion,

        @NotNull(message = MSG_TRANSMISION_OBLIGATORIA) Transmision transmision,

        @NotNull(message = MSG_TRACCION_OBLIGATORIA) Traccion traccion,

        @NotNull(message = MSG_CARROCERIA_OBLIGATORIA) TipoCarroceria tipoCarroceria,

        @NotBlank(message = MSG_COLOR_NO_VACIO) String color,

        @Min(value = CILINDRADA_MIN, message = MSG_CILINDRADA_RANGO) @Max(value = CILINDRADA_MAX, message = MSG_CILINDRADA_RANGO) double cilindrada,

        @Min(value = CV_MIN, message = MSG_CV_MIN) @Max(value = CV_MAX, message = MSG_CV_MAX) int cv,

        @Min(value = STOCK_MIN, message = MSG_STOCK_MIN) int stock) {

    public static final String MSG_MARCA_NO_VACIA = "{coche.valid.marca.no_vacio}";
    public static final String MSG_MODELO_NO_VACIO = "{coche.valid.modelo.no_vacio}";
    public static final String MSG_FOTO_URL = "{coche.valid.foto.url}";
    public static final String MSG_PRECIO_MIN = "{coche.valid.precio.min}";
    public static final String MSG_PRECIO_MAX = "{coche.valid.precio.max}";
    public static final String MSG_ANIO_MIN = "{coche.valid.anio.min}";
    public static final String MSG_COMBUSTION_OBLIGATORIA = "{coche.valid.combustion.not_null}";
    public static final String MSG_TRANSMISION_OBLIGATORIA = "{coche.valid.transmision.not_null}";
    public static final String MSG_TRACCION_OBLIGATORIA = "{coche.valid.traccion.not_null}";
    public static final String MSG_CARROCERIA_OBLIGATORIA = "{coche.valid.tipo_carroceria.not_null}";
    public static final String MSG_COLOR_NO_VACIO = "{coche.valid.color.no_vacio}";
    public static final String MSG_CILINDRADA_RANGO = "{coche.valid.cilindrada.rango}";
    public static final String MSG_CV_MIN = "{coche.valid.cv.min}";
    public static final String MSG_CV_MAX = "{coche.valid.cv.max}";
    public static final String MSG_STOCK_MIN = "{coche.valid.stock.min}";

    public static final String REGEX_URL = "^(http|https)://.*";
    public static final long PRECIO_MIN = 0;
    public static final long PRECIO_MAX = 1000000;
    public static final long ANIO_MIN = 1900;
    public static final long CILINDRADA_MIN = 0;
    public static final long CILINDRADA_MAX = 8;
    public static final long CV_MIN = 1;
    public static final long CV_MAX = 2000;
    public static final long STOCK_MIN = 0;
}