## Parámetros de la API de Google Scholar

### Parámetro: q
- **Tipo de dato:** Cadena de caracteres (String)
- **Descripción:** Especifica el término de búsqueda o la consulta a enviar a Google Scholar. Puede contener palabras clave, frases o consultas avanzadas.
- **Requerido:** True

### Parámetro: num
- **Tipo de dato:** Entero (Integer)
- **Descripción:** Especifica el número máximo de resultados que se devolverán. El valor predeterminado es 10 y el máximo es 100.
- **Requerido:** False

### Parámetro: start
- **Tipo de dato:** Entero (Integer)
- **Descripción:** Especifica el índice del primer resultado a devolver. Se utiliza para paginar los resultados. El valor predeterminado es 0.
- **Requerido:** False

### Parámetro: hl
- **Tipo de dato:** Cadena de caracteres (String)
- **Descripción:** Establece el idioma de los resultados devueltos. Se utiliza para localizar los resultados en el idioma especificado.
- **Requerido:** False

### Parámetro: as_ylo
- **Tipo de dato:** Entero (Integer)
- **Descripción:** Limita los resultados a aquellos publicados en o después del año especificado.
- **Requerido:** False

### Parámetro: as_yhi
- **Tipo de dato:** Entero (Integer)
- **Descripción:** Limita los resultados a aquellos publicados en o antes del año especificado.
- **Requerido:** False

### Parámetro: as_vis
- **Tipo de dato:** Cadena de caracteres (String)
- **Descripción:** Filtra los resultados por visibilidad. Puede tener valores como "0" para todos los resultados, "1" para incluir solo los resultados visibles públicamente, etc.
- **Requerido:** False

### Parámetro: as_sdt
- **Tipo de dato:** Cadena de caracteres (String)
- **Descripción:** Filtra los resultados por tipo de documento. Puede tener valores como "0" para todos los documentos, "0,1" para incluir artículos y patentes, etc.

### Parámetro: engine
- **Tipo de dato:** Cadena de caracteres (String)
- **Descripción:** Parámetro para determinare el motor de búsqueda utilizado (En este caso se ocupara **google_scholar**)
- **Requerido:** True

### Parámetro: api_key
- **Tipo de dato:** Cadena de caracteres (String)
- **Descripción:** Llave privada asignada por SerpApi para generar las consultas
- **Requerido:** True
