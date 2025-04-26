package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Table(name = "noticia_politica")
public class NoticiaPolitica {

	@Id
	private Integer idPol;
	
	@Column(name = "tipo_noticias_pol")
	private String noticiasPol;

	@Column(name = "tipo_noticias_desc_pol")
	private String desc_noticiasPol;

	@Column(name = "id_Cad")
	private Integer idCad;
	
	@Column(name = "data_hr_Inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(name = "imagem_noticia_pol")
	private String imagemNoticiaPol;
}
