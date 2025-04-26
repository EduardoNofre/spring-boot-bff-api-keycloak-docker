CREATE SCHEMA IF NOT EXISTS spring_boot_banco;

CREATE TABLE IF NOT EXISTS categoria_noticias (
    idCad INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    dataHrInclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_principal (
    idPrinc INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    idCad INT,
    foreign key (idCad) references categoria_noticias(idCad),
    dataHrInclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_esportes (
    idEsp INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    idCad INT,
    foreign key (idCad) references categoria_noticias(idCad),
    dataHrInclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_politica (
    idPol INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    idCad INT,
    foreign key (idCad) references categoria_noticias(idCad),
    dataHrInclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_economia (
    idEco INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    idCad INT,
    foreign key (idCad) references categoria_noticias(idCad),
    dataHrInclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP
);


