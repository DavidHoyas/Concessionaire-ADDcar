# 6. Manual de usuario

---

## Arrancar

Ejecutar la clase: **[ADDcarApplication.java.](../src/main/java/es/etg/daw/dawes/addcar/ADDcarApplication.java)** y abre el navegador en `http://localhost:8080`. Al arrancar hay 3 coches de ejemplo; los cambios se pierden al cerrar la aplicación.

---

## Qué puedes hacer

| Acción | Dirección | Qué hacer |
|---|---|---|
| Ver coches | http://localhost:8080/FormularioListar.html | Pulsar **Listar Coches** |
| Crear coche | http://localhost:8080/FormularioCrear.html | Rellenar todos los campos y pulsar **Crear Coche** |
| Modificar coche | http://localhost:8080/FormularioEditar.html | Indicar el ID y rellenar todos los campos |
| Eliminar coche | http://localhost:8080/FormularioEliminar.html | Indicar el ID y pulsar **Eliminar Coche** |

---

## Datos de ejemplo

### Listado de Coches (`GET`)

- **Función:** Consulta todos los coches disponibles en el catálogo.

**Ejemplo de salida JSON:**

```json
{
  "id": 1,
  "marca": "Toyota",
  "modelo": "Corolla",
  "foto": "https://www.tou.gal/wp-content/uploads/2023/08/corolla-active-rojo-0675lrb-1-.jpg",
  "precio": 24900.0,
  "anio": 2021,
  "combustion": "GASOLINA",
  "transmision": "AUTOMATICA",
  "traccion": "DELANTERA",
  "tipoCarroceria": "COMPACTO",
  "color": "Rojo",
  "cilindrada": 1.8,
  "cv": 140,
  "stock": 5,
  "etiquetaAmbiental": "C"
}
```

### Crear un Coche (`POST`)

- **Función:** Registra un nuevo coche en el inventario mediante el formulario HTML (`POST /coches`) y devuelve la ficha HTML del coche creado.

**Ejemplo:**

```json
{
  "marca": "Volkswagen",
  "modelo": "Golf",
  "foto": "https://ejemplo.com/golf.jpg",
  "precio": 26900.0,
  "anio": 2024,
  "combustion": "GASOLINA",
  "transmision": "MANUAL",
  "traccion": "DELANTERA",
  "tipoCarroceria": "COMPACTO",
  "color": "Azul",
  "cilindrada": 1.5,
  "cv": 150,
  "stock": 4
}
```

### Modificar un Coche (`PUT`)

- **Función:** Actualiza los datos de un coche existente por su ID.

**Ejemplo:**

```json
{
  "id": 1,
  "marca": "Toyota",
  "modelo": "Corolla",
  "foto": "https://www.tou.gal/wp-content/uploads/2023/08/corolla-active-rojo-0675lrb-1-.jpg",
  "precio": 23900.0,
  "anio": 2021,
  "combustion": "GASOLINA",
  "transmision": "AUTOMATICA",
  "traccion": "DELANTERA",
  "tipoCarroceria": "COMPACTO",
  "color": "Rojo",
  "cilindrada": 1.8,
  "cv": 140,
  "stock": 6
}
```

### Eliminar un Coche (`DELETE`)

- **Función:** Borra un coche del catálogo por su ID mediante `DELETE /coches/{id}`. El formulario utiliza `_method=DELETE` para enviar la petición.

**Ejemplo ilustrativo:**

```json
{
  "id": 2,
  "status": 204,
  "eliminado": true
}
```

---

## Reglas al rellenar el formulario

- Precio entre 0 y 1.000.000; año entre 1900 y el año actual.
- Cilindrada entre 0 y 8 litros; potencia entre 1 y 2000 CV.
- La foto debe ser una URL que empiece por `http://` o `https://`.
- Un coche eléctrico solo puede ser automático y su cilindrada debe ser 0.
- Un coche no eléctrico debe tener cilindrada mayor que 0.

---

## Errores

- **Error 400:** algún dato es incorrecto. Se muestra una lista con los campos a corregir.
- **Error 404:** el coche con ese ID no existe (o no queda ninguno en el catálogo).
- Al eliminar un coche la página sale vacía (código 204): es lo normal; comprueba el resultado en el listado.

---

[README](../README.md) | [Volver](05-elementos-destacables.md) | [Siguiente: 07-conclusiones.md](07-conclusiones.md)
