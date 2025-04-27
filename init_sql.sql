CREATE SCHEMA IF NOT EXISTS spring_boot_banco;


CREATE TABLE IF NOT EXISTS categoria(
    id_cad INT AUTO_INCREMENT,
    tipo_noticias_cad VARCHAR(50) not null,
    tipo_noticias_desc_cad VARCHAR(50) not null,
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	PRIMARY KEY (id_cad)
);

CREATE TABLE IF NOT EXISTS noticia_principal (
    id_princ INT AUTO_INCREMENT,
    tipo_noticias_princ VARCHAR(50) not null,
    tipo_noticias_desc_princ VARCHAR(50) not null,
    id_cad INT,
    foreign key (id_cad) references categoria(id_cad),
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	imagem_noticia_princ VARCHAR(50) not null,
	PRIMARY KEY (id_princ)

);

CREATE TABLE IF NOT EXISTS outras_noticias (
    id_outras INT AUTO_INCREMENT,
    tipo_noticias_outras VARCHAR(50) not null,
    tipo_noticias_desc_outras VARCHAR(50) not null,
    id_cad INT,
    foreign key (id_cad) references categoria(id_cad),
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	imagem_noticia_outras VARCHAR(50) not null,
	PRIMARY KEY (id_outras)

);
