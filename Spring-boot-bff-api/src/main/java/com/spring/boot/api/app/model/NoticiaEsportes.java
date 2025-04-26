package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "noticia_esportes")
public class NoticiaEsportes {

	@Id
	private Integer id_esp;

	@Column(name = "tipo_noticias_esp")
	private String noticiasEsp;

	@Column(name = "tipo_noticias_desc_esp")
	private String desc_noticiasEsp;

	@ManyToOne
	@JoinColumn(name = "CategoriaNoticias_id_Cad")
	private CategoriaNoticias idCadEsportesFk;
	
	@Column(name = "data_hr_Inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(name = "imagem_noticia_esp")
	private String imagemNoticiaEsp;
	
}
