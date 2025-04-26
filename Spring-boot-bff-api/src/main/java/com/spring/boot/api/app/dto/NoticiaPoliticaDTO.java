package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticiaPoliticaDTO {

	private Integer idPol;

	private String noticiasPol;

	private String desc_noticiasPol;

	private Integer idCad;

	private LocalDateTime dataHrInclusao;

	private LocalDateTime criadoEm;

	private String imagemNoticiaPol;
}
