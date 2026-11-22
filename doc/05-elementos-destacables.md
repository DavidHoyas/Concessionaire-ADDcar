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
| Los formularios HTML solo envían GET y POST, no DELETE | Filtro de métodos ocultos de Spring (`_method=DELETE`) |
| Las anotaciones normales no validan campos entre sí | Anotación y validador propios `@CocheCoherente` |
| MapStruct necesitaba el `id` y el formulario a la vez | Método `toCommand(id, request)` con `@Mapping` |

---

[README](../README.md) | [Volver](04-pruebas-y-capturas.md) | [Siguiente: 06-manual-usuario.md](06-manual-usuario.md)
