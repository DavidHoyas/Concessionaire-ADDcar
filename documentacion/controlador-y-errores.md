# Controlador, Formularios y Errores

## `CocheController` y Formularios HTML

- **Endpoints REST/MVC (`/coches`):**

  - `POST /coches`: registra un nuevo vehículo y devuelve una ficha HTML construida mediante el método auxiliar `fila(etiqueta, valor)`.

  - `GET /coches`: devuelve la lista completa de vehículos mapeados a `CocheResponse`.

  - `PUT /coches/{id}`: actualiza los datos de un vehículo existente y devuelve su `CocheResponse`.

  - `DELETE /coches/{id}`: elimina el vehículo indicado y devuelve `204 No Content`.

- **Soporte de Métodos HTTP en Formularios:** En `application.properties` se habilita `spring.mvc.hiddenmethod.filter.enabled=true` para procesar peticiones `PUT` y `DELETE` enviadas mediante `_method` desde formularios HTML.

- **Vistas Estáticas (`src/main/resources/static/`):** Los formularios de gestión incorporan todos los atributos del vehículo, limitan el año máximo al año en curso y, al seleccionar `ELECTRICO`, fijan automáticamente la transmisión en automática y la cilindrada en `0`.

## Manejo Global de Excepciones y Seguridad

- **Excepciones de Dominio:** `EntityNotFoundException` y `CocheNotFoundException` representan los errores cuando no se encuentra un recurso o el catálogo está vacío.

- **Manejador Global (`GlobalExceptionHandler`):** Anotado con `@ControllerAdvice` en el paquete `common`, captura `EntityNotFoundException`, construye un objeto `CustomResponse` y devuelve una página HTML con estado `HttpStatus.NOT_FOUND`.

- **Prevención XSS y Buenas Prácticas:** Tanto `CocheController` (en la generación de fichas HTML y en `@ExceptionHandler(MethodArgumentNotValidException.class)`) como `GlobalExceptionHandler` escapan los valores dinámicos con `HtmlUtils.htmlEscape`, y todas las etiquetas, rutas y límites se definen mediante constantes.