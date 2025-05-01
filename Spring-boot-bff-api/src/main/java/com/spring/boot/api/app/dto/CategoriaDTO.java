package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoriaDTO {

	@Schema(name = "id", description = "numero unico de identificação", example = "123", type = "Integer")
	private Integer id;

	@Schema(name = "categoria", description = "Esportes", example = "Esportes", type = "String")
	private String categoria;

	@Schema(name = "categoriaDesc", description = "tipo noticia descrição", example = "Senna campeão 1994", type = "String")
	private String categoriaDesc;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHrAlteracao;

 	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm; 
}
