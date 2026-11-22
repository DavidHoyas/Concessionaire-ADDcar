# 1. Contexto de la aplicación

---

## Nombre, versión e integrantes

- **Aplicación:** ADDcar
- **Versión:** 2.0
- **Integrantes del equipo:**
  - David Hoyas Navarro
  - Aaron Gómez Ventero
  - David Oliva Huelamo

---

## Mundo real del problema

Un concesionario tiene que controlar su catálogo de coches (marca, modelo, precio, stock...). Si lo hace en papel o en Excel es fácil que haya errores y datos que no tienen sentido, como un coche eléctrico con caja manual.

## Qué aplicaciones existen

- **Coches.net y AutoScout24:** portales para publicar y buscar anuncios, pero no sirven para gestionar el inventario interno.
- **Software de gestión de concesionarios (DMS):** muy completo, pero complejo y caro para un concesionario pequeño.

## Qué aporta ADDcar

- Calcula **automáticamente la etiqueta ambiental** (CERO, ECO, C, B, SIN_ETIQUETA).
- **Valida la coherencia** de los datos (eléctrico solo automático, sin cilindrada, año no futuro, límite de CV por litro).
- Es sencilla de usar mediante formularios y muestra errores claros en español.

---

## Casos de uso

Actor (externo a la aplicación): **Empleado del concesionario**.

| Caso de uso | Descripción | Flujo alternativo |
|---|---|---|
| CU1 Listar coches | El empleado consulta el catálogo | No hay coches → error 404 |
| CU2 Crear coche | Rellena el formulario y se guarda el coche | Datos inválidos → error 400 |
| CU3 Editar coche | Modifica los datos de un coche por su ID | ID no existe → 404; datos inválidos → 400 |
| CU4 Eliminar coche | Borra un coche por su ID | ID no existe → 404 |

---

## Requisitos

**Funcionales**
- RF1: El sistema permite listar los coches.
- RF2: El sistema permite crear un coche.
- RF3: El sistema permite modificar un coche existente.
- RF4: El sistema permite eliminar un coche.
- RF5: El sistema calcula la etiqueta ambiental de cada coche.
- RF6: El sistema rechaza datos inválidos o incoherentes.

**No funcionales**
- RNF1: Arquitectura por capas (Clean Architecture).
- RNF2: Los datos se guardan en memoria (se pierden al reiniciar).
- RNF3: Mensajes de error en español.
- RNF4: Los datos mostrados en HTML se escapan para evitar XSS.

---

[README](../README.md) | [Siguiente: 02-diseno.md](02-diseno.md)
