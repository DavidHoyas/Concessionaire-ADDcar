package es.etg.daw.dawes.addcar.coche.domain.error;

public class EntityNotFoundException extends RuntimeException {

    private static final String NO_ENCONTRADO = "%s no encontrado";
    private static final String ID_NO_ENCONTRADO = "%s con id %s no se encuentra";

    public EntityNotFoundException(String entity) {
        super(NO_ENCONTRADO.formatted(entity));
    }

    public EntityNotFoundException(String entity, int id) {
        super(ID_NO_ENCONTRADO.formatted(entity, id));
    }
}