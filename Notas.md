Notas sobre decisiones de desarrollo
====================================
*   Utilización del formato de fichero *.md* para proporcionar soporte de formato en estos ficheros.
*   Separación de los espacios físicos de los ficheros de código y test en directorios distintos
   *   *src* para fuentes y *test* para pruebas
*   Se comparte el mismo espacio lógico (*package*) tanto para código como para test.
*   *TDD*: primero siempre el test, y luego la solución.

Evolución
------------------------------------
*   Empezamos **_probando línea vacia_**. Hacemos el test y para que pase escribimos el código mínimo.
   * El test nos obliga a crear el SUT (Subject Under Test) mínimo:
      * Creación de la clase LineCounter
      * Creación de su constructor. Se decide que el código fuente se suministra mendiante un string delimitando las diferentes líneas con *\n*
      * Creación del método de conteo: cuenta las lineas en función de los criterios de la kata.
*   Linea con SOLO caracteres blancos se descarta de la cuenta
*   Una linea de código devuelve 1. Pero tenemos *rojo* pues no tenemos implementación para el caso
      * Para buscar el verde: en el SUT
         * tenemos que contar lineas basandose en los delimitadores *\\n*
         * y tenemos que descartar si la linea es vacia
*   Triangulación conteo lineas: Dos lineas de código devuelve 2 -> verde
*   Pero el codigo huele mal. Necesitamos una refactorización:
         * 



