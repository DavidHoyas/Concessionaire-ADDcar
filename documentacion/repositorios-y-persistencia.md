# Repositorios y Persistencia Mock

## Contratos e Implementación en Memoria

- `CRUDRepository<T, ID>` define las operaciones básicas (`save`, `getAll`, `getById`, `deleteById`), extendida por `CocheRepository` para la entidad `Coche` con clave `Integer`.

- `CocheRepositoryMockImpl` almacena los vehículos en un `Map<Integer, Coche>` inicializado con `CocheFactory.getDemoData()`.

- El cálculo del siguiente ID (`obtenerSiguienteId`) se simplificó obteniendo el ID máximo mediante `stream().mapToInt(Integer::intValue).max().orElse(0) + 1`.
