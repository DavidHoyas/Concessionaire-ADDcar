# Validaciones y Coherencia

## Validación de Campos (`CocheRequest` y `messages.properties`)

Los datos de entrada se validan mediante anotaciones de Bean Validation en `CocheRequest`, con mensajes centralizados en `src/main/resources/messages.properties`:

- `marca`, `modelo` y `color` (`@NotBlank`): campos obligatorios y no vacíos (permitiendo nombres compuestos o con espacios como `"Model 3"`).

- `foto` (`@URL`): formato `http`/`https`.

- `precio`: rango permitido entre `0` y `1000000` (actualizado desde el límite anterior de `100`).

- `anio`: valor mínimo `1900`.

- `combustion`, `transmision`, `traccion` y `tipoCarroceria` (`@NotNull`): campos obligatorios.

- `cilindrada`: rango entre `0` y `8` litros; 

- `cv`: rango entre `1` y `2000`; 

- `stock`: valor mínimo `0`.

## Validación entre Campos (`@CocheCoherente`)

`CocheCoherenteValidator` valida el objeto `CocheRequest` completo y asocia cada error al campo correspondiente:

- Si `combustion == ELECTRICO`: no permite transmisión `MANUAL` y exige `cilindrada == 0`.

- Si `combustion != null` y no es `ELECTRICO`: exige `cilindrada > 0` y, si no es `HIBRIDO`, comprueba que `cv <= cilindrada * 250`.

- Comprueba que `anio <= Year.now().getValue()`.