package es.etg.daw.dawes.addcar.coche.application.command;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateCocheCommand {

    private String marca;
    private String modelo;
    private String foto;
    private double precio;
}