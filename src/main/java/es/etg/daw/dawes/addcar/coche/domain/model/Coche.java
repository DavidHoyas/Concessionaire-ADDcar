package es.etg.daw.dawes.addcar.coche.domain.model;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class Coche {

    private static final int ANIO_ECO_HIBRIDO = 2006;
    private static final int ANIO_GASOLINA_C = 2006;
    private static final int ANIO_GASOLINA_B = 2000;
    private static final int ANIO_DIESEL_C = 2015;
    private static final int ANIO_DIESEL_B = 2005;

    private int id;
    private String marca;
    private String modelo;
    private String foto;
    private double precio;
    private int anio;
    private Combustion combustion;
    private Transmision transmision;
    private Traccion traccion;
    private TipoCarroceria tipoCarroceria;
    private String color;
    private double cilindrada;
    private int cv;
    private int stock;

    public EtiquetaAmbiental getEtiquetaAmbiental() {
        return switch (combustion) {
            case ELECTRICO -> EtiquetaAmbiental.CERO;
            case HIBRIDO, GLP, GNC -> anio >= ANIO_ECO_HIBRIDO ? EtiquetaAmbiental.ECO : etiquetaGasolina();
            case GASOLINA -> etiquetaGasolina();
            case DIESEL -> etiquetaDiesel();
        };
    }

    private EtiquetaAmbiental etiquetaGasolina() {
        if (anio >= ANIO_GASOLINA_C) {
            return EtiquetaAmbiental.C;
        } else if (anio >= ANIO_GASOLINA_B) {
            return EtiquetaAmbiental.B;
        }
        return EtiquetaAmbiental.SIN_ETIQUETA;
    }

    private EtiquetaAmbiental etiquetaDiesel() {
        if (anio >= ANIO_DIESEL_C) {
            return EtiquetaAmbiental.C;
        } else if (anio >= ANIO_DIESEL_B) {
            return EtiquetaAmbiental.B;
        }
        return EtiquetaAmbiental.SIN_ETIQUETA;
    }
}