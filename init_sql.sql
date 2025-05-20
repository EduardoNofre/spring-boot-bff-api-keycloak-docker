CREATE SCHEMA IF NOT EXISTS spring_boot_banco;


CREATE TABLE IF NOT EXISTS categoria(
    id INT AUTO_INCREMENT,
   	categoria VARCHAR(50) not null,
    categoria_desc VARCHAR(50) not null,
    data_hr_alteracao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS importancia(
    id INT AUTO_INCREMENT,
    importancia VARCHAR(50) not null,
    importancias_desc VARCHAR(50) not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS noticia(
    id INT AUTO_INCREMENT,
    noticias VARCHAR(50) not null,
    noticias_desc VARCHAR(50) not null,
    data_hr_alteracao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	imagem_noticia VARCHAR(50) not null,
	categoria_id INT,
	importancia_id INT,
	usuario_acao VARCHAR(50) not null,
	PRIMARY KEY (id),
	CONSTRAINT fk_categoria_01 FOREIGN KEY (categoria_id) REFERENCES categoria(id),
	CONSTRAINT fk_importancia_01 FOREIGN KEY (importancia_id) REFERENCES importancia(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);



CREATE TABLE IF NOT EXISTS imagem(
    id INT AUTO_INCREMENT,
    repositorio VARCHAR(100) ,
    servidor VARCHAR(100),
	imagem VARCHAR(100),
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	noticia_id INT,
	PRIMARY KEY (id),
	CONSTRAINT fk_noticia_01 FOREIGN KEY (noticia_id) REFERENCES noticia(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
);
