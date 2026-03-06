DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
     id INT PRIMARY KEY AUTO_INCREMENT,
     idcliente INT,
     nombre VARCHAR(255),
     apellido VARCHAR(255),
     estado BOOLEAN,
     edad INT
);

insert into cliente (idcliente, nombre, apellido, estado, edad)
values (1, 'Frank', 'Abad', TRUE, 35);
