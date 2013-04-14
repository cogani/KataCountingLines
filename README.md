Kata de conteo de líneas de código fuente.
==========================================

Los requisitos a cumplir serán los siguientes:

*   El resultado final es el número de líneas de codigo existentes en el fuente suministrado.
*   En el conteo hay que excluir:  
    1.  Lineas en blanco:
        * Sin contenido alguno: longitud 0
        * Solo caracteres "blancos": solo espacios y/o tabuladores.
    2.  Lineas de SOLO comentarios:
        * Comentarios de linea: Empiezan por "//" y su radio de acción es hasta el final de la misma
        * Comentarios de multilinea (o bloque): Empiezan por "/*" y su radio de acción es hasta la marca "*/ de cierre del bloque del comentario.
          * Las marcas de apertura y cierre pueden estar en líneas distintas  

Sobre el desarrollo de la kata:
-------------------------------
*   Desarrollarse mediante **_TDD_**
*   Respeto de los principios **_SOLID_**
*   Usar nombrado de entidades basado en directrices de código limpio.
