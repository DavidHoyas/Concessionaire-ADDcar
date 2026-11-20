# Cambios realizados en el módulo Coche

Estos son los cambios que he hecho en el módulo `coche` de la práctica AddCar después de revisar el código. Al final están los cambios posteriores, con los que he ampliado el objeto `Coche` para convertir la práctica en un concesionario de coches nuevos.

## Controller

- He corregido la respuesta de `createCoche`. Mostraba "Tipo" para el modelo y las etiquetas no coincidían con los valores. Ahora muestra cada dato con su etiqueta correcta.
- He escapado los datos con `HtmlUtils.htmlEscape` en esa respuesta, para evitar que alguien pueda meter HTML o JavaScript (XSS).
- He cambiado el controller para que use los `Service` (`CreateCocheService`, `DeleteCocheService`, `FindCocheService` y `EditCocheService`) en vez de llamar directamente a los use cases. Así el flujo queda Controller → Service → UseCase → Repository.
- `deleteCoche` ahora devuelve `ResponseEntity<Void>` en vez de `ResponseEntity<?>`.

## Servicios

- En `CreateCocheService` he quitado la variable intermedia y ahora devuelve directamente el resultado del use case.

## Repositorio y datos demo

- En `CocheFactory` estaban cambiados la marca y el modelo, así que he puesto cada uno en su sitio.
- He eliminado `getByName` de `CocheRepository` y de `CocheRepositoryMockImpl`, porque no se usaba y lanzaba `UnsupportedOperationException`.
- He simplificado `obtenerSiguienteId` para que calcule el id máximo con un stream en vez de recorrer la lista a mano.

## Validaciones

- En `CocheRequest` he cambiado el `@Max` del precio de 100 a 1000000, porque 100 € no es realista para un coche. Hay que actualizar el mensaje `coche.valid.precio.max` en `messages.properties` si mencionaba el 100.
- He eliminado la anotación `@NombradoCoche` y su validador. Ahora el modelo solo debe no estar vacío, así que se admiten modelos con espacios, como "Model 3".

## Gestión de errores

- En `GlobalExceptionHandler` he borrado el método `escapeHtml` propio y uso `HtmlUtils.htmlEscape` de Spring, igual que en el controller.
- En `CustomResponse` he cambiado `@Data` por `@Getter`, ya que los campos son `final` y no hacen falta setters ni el resto de lo que genera `@Data`.

## Configuración

- He añadido `spring.mvc.hiddenmethod.filter.enabled=true` en `application.properties` para que los formularios de editar y eliminar, que mandan `_method=PUT` y `_method=DELETE`, funcionen.

## Paquetes

- He corregido las erratas en los nombres de los paquetes del módulo `coche`: `infraestructure` pasa a `infrastructure` y `usercase` pasa a `usecase`, con todos los imports actualizados.

## Campos del Coche

Para convertir la práctica en un concesionario de coches nuevos, el `Coche` pasa a tener estos campos: `marca`, `modelo`, `foto`, `precio`, `anio`, `combustion`, `transmision`, `traccion`, `tipoCarroceria`, `color`, `cilindrada`, `cv` y `stock`.

- Los campos con valores cerrados son enums del dominio: `Combustion`, `Transmision`, `Traccion` y `TipoCarroceria`.
- La cilindrada se guarda en litros (1.0, 1.8, 2.0...) y vale 0 en los eléctricos.
- No se guardan kilómetros ni estado, porque todos los coches son nuevos, y tampoco puertas ni plazas, porque se deducen del tipo de carrocería.
- Ya no se guarda ni se muestra la fecha de creación (`createdAt`).
- Los cambios se han propagado por `Coche`, `CocheRequest`, `CocheResponse`, los dos commands (`CreateCocheCommand` y `EditCocheCommand`), los use cases, el mapper y los datos demo de `CocheFactory`.

## Etiqueta ambiental

La etiqueta ambiental no se guarda ni se pide en el formulario. Se calcula en `Coche.getEtiquetaAmbiental()` a partir de la combustión y del año, para que nunca pueda quedar incoherente con ellos. Aparece en `CocheResponse` y en la página que se muestra al crear un coche. Los criterios son:

- Eléctrico: CERO.
- Híbrido, GLP y GNC: ECO desde 2006. Si son anteriores, se tratan como gasolina.
- Gasolina: C desde 2006, B desde 2000 y sin etiqueta antes.
- Diésel: C desde 2015, B desde 2005 y sin etiqueta antes.

Es una simplificación de los criterios de la DGT, que en realidad dependen de la norma Euro y de la fecha exacta de matriculación.

## Validaciones de los campos nuevos

En `CocheRequest` cada campo lleva sus anotaciones, y los textos de error están en `messages.properties`:

- `marca`, `modelo` y `color`: no pueden estar vacíos.
- `foto`: opcional, pero si se rellena debe ser una URL que empiece por http o https.
- `anio`: mínimo 1900.
- `combustion`, `transmision`, `traccion` y `tipoCarroceria`: obligatorios.
- `cilindrada`: entre 0 y 8 litros.
- `cv`: entre 1 y 2000.
- `stock`: no puede ser negativo.

## Validaciones entre campos

He creado la anotación `@CocheCoherente` con su validador `CocheCoherenteValidator`, que se aplica sobre todo el `CocheRequest` y comprueba:

- Que un coche eléctrico sea automático y tenga cilindrada 0.
- Que un coche no eléctrico tenga cilindrada mayor que 0.
- Que en gasolina, diésel, GLP y GNC la potencia no pase de 250 CV por litro de cilindrada. Los híbridos quedan fuera porque suman la potencia del motor eléctrico.
- Que el año no sea futuro, usando `Year.now()`.

Cada error se asocia al campo concreto, así que el manejador de errores de validación del controller lo muestra con el nombre del campo. Los textos de estos errores están como constantes dentro del propio validador.

## Controller y formularios

- La respuesta de `createCoche` genera cada línea con un método auxiliar `fila(etiqueta, valor)`, que escapa el valor. Así no hay que mantener el orden de una lista larga de `%s`, que fue el origen del fallo original.
- Los formularios de crear y editar incluyen todos los campos nuevos. Los enums son `<select>` para que el valor coincida con el nombre del enum.
- Un pequeño script en los formularios hace que, al elegir eléctrico, la transmisión pase a automática (sin poder elegir manual) y la cilindrada a 0. También limita el año máximo al año actual. Es solo una ayuda, la validación real está en el servidor.

## Eliminación de literales

He sustituido los textos y números escritos directamente en el código por constantes:

- `CocheController`: las etiquetas de cada fila, las plantillas HTML, la ruta base `/coches` y la ruta `/{id}`.
- `GlobalExceptionHandler`: la plantilla HTML de error y sus textos.
- `CocheMapper`: los nombres de los campos que se usan en las anotaciones `@Mapping`.
- `Coche`: los años que determinan cada etiqueta ambiental.
- `CocheRequest`: las claves de los mensajes, la expresión regular de la URL y los límites numéricos de cada validación.
- `CocheCoherenteValidator`: los nombres de los campos, los mensajes de error y el máximo de CV por litro.
- `CocheRepositoryMockImpl`: los valores 0 y 1 al calcular el siguiente id.
- `EntityNotFoundException` y `CocheNotFoundException`: los formatos de los mensajes y el nombre de la entidad.
- `CocheFactory`: cada dato de los coches de demostración.
