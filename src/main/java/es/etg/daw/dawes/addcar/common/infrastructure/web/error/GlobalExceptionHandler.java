package es.etg.daw.dawes.addcar.common.infrastructure.web.error;

import java.time.LocalDateTime;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.HtmlUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import es.etg.daw.dawes.addcar.coche.domain.error.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String HTML_LANG_ES = "es";
    private static final String TITULO_ERROR = "Recurso no encontrado";
    private static final String ENCABEZADO_ERROR = "Se ha producido un error";
    private static final String ETIQUETA_FECHA = "Fecha";
    private static final String ETIQUETA_CODIGO = "Código";
    private static final String ETIQUETA_MENSAJE = "Mensaje";

    private static final String HTML_PLANTILLA_ERROR = """
            <!DOCTYPE html>
            <html lang="%s">
            <head>
                <meta charset="UTF-8">
                <title>%s</title>
            </head>
            <body>
                <div class="card">
                    <h1>%s</h1>
                    <dl>
                        <dt>%s</dt>
                        <dd>%s</dd>
                        <dt>%s</dt>
                        <dd>%s - %s</dd>
                        <dt>%s</dt>
                        <dd>%s</dd>
                    </dl>
                </div>
            </body>
            </html>
            """;

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
        return HTML_PLANTILLA_ERROR.formatted(
                HTML_LANG_ES,
                TITULO_ERROR,
                ENCABEZADO_ERROR,
                ETIQUETA_FECHA,
                HtmlUtils.htmlEscape(String.valueOf(cr.getDate())),
                ETIQUETA_CODIGO,
                cr.getStatus().value(),
                HtmlUtils.htmlEscape(cr.getStatus().getReasonPhrase()),
                ETIQUETA_MENSAJE,
                HtmlUtils.htmlEscape(cr.getMessage()));
    }
}