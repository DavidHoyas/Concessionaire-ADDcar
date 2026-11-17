package es.etg.daw.dawes.addcar.coche.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.command.CreateCocheCommand;
import es.etg.daw.dawes.addcar.coche.infraestructure.web.mvc.dto.CocheRequest;
import es.etg.daw.dawes.addcar.coche.infraestructure.web.mvc.dto.CocheResponse;

@Mapper(componentModel = "spring")
public interface CocheMapper {

    CreateCocheCommand toCommand(CocheRequest request);

    CocheResponse toResponse(Coche coche);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "request.foto", target = "foto")
    @Mapping(source = "request.precio", target = "precio")
    EditCocheCommand toCommand(int id, CocheRequest request);
}