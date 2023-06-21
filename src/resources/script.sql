CREATE DATABASE academia;
USE academia;

CREATE TABLE clientes (

id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
cpf varchar(200) NOT NULL UNIQUE,
nome varchar(200) NOT NULL,
dataNascimento date NOT NULL,
altura double NOT NULL,
peso double NOT NULL
);

SELECT * FROM clientes;

