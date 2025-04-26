package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NoticiaPrincipalDTO {

	private Integer id_princ;

	private String noticiasPrinc;

	private String desc_noticiasPrinc;

	private LocalDateTime dataHrInclusao;

	private LocalDateTime criadoEm;

	private String imagemNoticiaPrinc;
}
