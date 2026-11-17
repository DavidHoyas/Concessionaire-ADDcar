package es.etg.daw.dawes.addcar.coche.infraestructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;
import es.etg.daw.dawes.addcar.coche.application.usercase.EditCocheUseCase;
import es.etg.daw.dawes.addcar.coche.application.usercase.FindCocheUseCase;
import es.etg.daw.dawes.addcar.coche.application.usercase.DeleteCocheUseCase;
import es.etg.daw.dawes.addcar.coche.application.usercase.CreateCocheUseCase;

@Configuration
@RequiredArgsConstructor
public class CocheConfig {

    private final CocheRepository cocheRepository;

    @Bean
    public CreateCocheUseCase createCocheUseCase() {
        return new CreateCocheUseCase(cocheRepository);
    }

    @Bean
    public FindCocheUseCase findCocheUseCase() {
        return new FindCocheUseCase(cocheRepository);
    }

    @Bean
    public DeleteCocheUseCase deleteCocheUseCase(FindCocheUseCase findCocheUseCase) {
        return new DeleteCocheUseCase(cocheRepository, findCocheUseCase);
    }

    @Bean
    public EditCocheUseCase editCocheUseCase(FindCocheUseCase findCocheUseCase) {
        return new EditCocheUseCase(cocheRepository, findCocheUseCase);
    }
}