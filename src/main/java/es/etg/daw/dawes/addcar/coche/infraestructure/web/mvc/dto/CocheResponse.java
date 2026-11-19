package es.etg.daw.dawes.addcar.coche.infraestructure.web.mvc.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Estado;
import es.etg.daw.dawes.addcar.coche.domain.model.EtiquetaAmbiental;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;
import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;

public record CocheResponse(
        int id,
        String marca,
        String modelo,
        String foto,
        BigDecimal precio,
        int anio,
        int kilometros,
        Combustion combustion,
        Transmision transmision,
        Traccion traccion,
        TipoCarroceria tipoCarroceria,
        Estado estado,
        String color,
        int puertas,
        int plazas,
        int cv,
        int cilindrada,
        EtiquetaAmbiental etiquetaAmbiental,
        LocalDateTime createdAt) {

}
