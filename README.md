# Introducción a la Metodología SCRUM y Formatos de Archivos JSON y CSV

## 1. Metodología SCRUM

### 1.1 ¿Qué es SCRUM?

Scrum es un marco de trabajo ágil para el desarrollo y mantenimiento de productos complejos. Su objetivo principal es entregar valor de manera incremental a través de ciclos de trabajo iterativos llamados sprints. En Scrum, se promueve la colaboración entre los equipos, la adaptabilidad al cambio, y la entrega constante de valor.

### 1.2 Fases de SCRUM

Scrum no sigue fases tradicionales, pero se puede describir su proceso en las siguientes actividades clave:

- **Inicio del Proyecto:**
  - Definición de la Visión del Producto
  - Creación del Product Backlog
  - Formación del Equipo Scrum
  - Establecimiento de la Definición de Terminado (DoD)

- **Ejecución de Sprints:**
  - Planificación del Sprint (Sprint Planning)
  - Ejecución del Sprint
  - Revisión del Sprint (Sprint Review)
  - Retrospectiva del Sprint (Sprint Retrospective)

- **Entrega y Cierre:**
  - Entrega del Producto
  - Cierre del Proyecto (opcional)

### 1.3 ¿Cómo Implementar SCRUM?

La implementación de Scrum implica los siguientes pasos:

1. **Formar el Equipo:**
   - Designar los roles de Product Owner, Scrum Master y Equipo de Desarrollo.

2. **Capacitación en Scrum:**
   - Asegurar que el equipo entienda los principios y prácticas de Scrum.

3. **Crear y Priorizar el Product Backlog:**
   - Trabajar con el Product Owner para desarrollar un backlog inicial.

4. **Iniciar el Primer Sprint:**
   - Planificar el trabajo del primer sprint en la reunión de Sprint Planning.

5. **Reuniones diarias (Daily Scrum):**
   - Mantener reuniones diarias para sincronizar el trabajo y resolver impedimentos.

6. **Revisión y Retrospectiva:**
   - Realizar revisiones y retrospectivas al final de cada sprint para mejorar continuamente.

7. **Iterar:**
   - Repetir los sprints hasta que el producto esté completo o el proyecto finalice.

## 2. Características de Archivos JSON y CSV

### 2.1 JSON (JavaScript Object Notation)

JSON es un formato ligero de intercambio de datos, fácil de leer y escribir tanto para humanos como para máquinas. Se utiliza ampliamente en aplicaciones web para la transmisión de datos.

- **Sintaxis:**
  - Basado en la sintaxis de objetos de JavaScript.
  - Utiliza pares clave-valor para representar datos.
  - Soporta estructuras como objetos y arrays.
  
- **Ejemplo de JSON:**
  ```json
  {
    "nombre": "Juan",
    "edad": 30,
    "esEstudiante": false,
    "cursos": ["Matemáticas", "Ciencias", "Historia"]
  }

### 2.2 CSV (Comma-Separated Values)

CSV en un formato simple de texto para almacenar datos tabulares, donde cada línea corresponde a un registro y los valores de cada campo se separan por comas.

- **Sintaxis:**
  - Los campos se separan por comas (´,´).
  - La primera línea suele contener los nombres de las columnas.
  - No es adecuado para datos jerárquicos o estructuras complejas.
 
- **Ejemplo de CSV:**
  ```csv
  nombre,edad,esEstudiante,cursos
  Juan,30,false,"Matemáticas, Ciencias, Historia"
