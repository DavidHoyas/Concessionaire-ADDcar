package es.etg.daw.dawes.addcar.coche.application.usecase;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;
import es.etg.daw.dawes.addcar.coche.application.command.CreateCocheCommand;

@AllArgsConstructor
public class CreateCocheUseCase {

    private final CocheRepository cocheRepository;

    public Coche create(CreateCocheCommand comando) {

        Coche coche = Coche.builder()
                .marca(comando.marca())
                .modelo(comando.modelo())
                .foto(comando.foto())
                .precio(comando.precio())
                .anio(comando.anio())
                .kilometros(comando.kilometros())
                .combustion(comando.combustion())
                .transmision(comando.transmision())
                .traccion(comando.traccion())
                .tipoCarroceria(comando.tipoCarroceria())
                .estado(comando.estado())
                .color(comando.color())
                .puertas(comando.puertas())
                .plazas(comando.plazas())
                .cv(comando.cv())
                .cilindrada(comando.cilindrada())
                .createdAt(LocalDateTime.now())
                .build();

        return cocheRepository.save(coche);
    }
}
