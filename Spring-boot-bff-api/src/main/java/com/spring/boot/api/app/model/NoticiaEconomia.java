package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Table(name = "noticia_economia")
public class NoticiaEconomia {

	@Id
	private Integer id_eco;

	@Column(name = "tipo_noticias_eco")
	private String noticiasEco;

	@Column(name = "tipo_noticias_desc_eco")
	private String desc_noticiasEco;

	@ManyToOne
	@JoinColumn(name = "id_Cad")
	private Integer idCad;
	
	@Column(name = "data_hr_inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(name = "imagem_noticia_eco")
	private String imagemNoticiaEco;
}
