package es.etg.daw.dawes.addcar.coche.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;

public class CocheFactory {

    public static final Map<Integer, Coche> getDemoData() {
        Map<Integer, Coche> datos = new LinkedHashMap<>();

        datos.put(1, new Coche(1, "Coche1", "marca1", "1", 1, LocalDateTime.now()));
        datos.put(2, new Coche(2, "Coche2", "marca2", "2", 2, LocalDateTime.now()));
        datos.put(3, new Coche(3, "Coche3", "marca3", "3", 3, LocalDateTime.now()));

        return datos;
    }
}