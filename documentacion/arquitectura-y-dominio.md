# Arquitectura, Servicios y Dominio

## Flujo de Aplicación

El módulo `coche` sigue Clean Architecture y Vertical Slicing con el flujo:

`CocheController` --> `*Service` --> `*UseCase` --> `CocheRepository`

- Los servicios (`CreateCocheService`, `FindCocheService`, `EditCocheService`, `DeleteCocheService`) encapsulan la llamada a los casos de uso correspondientes (`CreateCocheService` devuelve directamente el resultado del caso de uso sin variable intermedia).

- Los casos de uso operan con `CreateCocheCommand` y `EditCocheCommand` y lanzan `CocheNotFoundException` cuando no existe el coche o el catálogo está vacío al listar.

## Modelo `Coche` y Etiqueta Ambiental

El modelo de dominio representa coches nuevos con los campos `marca`, `modelo`, `foto`, `precio`, `anio`, `combustion`, `transmision`, `traccion`, `tipoCarroceria`, `color`, `cilindrada`, `cv` y `stock` (sin `createdAt` ni datos de vehículo usado o deducibles como plazas/puertas).

La etiqueta ambiental se calcula en `Coche.getEtiquetaAmbiental()` a partir de `combustion` y `anio`:

- `ELECTRICO` → `CERO`.

- `HIBRIDO`, `GLP` o `GNC` → `ECO` si `anio >= 2006`; en caso contrario se evalúa según el criterio de gasolina.

- `GASOLINA` → `C` desde `2006`, `B` desde `2000` y `SIN_ETIQUETA` si es anterior.

- `DIESEL` → `C` desde `2015`, `B` desde `2005` y `SIN_ETIQUETA` si es anterior.
