package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticiaEconomiaDTO {

	private Integer id_eco;

	private String noticiasEco;

	private String desc_noticiasEco;

	private Integer idCad;

	private LocalDateTime dataHrInclusao;

	private LocalDateTime criadoEm;

	private String imagemNoticiaEco;
}
