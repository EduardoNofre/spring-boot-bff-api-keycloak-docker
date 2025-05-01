package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "noticia")
public class Noticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNoticia;

	@Column(name = "noticias")
	private String noticias;

	@Column(name = "noticias_desc")
	private String noticiasDesc;

	@Column(name = "data_hr_alteracao")
	private LocalDateTime dataHrAlteracao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "imagem_noticia")
	private String imagemNoticiaPrinc;
	
	@Column(name = "principal")
	private boolean principal;
	
	@Column(name = "categoria_id")
	private Integer categoriaId;

}
