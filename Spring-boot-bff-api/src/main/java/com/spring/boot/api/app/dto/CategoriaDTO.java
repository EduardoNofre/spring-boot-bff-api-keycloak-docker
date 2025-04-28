package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoriaDTO {

	@Schema(name = "id", description = "numero unico de identificação", example = "123", type = "Integer")
	private Integer id;

	@Schema(name = "tipoNoticiasCad", description = "Esportes", example = "Esportes", type = "String")
	private String tipoNoticiasCad;

	@Schema(name = "tipoNoticiasDescCad", description = "tipo noticia descrição", example = "Senna campeão 1994", type = "String")
	private String tipoNoticiasDescCad;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHrInclusao;

 	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm; 
}
