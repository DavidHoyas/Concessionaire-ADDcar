package es.etg.daw.dawes.addcar.coche.application.usecase;

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
                .combustion(comando.combustion())
                .transmision(comando.transmision())
                .traccion(comando.traccion())
                .tipoCarroceria(comando.tipoCarroceria())
                .color(comando.color())
                .cilindrada(comando.cilindrada())
                .cv(comando.cv())
                .stock(comando.stock())
                .build();

        return cocheRepository.save(coche);
    }
}