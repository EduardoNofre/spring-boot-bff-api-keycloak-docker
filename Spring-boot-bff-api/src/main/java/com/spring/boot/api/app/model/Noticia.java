package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
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
	private Integer id;

	@Column(name = "noticias")
	private String noticias;

	@Column(name = "noticias_desc")
	private String noticiasDesc;

	@Column(name = "data_hr_alteracao")
	private LocalDateTime dataHrAlteracao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "imagem_noticia")
	private String imagemNoticia;
	
	@Column(name = "prioridade_id")
	private Integer prioridadeId;
	
	@Schema(name = "usuario_acao")
	private String usuarioAcao;
	
	@Column(name = "categoria_id")
	private Integer categoriaId;

}
