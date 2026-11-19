package es.etg.daw.dawes.addcar.coche.application.command;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Estado;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;
import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditCocheCommand {

    private int id;
    private String marca;
    private String modelo;
    private String foto;
    private BigDecimal precio;
    private int anio;
    private int kilometros;
    private Combustion combustion;
    private Transmision transmision;
    private Traccion traccion;
    private TipoCarroceria tipoCarroceria;
    private Estado estado;
    private String color;
    private int puertas;
    private int plazas;
    private int cv;
    private int cilindrada;
}
