package es.etg.daw.dawes.addcar.application.command;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditCocheCommand {

private int id;
private String foto;
private double precio;
}
