Dudas con el nombrado de ficheros:
----------------------------------
   * countCodeLines, splitingSourceLines, countingLines. Son nombres bastante similares
 Al hacerlo así lo que quiero reflejar es:
   * Vamos a "countCodeLines" y para ello tenemos que "splitingSourceLines" y "countingLines". Pero no me termina de gustar el nombrado  

Me ha complicado mucho el empezar testeando lineas blancas. Parece más cómodo y lógico empeza por las líneas de ćodigo (caso normal) y después las blancas y comentarios (excepciones a la regla de contado)

Cuidad con el git add. Al ir añadiendo nuevos ficheros a la cata, contaba con que "git commit -a -m " los embarcaría para el commit, pero no lo hace y hay que embarcarlos a mano con "git add "

