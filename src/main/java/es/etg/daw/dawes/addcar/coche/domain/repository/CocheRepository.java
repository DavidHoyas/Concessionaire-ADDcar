package es.etg.daw.dawes.addcar.coche.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;

public interface CocheRepository extends CRUDRepository<Coche, Integer> {
    public Optional<Coche> getByName(String name);
}
