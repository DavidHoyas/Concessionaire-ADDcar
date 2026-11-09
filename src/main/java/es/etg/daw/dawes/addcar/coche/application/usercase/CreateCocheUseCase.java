package es.etg.daw.dawes.addcar.coche.application.usercase;

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
                            .createdAt(LocalDateTime.now()).build();

        return cocheRepository.save(coche);
    }
}