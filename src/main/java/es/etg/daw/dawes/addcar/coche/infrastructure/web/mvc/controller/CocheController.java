package es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.controller;

import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.util.HtmlUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.infrastructure.mapper.CocheMapper;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.service.EditCocheService;
import es.etg.daw.dawes.addcar.coche.application.service.FindCocheService;
import es.etg.daw.dawes.addcar.coche.application.command.CreateCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.service.CreateCocheService;
import es.etg.daw.dawes.addcar.coche.application.service.DeleteCocheService;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto.CocheRequest;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto.CocheResponse;

@Controller
@RequestMapping(CocheController.RUTA_COCHES)
@RequiredArgsConstructor
public class CocheController {

  public static final String RUTA_COCHES = "/coches";
  private static final String RUTA_ID = "/{id}";

  private static final String ETIQUETA_MARCA = "Marca";
  private static final String ETIQUETA_MODELO = "Modelo";
  private static final String ETIQUETA_FOTO = "Foto";
  private static final String ETIQUETA_PRECIO = "Precio";
  private static final String ETIQUETA_ANIO = "Año";
  private static final String ETIQUETA_COMBUSTION = "Combustión";
  private static final String ETIQUETA_TRANSMISION = "Transmisión";
  private static final String ETIQUETA_TRACCION = "Tracción";
  private static final String ETIQUETA_CARROCERIA = "Carrocería";
  private static final String ETIQUETA_COLOR = "Color";
  private static final String ETIQUETA_CILINDRADA = "Cilindrada (Litros)";
  private static final String ETIQUETA_CV = "Potencia (CV)";
  private static final String ETIQUETA_STOCK = "Stock";
  private static final String ETIQUETA_AMBIENTAL = "Etiqueta ambiental";

  private static final String SALTO_LINEA = "\n";
  private static final String FORMATO_PARRAFO = "<p>%s: %s</p>";
  private static final String HTML_LANG_ES = "es";

  private static final String HTML_PLANTILLA_COCHE = """
      <!DOCTYPE html>
      <html lang="%s">
        <head>
          <meta charset="UTF-8">
          <title>Coche</title>
        </head>
        <body>
          <h1>Coche: %s</h1>
          %s
        </body>
      </html>
      """;

  private final CreateCocheService createCocheService;
  private final DeleteCocheService deleteCocheService;
  private final FindCocheService findCocheService;
  private final EditCocheService editCocheService;

  private final CocheMapper cocheMapper;

  @PostMapping
  @ResponseBody
  public String createCoche(@Valid CocheRequest request) {
    CreateCocheCommand command = cocheMapper.toCommand(request);

    Coche coche = createCocheService.createCoche(command);

    String detalle = String.join(SALTO_LINEA,
        fila(ETIQUETA_MARCA, coche.getMarca()),
        fila(ETIQUETA_MODELO, coche.getModelo()),
        fila(ETIQUETA_FOTO, coche.getFoto()),
        fila(ETIQUETA_PRECIO, coche.getPrecio()),
        fila(ETIQUETA_ANIO, coche.getAnio()),
        fila(ETIQUETA_COMBUSTION, coche.getCombustion()),
        fila(ETIQUETA_TRANSMISION, coche.getTransmision()),
        fila(ETIQUETA_TRACCION, coche.getTraccion()),
        fila(ETIQUETA_CARROCERIA, coche.getTipoCarroceria()),
        fila(ETIQUETA_COLOR, coche.getColor()),
        fila(ETIQUETA_CILINDRADA, coche.getCilindrada()),
        fila(ETIQUETA_CV, coche.getCv()),
        fila(ETIQUETA_STOCK, coche.getStock()),
        fila(ETIQUETA_AMBIENTAL, coche.getEtiquetaAmbiental()));

    return HTML_PLANTILLA_COCHE.formatted(HTML_LANG_ES, coche.getId(), detalle);
  }

  @GetMapping
  @ResponseBody
  public List<CocheResponse> allCoche() {
    return findCocheService.findAll()
        .stream()
        .map(cocheMapper::toResponse)
        .toList();
  }

  @DeleteMapping(RUTA_ID)
  public ResponseEntity<Void> deleteCoche(@PathVariable int id) {
    deleteCocheService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(RUTA_ID)
  @ResponseBody
  public CocheResponse editCoche(@PathVariable int id, @Valid CocheRequest cocheRequest) {
    EditCocheCommand comando = cocheMapper.toCommand(id, cocheRequest);
    Coche coche = editCocheService.update(comando);
    return cocheMapper.toResponse(coche);
  }

  private String fila(String etiqueta, Object valor) {
    return FORMATO_PARRAFO.formatted(etiqueta, HtmlUtils.htmlEscape(String.valueOf(valor)));
  }
}