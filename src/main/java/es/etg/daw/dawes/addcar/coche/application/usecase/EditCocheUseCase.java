package es.etg.daw.dawes.addcar.coche.application.usecase;

import lombok.AllArgsConstructor;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.error.CocheInvalidoException;
import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;

@AllArgsConstructor
public class EditCocheUseCase {

    private final CocheRepository cocheRepository;
    private final FindCocheUseCase findCocheUseCase;

    public Coche update(EditCocheCommand command) {
        Coche coche = findCocheUseCase.findById(command.id());

        // Reglas que necesitan conocer el estado anterior del coche
        if (command.kilometros() < coche.getKilometros())
            throw new CocheInvalidoException(
                    "Los kilómetros no pueden disminuir (actual: %d km)".formatted(coche.getKilometros()));

        if (command.estado().ordinal() < coche.getEstado().ordinal())
            throw new CocheInvalidoException(
                    "El estado no puede retroceder de %s a %s".formatted(coche.getEstado(), command.estado()));

        coche.setMarca(command.marca());
        coche.setModelo(command.modelo());
        coche.setFoto(command.foto());
        coche.setPrecio(command.precio());
        coche.setAnio(command.anio());
        coche.setKilometros(command.kilometros());
        coche.setCombustion(command.combustion());
        coche.setTransmision(command.transmision());
        coche.setTraccion(command.traccion());
        coche.setTipoCarroceria(command.tipoCarroceria());
        coche.setEstado(command.estado());
        coche.setColor(command.color());
        coche.setPuertas(command.puertas());
        coche.setPlazas(command.plazas());
        coche.setCv(command.cv());
        coche.setCilindrada(command.cilindrada());

        return cocheRepository.save(coche);
    }
}
