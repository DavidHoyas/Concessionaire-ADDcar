package es.etg.daw.dawes.addcar.common.infraestructure.web.error;

import java.time.LocalDateTime;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.HtmlUtils;

import es.etg.daw.dawes.addcar.coche.domain.error.CocheInvalidoException;
import es.etg.daw.dawes.addcar.coche.domain.error.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return buildResponse(HttpStatus.NOT_FOUND, "Recurso no encontrado", ex.getMessage());
    }

    @ExceptionHandler(CocheInvalidoException.class)
    public ResponseEntity<String> handleCocheInvalido(CocheInvalidoException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Operación no válida", ex.getMessage());
    }

    private ResponseEntity<String> buildResponse(HttpStatus status, String titulo, String mensaje) {
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), status, mensaje);

        return ResponseEntity
                .status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML)
                .body(buildErrorHtml(cr, titulo));
    }

    private String buildErrorHtml(CustomResponse cr, String titulo) {
        return """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>%s</title>
                </head>
                <body>
                    <div class="card">
                        <h1>Se ha producido un error</h1>
                        <dl>
                            <dt>Fecha</dt>
                            <dd>%s</dd>
                            <dt>Código</dt>
                            <dd>%s - %s</dd>
                            <dt>Mensaje</dt>
                            <dd>%s</dd>
                        </dl>
                    </div>
                </body>
                </html>
                """.formatted(
                HtmlUtils.htmlEscape(titulo),
                HtmlUtils.htmlEscape(String.valueOf(cr.getDate())),
                cr.getStatus().value(),
                HtmlUtils.htmlEscape(cr.getStatus().getReasonPhrase()),
                HtmlUtils.htmlEscape(cr.getMessage()));
    }
}
