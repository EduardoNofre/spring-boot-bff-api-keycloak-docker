package com.spring.boot.api.app.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "categoria_noticias")
public class CategoriaNoticias {

	@Id
	private Integer id_cad;

	@Column(name = "tipo_noticias_cad ")
	private String tipoNoticiasCad;

	@Column(name = "tipo_noticias_desc_cad ")
	private String tipoNoticiasDescCad;

	@Column(name = "data_hr_inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@OneToMany(mappedBy = "CategoriaNoticias", cascade = CascadeType.ALL)
	private List<NoticiaEconomia> noticiaEconomia;
}
