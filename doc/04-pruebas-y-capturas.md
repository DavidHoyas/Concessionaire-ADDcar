# 4. Pruebas y capturas

Resultado de ejecutar el [plan de pruebas](02-diseno.md#plan-de-pruebas). Las capturas se guardan en `doc/img/`.

---

## Ejecución de las pruebas

| ID | Resultado esperado | Resultado obtenido | OK/KO | Captura |
|---|---|---|---|---|
| P01 | 200 y 3 coches | 200 y JSON con los 3 coches (etiquetas C, CERO y B) | OK | ![Listar coches](img/p01-listar.png) |
| P02 | Ficha con etiqueta C | Ficha del coche creado con etiqueta C | OK | ![Crear coche](img/p02-crear-ok.png) |
| P03 | Error 400 (cilindrada) | Error 400 con el mensaje "Si no es eléctrico, la cilindrada debe ser mayor que 0" | OK | ![Cilindrada 0](img/p03-cilindrada-cero.png) |
| P04 | Error 400 (potencia excesiva) | Error 400 con el mensaje "La potencia es demasiado alta para esa cilindrada (máximo 250 CV por litro)" | OK | ![Potencia excesiva](img/p04-potencia-excesiva.png) |
| P05 | Etiqueta ECO | Ficha del coche creado con etiqueta ambiental ECO | OK | ![Etiqueta ECO](img/p05-etiqueta-eco.png) |
| P06 | Coche actualizado | Coche 1 con precio 28000, año 2023, 2.0 L, 150 CV y stock 3 | OK | ![Editar coche](img/p06-editar-ok.png) |
| P07 | Error 404 | Error 404 con el mensaje "Coche con id 99 no se encuentra" | OK | ![Error 404](img/p07-no-encontrado.png) |
| P08 | 204 y coche eliminado | El formulario no muestra contenido (204) y en el listado el coche 2 ya no aparece | OK | ![Listado tras eliminar](img/p08-eliminar-ok.png) |

---

## Funcionamiento de la aplicación

---

### Listar coches (GET)

Formulario para consultar el catálogo y resultado con los tres coches:

![Formulario de listado](img/formulario-listar.png)
![Resultado del listado](img/p01-listar.png)

---

### Crear coche (POST)

Formulario de creación.

![Formulario de creación](img/formulario-crear.png)
![Coche creado](img/p02-crear-ok.png)

---

### Modificar coche (PUT)

Formulario de edición con el id del coche y resultado con los datos actualizados:

![Formulario de edición](img/formulario-editar.png)
![Coche editado](img/p06-editar-ok.png)

---

### Eliminar coche (DELETE)

Formulario de eliminación con el id del coche y listado posterior, donde ya no aparece:

![Formulario de eliminación](img/formulario-eliminar.png)
![Listado tras eliminar](img/p08-eliminar-ok.png)

---

[README](../README.md) | [Volver](03-implementacion.md) | [Siguiente: 05-elementos-destacables.md](05-elementos-destacables.md)