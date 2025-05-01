CREATE TABLE IF NOT EXISTS categoria(
    id INT AUTO_INCREMENT,
    tipo_noticias_cad VARCHAR(50) not null,
    tipo_noticias_desc_cad VARCHAR(50) not null,
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS noticia_principal (
    id INT AUTO_INCREMENT,
    tipo_noticias_princ VARCHAR(50) not null,
    tipo_noticias_desc_princ VARCHAR(50) not null,
    categoria_id INT,
    data_hr_inclusao DATETIME not null,
	criado_em TIMESTAMP default CURRENT_TIMESTAMP,
	imagem_noticia_princ VARCHAR(50) not null,
	PRIMARY KEY (id),
	CONSTRAINT fk_categoria_01 FOREIGN KEY (categoria_id) REFERENCES categoria(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE

);
