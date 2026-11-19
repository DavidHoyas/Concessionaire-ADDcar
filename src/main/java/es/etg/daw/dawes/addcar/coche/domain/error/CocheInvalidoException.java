package es.etg.daw.dawes.addcar.coche.domain.error;

public class CocheInvalidoException extends RuntimeException {

    public CocheInvalidoException(String mensaje) {
        super(mensaje);
    }
}
