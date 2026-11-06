package es.etg.daw.dawes.java.web.Concessionary.ADDcar.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.web.Concessionary.ADDcar.domain.model.Coche;

public interface CocheRepository extends CRUDRepository<Coche, Integer> {
public Optional<Coche> getByName(String name);
}
