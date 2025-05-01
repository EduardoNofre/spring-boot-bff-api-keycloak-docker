CREATE SCHEMA IF NOT EXISTS spring_boot_banco;


CREATE TABLE IF NOT EXISTS categoria(
    idCategoria INT AUTO_INCREMENT,
   	categoria VARCHAR(50) not null,
    categoria_desc VARCHAR(50) not null,
    data_hr_alteracao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	PRIMARY KEY (idCategoria)
);

CREATE TABLE IF NOT EXISTS noticia(
    idNoticia INT AUTO_INCREMENT,
    noticias VARCHAR(50) not null,
    noticias_desc VARCHAR(50) not null,
    categoria_id INT,
    principal boolean,
    data_hr_alteracao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	imagem_noticia VARCHAR(50) not null,
	PRIMARY KEY (idNoticia),
	CONSTRAINT fk_categoria_01 FOREIGN KEY (categoria_id) REFERENCES categoria(idCategoria)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);
