package com.spring.boot.api.app.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria_noticias")
public class CategoriaNoticias {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_cad;

	@Column(name = "tipo_noticias_cad ")
	private String tipoNoticiasCad;

	@Column(name = "tipo_noticias_desc_cad ")
	private String tipoNoticiasDescCad;

	@Column(name = "data_hr_inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@OneToMany(mappedBy = "idCadEconomiaFk", cascade = CascadeType.ALL)
	private List<NoticiaEconomia> noticiaEconomia;
	
	@OneToMany(mappedBy = "idCadEsportesFk", cascade = CascadeType.ALL)
	private List<NoticiaEsportes> noticiaEsportes;
	
	@OneToMany(mappedBy = "idCadPoliticaFk", cascade = CascadeType.ALL)
	private List<NoticiaPolitica> noticiaPolitica;
	
	@OneToMany(mappedBy = "idCadPrincipalFk", cascade = CascadeType.ALL)
	private List<NoticiaPrincipal> noticiaPrincipalDTO;
}
