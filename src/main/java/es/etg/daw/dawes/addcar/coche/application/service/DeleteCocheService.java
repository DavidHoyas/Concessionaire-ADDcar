package es.etg.daw.dawes.addcar.coche.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import es.etg.daw.dawes.addcar.coche.application.usercase.DeleteCocheUseCase;

@RequiredArgsConstructor
@Service
public class DeleteCocheService {

    private final DeleteCocheUseCase deleteCocheUseCase;

    public void delete(int id) {
        deleteCocheUseCase.delete(id);
    }
}