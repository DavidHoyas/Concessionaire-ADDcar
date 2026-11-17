package es.etg.daw.dawes.addcar.coche.application.usercase;

import java.util.List;
import lombok.AllArgsConstructor;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;
import es.etg.daw.dawes.addcar.coche.domain.error.CocheNotFoundException;

@AllArgsConstructor
public class FindCocheUseCase {

    private final CocheRepository cocheRepository;

    public List<Coche> findAll() {
        List<Coche> coches = cocheRepository.getAll();

        if (coches.isEmpty())
            throw new CocheNotFoundException();

        return coches;
    }

    public Coche findById(int id) {
        return cocheRepository.getById(id)
                .orElseThrow(() -> new CocheNotFoundException(id));
    }
}