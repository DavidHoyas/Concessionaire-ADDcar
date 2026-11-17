package es.etg.daw.dawes.addcar.coche.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.application.command.CreateCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.usecase.CreateCocheUseCase;

@RequiredArgsConstructor
@Service
public class CreateCocheService {

    private final CreateCocheUseCase createCocheUseCase;

    public Coche createCoche(CreateCocheCommand comando) {
        return createCocheUseCase.create(comando);
    }
}