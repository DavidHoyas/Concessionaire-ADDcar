package es.etg.daw.dawes.addcar.coche.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Coche {

    private int id;
    private String marca;
    private String modelo;
    private String foto;
    private BigDecimal precio;
    private int anio;
    private int kilometros;
    private Combustion combustion;
    private Transmision transmision;
    private Traccion traccion;
    private TipoCarroceria tipoCarroceria;
    private Estado estado;
    private String color;
    private int puertas;
    private int plazas;
    private int cv;
    private int cilindrada;
    private LocalDateTime createdAt;

    public EtiquetaAmbiental getEtiquetaAmbiental() {
        return switch (combustion) {
            case ELECTRICO -> EtiquetaAmbiental.CERO;
            case HIBRIDO, GLP, GNC -> EtiquetaAmbiental.ECO;
            case GASOLINA -> anio >= 2006 ? EtiquetaAmbiental.C
                    : anio >= 2000 ? EtiquetaAmbiental.B : EtiquetaAmbiental.SIN_ETIQUETA;
            case DIESEL -> anio >= 2015 ? EtiquetaAmbiental.C
                    : anio >= 2006 ? EtiquetaAmbiental.B : EtiquetaAmbiental.SIN_ETIQUETA;
        };
    }
}
