package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CategoriaNoticiasDTO {

	private Integer id_cad;

	private String tipoNoticiasCad;

	private String tipoNoticiasDescCad;

	private LocalDateTime dataHrInclusao;

	private LocalDateTime criadoEm;
}
