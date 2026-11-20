package es.etg.daw.dawes.addcar.coche.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.command.CreateCocheCommand;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto.CocheRequest;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto.CocheResponse;

@Mapper(componentModel = "spring")
public interface CocheMapper {

    public static final String CAMPO_ID = "id";
    public static final String CAMPO_MARCA = "marca";
    public static final String CAMPO_MODELO = "modelo";
    public static final String CAMPO_FOTO = "foto";
    public static final String CAMPO_PRECIO = "precio";
    public static final String CAMPO_ANIO = "anio";
    public static final String CAMPO_COMBUSTION = "combustion";
    public static final String CAMPO_TRANSMISION = "transmision";
    public static final String CAMPO_TRACCION = "traccion";
    public static final String CAMPO_TIPO_CARROCERIA = "tipoCarroceria";
    public static final String CAMPO_COLOR = "color";
    public static final String CAMPO_CILINDRADA = "cilindrada";
    public static final String CAMPO_CV = "cv";
    public static final String CAMPO_STOCK = "stock";
    public static final String CAMPO_REQUEST = "request.";

    CreateCocheCommand toCommand(CocheRequest request);

    CocheResponse toResponse(Coche coche);

    @Mapping(source = CAMPO_ID, target = CAMPO_ID)
    @Mapping(source = CAMPO_REQUEST + CAMPO_MARCA, target = CAMPO_MARCA)
    @Mapping(source = CAMPO_REQUEST + CAMPO_MODELO, target = CAMPO_MODELO)
    @Mapping(source = CAMPO_REQUEST + CAMPO_FOTO, target = CAMPO_FOTO)
    @Mapping(source = CAMPO_REQUEST + CAMPO_PRECIO, target = CAMPO_PRECIO)
    @Mapping(source = CAMPO_REQUEST + CAMPO_ANIO, target = CAMPO_ANIO)
    @Mapping(source = CAMPO_REQUEST + CAMPO_COMBUSTION, target = CAMPO_COMBUSTION)
    @Mapping(source = CAMPO_REQUEST + CAMPO_TRANSMISION, target = CAMPO_TRANSMISION)
    @Mapping(source = CAMPO_REQUEST + CAMPO_TRACCION, target = CAMPO_TRACCION)
    @Mapping(source = CAMPO_REQUEST + CAMPO_TIPO_CARROCERIA, target = CAMPO_TIPO_CARROCERIA)
    @Mapping(source = CAMPO_REQUEST + CAMPO_COLOR, target = CAMPO_COLOR)
    @Mapping(source = CAMPO_REQUEST + CAMPO_CILINDRADA, target = CAMPO_CILINDRADA)
    @Mapping(source = CAMPO_REQUEST + CAMPO_CV, target = CAMPO_CV)
    @Mapping(source = CAMPO_REQUEST + CAMPO_STOCK, target = CAMPO_STOCK)
    EditCocheCommand toCommand(int id, CocheRequest request);
}