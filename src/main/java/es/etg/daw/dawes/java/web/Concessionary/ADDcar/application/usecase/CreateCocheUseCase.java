package es.etg.daw.dawes.java.web.Concessionary.ADDcar.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.web.Concessionary.ADDcar.application.command.CreateCocheCommand;
import es.etg.daw.dawes.java.web.Concessionary.ADDcar.domain.model.Coche;
import es.etg.daw.dawes.java.web.Concessionary.ADDcar.domain.repository.CocheRepository;
import lombok.AllArgsConstructor;

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
