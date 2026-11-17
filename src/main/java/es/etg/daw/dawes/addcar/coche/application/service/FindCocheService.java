package es.etg.daw.dawes.addcar.coche.application.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.addcar.coche.application.usecase.FindCocheUseCase;
import es.etg.daw.dawes.addcar.coche.domain.model.Coche;

@RequiredArgsConstructor
@Service
public class FindCocheService {

    private final FindCocheUseCase findCocheUseCase;

    public List<Coche> findAll() {
        return findCocheUseCase.findAll();
    }
}