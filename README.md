# Desafío - Escuela Rural

**URL**  
http://localhost:8080

**Config BD**  
src/main/resources/application.properties

**Tables**
```sql:
-- Borrar tablas si existen
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;

-- Crear tabla Courses
CREATE TABLE courses (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);

-- Crear tabla Students
CREATE TABLE students (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	course_id INT,
	FOREIGN KEY (course_id) REFERENCES courses(id)
);

-- Insertar datos de prueba en Courses
INSERT INTO courses (name) VALUES ('Quinto');
INSERT INTO courses (name) VALUES ('Sexto');
INSERT INTO courses (name) VALUES ('Séptimo');

-- Insertar datos de prueba en Students
INSERT INTO students (name, course_id) VALUES ('Matías González', 1);
INSERT INTO students (name, course_id) VALUES ('Valentina Rojas', 1);
INSERT INTO students (name, course_id) VALUES ('Francisca Pérez', 1);
INSERT INTO students (name, course_id) VALUES ('Joaquín Sánchez', 2);
INSERT INTO students (name, course_id) VALUES ('Camila Fernández', 2);
INSERT INTO students (name, course_id) VALUES ('Sebastián Ramírez', 3);
```