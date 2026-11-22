![Banner](doc/img/banner.jpg)

# ADDcar - Gestión de un concesionario de coches

- **Versión:** 2.0.1
- **Integrantes del equipo:**
  - David Hoyas Navarro
  - Aaron Gómez Ventero
  - David Oliva Huelamo

---

## Descripción

ADDcar es una aplicación web hecha con Spring Boot para gestionar el catálogo de un concesionario. Permite listar, crear, modificar y eliminar coches, calcula automáticamente su etiqueta ambiental y valida que los datos sean coherentes.

---

## Tecnologías Utilizadas

- **Java:** lenguaje principal (JDK 21, compilado con nivel 17).
- **Spring Boot:** framework de la aplicación web (4.2.0).
- **Maven:** gestión de dependencias y compilación.
- **Lombok:** reduce el código repetitivo.
- **MapStruct:** mapeo entre DTOs, comandos y respuestas.
- **Bean Validation:** validación de los datos de entrada.
- **HTML:** formularios para probar las operaciones.
- **Mock Repository:** almacenamiento en memoria.

---

## Cómo arrancar

Ejecutar la clase: **[ADDcarApplication.java.](./src/main/java/es/etg/daw/dawes/addcar/ADDcarApplication.java)** y abrir http://localhost:8080/FormularioListar.html

---

## Documentación

Toda la documentación está en la carpeta [`doc/`](./doc/):

1. [Contexto](doc/01-contexto.md)
2. [Diseño](doc/02-diseno.md)
3. [Implementación](doc/03-implementacion.md)
4. [Pruebas y capturas](doc/04-pruebas-y-capturas.md)
5. [Elementos destacables](doc/05-elementos-destacables.md)
6. [Manual de usuario](doc/06-manual-usuario.md)
7. [Conclusiones](doc/07-conclusiones.md)
8. [Bibliografía y anexos](doc/08-bibliografia-y-anexos.md)
