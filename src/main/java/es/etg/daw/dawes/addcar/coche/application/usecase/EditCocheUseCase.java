package es.etg.daw.dawes.addcar.coche.application.usecase;

import lombok.AllArgsConstructor;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.domain.repository.CocheRepository;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;

@AllArgsConstructor
public class EditCocheUseCase {

    private final CocheRepository cocheRepository;
    private final FindCocheUseCase findCocheUseCase;

    public Coche update(EditCocheCommand command) {
        Coche coche = findCocheUseCase.findById(command.id());

        coche.setMarca(command.marca());
        coche.setModelo(command.modelo());
        coche.setFoto(command.foto());
        coche.setPrecio(command.precio());
        coche.setAnio(command.anio());
        coche.setCombustion(command.combustion());
        coche.setTransmision(command.transmision());
        coche.setTraccion(command.traccion());
        coche.setTipoCarroceria(command.tipoCarroceria());
        coche.setColor(command.color());
        coche.setCilindrada(command.cilindrada());
        coche.setCv(command.cv());
        coche.setStock(command.stock());

        return cocheRepository.save(coche);
    }
}