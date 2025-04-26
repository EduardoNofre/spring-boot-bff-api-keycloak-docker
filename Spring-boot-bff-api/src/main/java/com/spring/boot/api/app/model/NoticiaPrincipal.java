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
@Table(name = "noticia_principal")
public class NoticiaPrincipal {

	@Id
	private Integer id_princ;
	
	@Column(name = "tipo_noticias_princ")
	private String noticiasPrinc;
	
	@Column(name = "tipo_noticias_desc_princ")
	private String desc_noticiasPrinc;

	@ManyToOne
	@JoinColumn(name = "CategoriaNoticias_id_Cad")
	private CategoriaNoticias idCadPrincipalFk;
	
	@Column(name = "data_hr_inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
	
	@Column(name = "imagem_noticia_princ")
	private String imagemNoticiaPrinc;
}
