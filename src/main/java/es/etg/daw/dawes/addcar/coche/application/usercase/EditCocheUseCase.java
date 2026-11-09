package es.etg.daw.dawes.addcar.coche.application.usercase;

import lombok.AllArgsConstructor;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;

@AllArgsConstructor
public class EditCocheUseCase {

    private final CocheRepository cocheRepository;
    private final FindCocheUseCase findCocheUseCase;

    public Coche update(EditCocheCommand command) {
        Coche coche = findCocheUseCase.findById(command.id());

        coche.setFoto(command.foto());
        coche.setPrecio(command.precio());

        return cocheRepository.save(coche);
    }
}