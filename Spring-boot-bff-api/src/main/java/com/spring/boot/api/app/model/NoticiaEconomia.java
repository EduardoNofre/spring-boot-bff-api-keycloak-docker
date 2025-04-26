package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "noticia_economia")
public class NoticiaEconomia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_eco;

	@Column(name = "tipo_noticias_eco")
	private String noticiasEco;

	@Column(name = "tipo_noticias_desc_eco")
	private String desc_noticiasEco;

	@ManyToOne
	@JoinColumn(name = "CategoriaNoticias_id_Cad")
	private CategoriaNoticias idCadEconomiaFk;
	
	@Column(name = "data_hr_inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(name = "imagem_noticia_eco")
	private String imagemNoticiaEco;
}
