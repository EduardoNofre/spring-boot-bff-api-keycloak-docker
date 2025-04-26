CREATE SCHEMA IF NOT EXISTS spring_boot_banco;

CREATE TABLE IF NOT EXISTS categoria_noticias (
    id_cad INT auto_increment primary key,
    tipo_noticias_cad VARCHAR(50) not null,
    tipo_noticias_desc_cad VARCHAR(50) not null,
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_principal (
    idPrinc INT auto_increment primary key,
    tipo_noticias_princ VARCHAR(50) not null,
    tipo_noticias_desc_princ VARCHAR(50) not null,
    id_cad INT,
    foreign key (id_cad) references categoria_noticias(id_cad),
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_esportes (
    idEsp INT auto_increment primary key,
    tipo_noticias_esp VARCHAR(50) not null,
    tipo_noticias_desc_esp VARCHAR(50) not null,
    id_cad INT,
    foreign key (id_cad) references categoria_noticias(id_cad),
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_politica (
    idPol INT auto_increment primary key,
    tipo_noticias_pol VARCHAR(50) not null,
    tipo_noticias_desc_pol VARCHAR(50) not null,
    id_cad INT,
    foreign key (id_cad) references categoria_noticias(id_cad),
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP

);

CREATE TABLE IF NOT EXISTS noticia_economia (
    idEco INT auto_increment primary key,
    tipo_noticias_eco VARCHAR(50) not null,
    tipo_noticias_desc_eco VARCHAR(50) not null,
    id_cad INT,
    foreign key (id_cad) references categoria_noticias(id_cad),
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP
);

