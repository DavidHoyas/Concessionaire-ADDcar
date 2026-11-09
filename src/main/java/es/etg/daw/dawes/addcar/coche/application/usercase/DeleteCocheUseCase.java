package es.etg.daw.dawes.addcar.coche.application.usercase;

import lombok.AllArgsConstructor;
import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;

@AllArgsConstructor
public class DeleteCocheUseCase {

    private final CocheRepository cocheRepository;
    private final FindCocheUseCase findCocheUseCase;

    public void delete(int id) {
        findCocheUseCase.findById(id);

        cocheRepository.deleteById(id);
    }
}