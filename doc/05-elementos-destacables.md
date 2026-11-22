# 5. Elementos destacables

---

## Cosas desarrolladas

- **Validación propia `@CocheCoherente`:** comprueba reglas que dependen de varios campos a la vez (eléctrico solo automático, cilindrada, CV por litro, año no futuro) y marca el campo concreto que falla.

- **Etiqueta ambiental en el dominio:** `Coche` la calcula con un `switch` según la combustión y el año.

- **Mensajes externalizados:** los textos de validación están en `messages.properties`.

- **Formularios que se adaptan:** al elegir "Eléctrico" se bloquea la transmisión manual y la cilindrada pasa a 0.

- **Protección XSS:** los datos mostrados en HTML se escapan con `HtmlUtils.htmlEscape`.

---

## Problemas encontrados

| Problema | Solución |
|---|---|
| Algunas pruebas de error (eléctrico con transmisión manual, año futuro) no se podían hacer desde la web, porque el formulario ya las bloqueaba en el navegador | Se probaron otros errores que sí llegan al servidor (cilindrada 0, potencia excesiva). El servidor sigue validando todo, por si se salta el formulario |
| La gestión del error 400 estaba en el controlador y no en un punto común | Se movió a `GlobalExceptionHandler` (`@ControllerAdvice`) junto al 404 y al 500 |
| Al añadir un manejador genérico de `Exception`, los errores propios de Spring (una dirección inexistente, un método no permitido) salían como 500 | El manejador comprueba si la excepción es un `ErrorResponse` y conserva su código original |
| Una dirección con un ID no numérico (por ejemplo `/coches/abc`) devolvía 500 en lugar de 400 | Manejador específico para `TypeMismatchException` que devuelve 400 |

---

[README](../README.md) | [Volver](04-pruebas-y-capturas.md) | [Siguiente: 06-manual-usuario.md](06-manual-usuario.md)
