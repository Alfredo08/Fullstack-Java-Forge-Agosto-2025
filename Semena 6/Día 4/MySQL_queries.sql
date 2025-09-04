
-- Query para agregar un registro a una tabla
INSERT INTO directores(nombre, apellido_paterno, apellido_materno, nacionalidad)
VALUES('Julieta', 'Vargas', 'Infante', 'Peruana');

INSERT INTO directores(nombre, apellido_paterno, apellido_materno, nacionalidad)
VALUES('Martha', 'Garza', 'López', 'Chilena'),
	  ('Alan', 'Morales', 'Espinoza', 'Chilena'),
      ('Julieta', 'Vargas', 'Infante', 'Peruana'),
      ('Alex', 'García', 'Sandoval', 'Mexicana');
      
INSERT INTO peliculas(titulo, genero, anio, director_id)
VALUES('Película animada 1', 'Animación', 2010, 1);

-- Query para proyectar datos de una tabla
SELECT *
FROM directores;

SELECT nombre, apellido_paterno, apellido_materno
FROM directores;

SELECT *
FROM directores
WHERE (nacionalidad = 'Chilena' OR nacionalidad = 'Mexicana') AND nombre = 'Alex';

SELECT nombre AS "Nombre", apellido_paterno AS "Apellido Paterno", apellido_materno AS "Apellido Materno"
FROM directores;

SELECT *
FROM directores
WHERE id = 8;

SELECT *
FROM directores
WHERE nombre LIKE 'A%';

SELECT *
FROM peliculas;

-- Query para actualizar los registros de una tabla
UPDATE directores
SET apellido_paterno = 'Miller', nombre = 'Alejandro'
WHERE id = 1;

-- Query para eliminar registros de una tabla
DELETE FROM directores
WHERE id = 4;