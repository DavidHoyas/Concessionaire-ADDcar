# 7. Conclusiones

---

## David Hoyas Navarro

Con este proyecto he aprendido a organizar una aplicación en capas (domain, application e infrastructure) y a separar la lógica de negocio de la parte web. Al principio me costó entender por qué hacían falta servicios y casos de uso si el controlador podía llamar directamente al repositorio, pero al ver que el repositorio en memoria se puede cambiar sin tocar el resto, le encontré sentido. También entendí por qué los casos de uso se registran en `CocheConfig`. Si tuviera más tiempo, sustituiría el repositorio en memoria por una base de datos real. Estoy contento con el resultado, y trabajar en equipo con Git me ha enseñado a coordinarnos para no pisarnos el trabajo.

## Aaron Gómez Ventero

Lo que más me ha enseñado este proyecto es la validación de datos y la gestión de errores. Las anotaciones normales no servían para comprobar reglas entre varios campos, como que un coche eléctrico no puede tener cilindrada, así que creamos la validación propia `@CocheCoherente` y conseguimos que el error indique el campo concreto. También aprendí a centralizar las excepciones con `@ControllerAdvice` para devolver un 404, un 400 y un 500 desde un único sitio y sin enseñar detalles internos. Lo mejoraría añadiendo pruebas automáticas con JUnit, porque ahora todas las pruebas son manuales y repetirlas lleva tiempo.

## David Oliva Huelamo

Para mí lo más útil ha sido ver cómo se conecta todo: el formulario HTML, el controlador, MapStruct y la respuesta. Una dificultad fue que los formularios solo envían GET y POST, y lo resolvimos con el filtro de métodos ocultos de Spring y el campo `_method` para poder editar y eliminar. También he aprendido a documentar y a probar la aplicación de forma ordenada, con un plan de pruebas y capturas de cada resultado. Mejoraría la parte visual, porque ahora el HTML de las respuestas está escrito dentro del código Java y sería mejor usar plantillas.

---

[README](../README.md) | [Volver](06-manual-usuario.md) | [Siguiente: 08-bibliografia-y-anexos.md](08-bibliografia-y-anexos.md)