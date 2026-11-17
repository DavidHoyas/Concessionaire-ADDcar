package es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.controller;

import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.HtmlUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import es.etg.daw.dawes.addcar.coche.domain.model.Coche;
import es.etg.daw.dawes.addcar.coche.infrastructure.mapper.CocheMapper;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto.CocheRequest;
import es.etg.daw.dawes.addcar.coche.infrastructure.web.mvc.dto.CocheResponse;
import es.etg.daw.dawes.addcar.coche.application.command.EditCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.command.CreateCocheCommand;
import es.etg.daw.dawes.addcar.coche.application.service.EditCocheService;
import es.etg.daw.dawes.addcar.coche.application.service.FindCocheService;
import es.etg.daw.dawes.addcar.coche.application.service.CreateCocheService;
import es.etg.daw.dawes.addcar.coche.application.service.DeleteCocheService;

@Controller
@RequestMapping("/coches")
@RequiredArgsConstructor
public class CocheController {

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

    return """
        <!DOCTYPE html>
        <html lang="es">
          <head>
            <meta charset="UTF-8">
            <title>Coche</title>
          </head>
          <body>
            <h1>Coche: %s</h1>
            <p>Marca: %s</p>
            <p>Modelo: %s</p>
            <p>Precio: %s</p>
            <p>Creado el: %s</p>
          </body>
        </html>
        """.formatted(
        coche.getId(),
        HtmlUtils.htmlEscape(coche.getMarca()),
        HtmlUtils.htmlEscape(coche.getModelo()),
        coche.getPrecio(),
        coche.getCreatedAt());
  }

  @GetMapping
  @ResponseBody
  public List<CocheResponse> allCoche() {
    return findCocheService.findAll()
        .stream()
        .map(cocheMapper::toResponse)
        .toList();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCoche(@PathVariable int id) {
    deleteCocheService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  @ResponseBody
  public CocheResponse editCoche(@PathVariable int id, @Valid CocheRequest cocheRequest) {
    EditCocheCommand comando = cocheMapper.toCommand(id, cocheRequest);
    Coche coche = editCocheService.update(comando);
    return cocheMapper.toResponse(coche);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public String handleValidationExceptions(MethodArgumentNotValidException ex) {

    StringBuilder html = new StringBuilder(256);
    html.append("<!DOCTYPE html>")
        .append("<html lang=\"es\"><head><meta charset=\"UTF-8\">")
        .append("<title>Errores de validación</title></head><body>")
        .append("<h1>Errores de validación</h1>")
        .append("<ul>");

    ex.getBindingResult().getAllErrors().forEach(error -> {
      String field = (error instanceof FieldError fe) ? fe.getField() : error.getObjectName();
      String message = error.getDefaultMessage();

      html.append("<li><strong>")
          .append(HtmlUtils.htmlEscape(field))
          .append("</strong>: ")
          .append(HtmlUtils.htmlEscape(message))
          .append("</li>");
    });

    html.append("</ul></body></html>");
    return html.toString();
  }
}