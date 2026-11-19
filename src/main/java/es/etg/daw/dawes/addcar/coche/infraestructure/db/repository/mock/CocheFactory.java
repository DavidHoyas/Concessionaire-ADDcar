package es.etg.daw.dawes.addcar.coche.infraestructure.db.repository.mock;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.model.Combustion;
import es.etg.daw.dawes.addcar.coche.domain.model.Estado;
import es.etg.daw.dawes.addcar.coche.domain.model.TipoCarroceria;
import es.etg.daw.dawes.addcar.coche.domain.model.Traccion;
import es.etg.daw.dawes.addcar.coche.domain.model.Transmision;

public class CocheFactory {

    public static final Map<Integer, Coche> getDemoData() {
        Map<Integer, Coche> datos = new LinkedHashMap<>();

        datos.put(1, Coche.builder().id(1).marca("marca1").modelo("Coche1").foto("")
                .precio(new BigDecimal("18500.00")).anio(2020).kilometros(60000)
                .combustion(Combustion.GASOLINA).transmision(Transmision.MANUAL).traccion(Traccion.DELANTERA)
                .tipoCarroceria(TipoCarroceria.COMPACTO).estado(Estado.OCASION).color("Rojo")
                .puertas(5).plazas(5).cv(110).cilindrada(1600).createdAt(LocalDateTime.now()).build());

        datos.put(2, Coche.builder().id(2).marca("marca2").modelo("Coche2").foto("")
                .precio(new BigDecimal("42000.00")).anio(LocalDateTime.now().getYear()).kilometros(0)
                .combustion(Combustion.ELECTRICO).transmision(Transmision.AUTOMATICA).traccion(Traccion.TOTAL)
                .tipoCarroceria(TipoCarroceria.SUV).estado(Estado.NUEVO).color("Azul")
                .puertas(5).plazas(5).cv(204).cilindrada(0).createdAt(LocalDateTime.now()).build());

        datos.put(3, Coche.builder().id(3).marca("marca3").modelo("Coche3").foto("")
                .precio(new BigDecimal("27900.00")).anio(LocalDateTime.now().getYear() - 2).kilometros(30000)
                .combustion(Combustion.DIESEL).transmision(Transmision.AUTOMATICA).traccion(Traccion.TRASERA)
                .tipoCarroceria(TipoCarroceria.SEDAN).estado(Estado.SEMINUEVO).color("Negro")
                .puertas(4).plazas(5).cv(150).cilindrada(2000).createdAt(LocalDateTime.now()).build());

        return datos;
    }
}
