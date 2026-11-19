package es.etg.daw.dawes.addcar.coche.infraestructure.db.repository.mock;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;

@Repository
public class CocheRepositoryMockImpl implements CocheRepository {

    private final Map<Integer, Coche> coches = CocheFactory.getDemoData();

    @Override
    public Coche save(Coche t) {
        if (t.getId() == 0)
            t.setId(obtenerSiguienteId());
        coches.put(t.getId(), t);

        return t;
    }

    private int obtenerSiguienteId() {
        return coches.keySet().stream().mapToInt(Integer::intValue).max().orElse(0) + 1;
    }

    @Override
    public List<Coche> getAll() {
        return new ArrayList<>(coches.values());
    }

    @Override
    public Optional<Coche> getById(Integer id) {
        return Optional.ofNullable(coches.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        coches.remove(id);
    }
}