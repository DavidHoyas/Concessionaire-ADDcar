package es.etg.daw.dawes.addcar.common.infraestructure.web.error;

import java.time.LocalDateTime;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.HtmlUtils;

import es.etg.daw.dawes.addcar.coche.domain.error.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        String msg = ex.getMessage();
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, msg);

        String html = buildErrorHtml(cr);

        return ResponseEntity
                .status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }

    private String buildErrorHtml(CustomResponse cr) {
        return """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>Recurso no encontrado</title>
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
                HtmlUtils.htmlEscape(String.valueOf(cr.getDate())),
                cr.getStatus().value(),
                HtmlUtils.htmlEscape(cr.getStatus().getReasonPhrase()),
                HtmlUtils.htmlEscape(cr.getMessage()));
    }
}