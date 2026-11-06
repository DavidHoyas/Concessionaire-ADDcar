package es.etg.daw.dawes.java.web.Concessionary.ADDcar.domain.error;

public class CocheNotFoundException extends EntityNotFoundException {

public static final String ENTIDAD = "Coche";

public CocheNotFoundException() {
super(ENTIDAD);
    }

public CocheNotFoundException(int id) {
super(ENTIDAD, id);
    }
}
