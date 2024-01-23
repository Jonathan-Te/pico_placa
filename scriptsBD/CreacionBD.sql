DROP DATABASE RestriccionVehicular;

CREATE DATABASE RestriccionVehicular;

USE RestriccionVehicular;

CREATE TABLE Dia (
    id INT AUTO_INCREMENT,
    nombre VARCHAR(255),
    restriccion BOOLEAN,
    idHorario INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idHorario) REFERENCES Horario(id)
);

CREATE TABLE Horario (
    id INT AUTO_INCREMENT,
    horaInicio TIME,
    horaFin TIME,
    idSecundario INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idSecundario) REFERENCES Horario(id)
);

CREATE TABLE Consulta (
    id INT AUTO_INCREMENT,
    placa VARCHAR(255),
    fechaConsulta DATE,
    fechaConsultada DATE,
    puedeCircular BOOLEAN,
    PRIMARY KEY (id)
);