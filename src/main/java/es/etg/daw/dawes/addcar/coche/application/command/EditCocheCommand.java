package es.etg.daw.dawes.addcar.coche.application.command;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditCocheCommand {

    private int id;
    private String marca;
    private String modelo;
    private String foto;
    private double precio;
    private int anio;
    private Combustion combustion;
    private Transmision transmision;
    private Traccion traccion;
    private TipoCarroceria tipoCarroceria;
    private String color;
    private double cilindrada;
    private int cv;
    private int stock;
}