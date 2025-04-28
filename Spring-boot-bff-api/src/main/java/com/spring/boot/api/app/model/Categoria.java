package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tipo_noticias_cad ")
	private String tipoNoticiasCad;

	@Column(name = "tipo_noticias_desc_cad ")
	private String tipoNoticiasDescCad;

	@Column(name = "data_hr_inclusao")
	private LocalDateTime dataHrInclusao;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;
}
