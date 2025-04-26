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
@Table(name = "noticia_politica")
public class NoticiaPolitica {

	@Id
	private Integer idPol;
	
	@Column(name = "tipo_noticias_pol")
	private String noticiasPol;

	@Column(name = "tipo_noticias_desc_pol")
	private String desc_noticiasPol;

	@ManyToOne
	@JoinColumn(name = "CategoriaNoticias_id_Cad")
	private CategoriaNoticias idCadPoliticaFk;
	
	@Column(name = "data_hr_Inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(name = "imagem_noticia_pol")
	private String imagemNoticiaPol;
}
