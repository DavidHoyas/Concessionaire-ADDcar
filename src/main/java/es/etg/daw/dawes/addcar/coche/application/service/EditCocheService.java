package es.etg.daw.dawes.addcar.coche.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.usecase.EditCocheUseCase;

@RequiredArgsConstructor
@Service
public class EditCocheService {

    private final EditCocheUseCase editCocheUseCase;

    public Coche update(EditCocheCommand command) {
        return editCocheUseCase.update(command);
    }
}