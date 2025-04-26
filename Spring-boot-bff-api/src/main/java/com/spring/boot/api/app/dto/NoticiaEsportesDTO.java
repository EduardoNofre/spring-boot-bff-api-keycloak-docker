package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticiaEsportesDTO {

	private Integer id_esp;

	private String noticiasEsp;

	private String desc_noticiasEsp;

	private Integer idCad;

	private LocalDateTime dataHrInclusao;

	private LocalDateTime criadoEm;

	private String imagemNoticiaEsp;
}
