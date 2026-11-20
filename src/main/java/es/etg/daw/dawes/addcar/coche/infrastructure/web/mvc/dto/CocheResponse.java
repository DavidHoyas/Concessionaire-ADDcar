package es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto;

import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;
import es.etg.daw.dawes.addcar.coche.domain.model.EtiquetaAmbiental;

public record CocheResponse(
        int id,
        String marca,
        String modelo,
        String foto,
        double precio,
        int anio,
        Combustion combustion,
        Transmision transmision,
        Traccion traccion,
        TipoCarroceria tipoCarroceria,
        String color,
        double cilindrada,
        int cv,
        int stock,
        EtiquetaAmbiental etiquetaAmbiental) {
}