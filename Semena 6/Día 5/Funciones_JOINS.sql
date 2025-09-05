INSERT INTO peliculas(titulo, genero, anio, director_id)
VALUES('Película acción 2', 'Acción', 2014, 1),
	  ('Película comedia 3', 'Comedia', 2012, 2),
      ('Película animada 3', 'Animación', 2012, 1),
	  ('Película comedia 4', 'Comedia', 2020, 6);

SELECT *
FROM directores d JOIN peliculas p
	ON d.id = p.director_id;
    
SELECT *
FROM peliculas p RIGHT JOIN directores d
	ON d.id = p.director_id;
    
SELECT id, CONCAT(nombre, " ", apellido_paterno, " ", apellido_materno) AS "Nombre", UPPER(nacionalidad)
FROM directores
ORDER BY nombre DESC;

SELECT d.nombre, d.apellido_paterno, d.apellido_materno, COUNT(d.id) AS "Número de películas"
FROM directores d JOIN peliculas p
	ON d.id = p.director_id
GROUP BY d.id
ORDER BY nombre DESC;

-- Proyecto los primeros 3 registros
SELECT *
FROM directores d JOIN peliculas p
	ON d.id = p.director_id
LIMIT 3;

-- Proyecto los siguientes tres registros
SELECT *
FROM directores d JOIN peliculas p
	ON d.id = p.director_id
LIMIT 3
OFFSET 3; -- Muestra a partir del renglón 4