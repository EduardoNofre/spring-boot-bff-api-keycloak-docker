package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "noticia_esportes")
public class NoticiaEsportes {

	@Id
	private Integer id_esp;

	@Column(name = "tipo_noticias_esp")
	private String noticiasEsp;

	@Column(name = "tipo_noticias_desc_esp")
	private String desc_noticiasEsp;

	@Column(name = "id_Cad")
	private Integer idCad;
	
	@Column(name = "data_hr_Inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(name = "imagem_noticia_esp")
	private String imagemNoticiaEsp;
	
}
