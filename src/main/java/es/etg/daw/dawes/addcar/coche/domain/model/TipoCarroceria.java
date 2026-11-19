package es.etg.daw.dawes.addcar.coche.domain.model;

public enum TipoCarroceria {
    //        minPuertas, maxPuertas, minPlazas, maxPlazas
    SEDAN(4, 5, 4, 5),
    SUV(3, 5, 5, 7),
    COUPE(2, 3, 2, 4),
    FAMILIAR(5, 5, 5, 7),
    COMPACTO(3, 5, 4, 5),
    MONOVOLUMEN(5, 5, 5, 9),
    CABRIO(2, 3, 2, 4);

    private final int minPuertas;
    private final int maxPuertas;
    private final int minPlazas;
    private final int maxPlazas;

    TipoCarroceria(int minPuertas, int maxPuertas, int minPlazas, int maxPlazas) {
        this.minPuertas = minPuertas;
        this.maxPuertas = maxPuertas;
        this.minPlazas = minPlazas;
        this.maxPlazas = maxPlazas;
    }

    public boolean admitePuertas(int puertas) {
        return puertas >= minPuertas && puertas <= maxPuertas;
    }

    public boolean admitePlazas(int plazas) {
        return plazas >= minPlazas && plazas <= maxPlazas;
    }
}
