# 2. Diseño

---

## Arquitectura

Usamos **Vertical Slicing** (módulos por funcionalidad) junto con **Clean Architecture** (capas, con las dependencias apuntando hacia el dominio). El flujo de una petición es:

```text
Controller --> Service --> UseCase --> Repository
```

---

## Niveles de abstracción

| Nivel | Elementos |
|---|---|
| Módulos | `coche` (catálogo) y `common` (gestión global de errores) |
| Capas | `domain`, `application`, `infrastructure` |

| Capa | Contenido |
|---|---|
| `domain` | `Coche`, enums (`Combustion`, `Transmision`, `Traccion`, `TipoCarroceria`, `EtiquetaAmbiental`), excepciones y repositorios (interfaces) |
| `application` | Comandos, casos de uso y servicios (crear, buscar, editar, eliminar) |
| `infrastructure` | `CocheController`, DTOs (`CocheRequest`, `CocheResponse`), `CocheMapper`, validación `@CocheCoherente`, repositorio en memoria y `CocheConfig` |

---

## Gestión de errores y excepciones

| Situación | Excepción | Código | Dónde se captura |
|---|---|---|---|
| El coche no existe / no hay coches | `CocheNotFoundException` | 404 | `GlobalExceptionHandler` |
| Un campo no es válido | `MethodArgumentNotValidException` | 400 | `CocheController` |
| Datos incoherentes (`@CocheCoherente`) | `MethodArgumentNotValidException` | 400 | `CocheController` |

---

## Plan de pruebas

Las pruebas son **manuales**: ejecutamos la aplicación, probamos cada funcionalidad con datos correctos e incorrectos y comprobamos que el resultado es el esperado.

| ID | Prueba | Entrada | Resultado esperado |
|---|---|---|---|
| P01 | Listar coches | `GET /coches` | 200 y los 3 coches de demostración |
| P02 | Crear coche válido | Golf 2024, gasolina, 1.5 L, 150 CV | Ficha del coche con etiqueta C |
| P03 | Coche de gasolina sin cilindrada | Gasolina + cilindrada 0 | Error 400 con mensaje |
| P04 | Potencia excesiva | Gasolina, 1.0 L y 400 CV | Error 400 con mensaje |
| P05 | Etiqueta ambiental | Híbrido de 2020 | Ficha con etiqueta ECO |
| P06 | Editar coche existente | Editar el coche con id 1 | Coche actualizado |
| P07 | Coche inexistente | Eliminar el id 99 | Error 404 |
| P08 | Eliminar coche existente | Eliminar el coche con id 2 | 204 (sin contenido) y el coche desaparece del listado |

---

[README](../README.md) | [Volver](01-contexto.md) | [Siguiente: 03-implementacion.md](03-implementacion.md)
