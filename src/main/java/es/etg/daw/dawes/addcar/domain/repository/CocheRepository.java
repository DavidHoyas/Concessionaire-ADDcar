package es.etg.daw.dawes.addcar.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.addcar.domain.model.Coche;

public interface CocheRepository extends CRUDRepository<Coche, Integer> {
public Optional<Coche> getByName(String name);
}
