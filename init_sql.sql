create schema if not exists spring_boot_banco;

create table if not exists categoria_noticias (
    idCad INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null

);

create table if not exists noticia_principal (
    idPrinc INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    idCad INT,
    foreign key (idCad) references categoria_noticias(idCad)

);

create table if not exists noticia_esportes (
    idEsp INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    idCad INT,
    foreign key (idCad) references categoria_noticias(idCad)

);

create table if not exists noticia_politica (
    idPol INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
       idCad INT,
    FOREIGN KEY (idCad) REFERENCES categoria_noticias(idCad)

);

create table if not exists noticia_economia (
    idEco INT auto_increment primary key,
    tipo_noticias VARCHAR(50) not null,
    tipo_noticias_desc VARCHAR(50) not null,
    idCad INT,
    FOREIGN KEY (idCad) REFERENCES categoria_noticias(idCad)
);