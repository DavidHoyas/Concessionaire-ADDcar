package es.etg.daw.dawes.addcar.common.infrastructure.web.error;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.util.HtmlUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import es.etg.daw.dawes.addcar.coche.domain.error.EntityNotFoundException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String HTML_LANG_ES = "es";
    private static final String TITULO_NO_ENCONTRADO = "Recurso no encontrado";
    private static final String TITULO_PETICION_INVALIDA = "Petición no válida";
    private static final String TITULO_INESPERADO = "Error inesperado";
    private static final String ENCABEZADO_ERROR = "Se ha producido un error";
    private static final String MENSAJE_VALOR_INVALIDO = "Alguno de los valores enviados no tiene un formato válido";
    private static final String MENSAJE_INESPERADO = "Se ha producido un error inesperado. Inténtelo de nuevo más tarde.";
    private static final String LOG_INESPERADO = "Error inesperado";
    private static final String ETIQUETA_FECHA = "Fecha";
    private static final String ETIQUETA_CODIGO = "Código";
    private static final String ETIQUETA_MENSAJE = "Mensaje";

    private static final int CAPACIDAD_INICIAL_BUILDER = 256;
    private static final String HTML_DOCTYPE = "<!DOCTYPE html>";
    private static final String HTML_HEAD_META = "<html lang=\"%s\"><head><meta charset=\"UTF-8\">";
    private static final String HTML_TITULO_VALIDACION = "<title>Errores de validación</title></head><body>";
    private static final String HTML_H1_VALIDACION = "<h1>Errores de validación</h1>";
    private static final String HTML_INICIO_LISTA = "<ul>";
    private static final String HTML_ITEM_LISTA = "<li><strong>%s</strong>: %s</li>";
    private static final String HTML_FIN_LISTA = "</ul></body></html>";

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
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, ex.getMessage());

        return respuestaHtml(cr.getStatus(), buildErrorHtml(cr, TITULO_NO_ENCONTRADO));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex) {
        StringBuilder html = new StringBuilder(CAPACIDAD_INICIAL_BUILDER);
        html.append(HTML_DOCTYPE)
                .append(HTML_HEAD_META.formatted(HTML_LANG_ES))
                .append(HTML_TITULO_VALIDACION)
                .append(HTML_H1_VALIDACION)
                .append(HTML_INICIO_LISTA);

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = (error instanceof FieldError fe) ? fe.getField() : error.getObjectName();
            String message = error.getDefaultMessage();

            html.append(HTML_ITEM_LISTA.formatted(
                    HtmlUtils.htmlEscape(field),
                    HtmlUtils.htmlEscape(String.valueOf(message))));
        });

        html.append(HTML_FIN_LISTA);
        return respuestaHtml(HttpStatus.BAD_REQUEST, html.toString());
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(TypeMismatchException ex) {
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, MENSAJE_VALOR_INVALIDO);

        return respuestaHtml(cr.getStatus(), buildErrorHtml(cr, TITULO_PETICION_INVALIDA));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpected(Exception ex) {
        HttpStatus status = (ex instanceof ErrorResponse er)
                ? HttpStatus.valueOf(er.getStatusCode().value())
                : HttpStatus.INTERNAL_SERVER_ERROR;

        boolean inesperado = status == HttpStatus.INTERNAL_SERVER_ERROR;
        if (inesperado)
            log.error(LOG_INESPERADO, ex);

        String titulo = inesperado ? TITULO_INESPERADO : status.getReasonPhrase();
        String mensaje = inesperado ? MENSAJE_INESPERADO : status.getReasonPhrase();
        CustomResponse cr = new CustomResponse(LocalDateTime.now(), status, mensaje);

        return respuestaHtml(status, buildErrorHtml(cr, titulo));
    }

    private ResponseEntity<String> respuestaHtml(HttpStatus status, String html) {
        return ResponseEntity
                .status(status)
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }

    private String buildErrorHtml(CustomResponse cr, String titulo) {
        return HTML_PLANTILLA_ERROR.formatted(
                HTML_LANG_ES,
                HtmlUtils.htmlEscape(titulo),
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