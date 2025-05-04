package com.spring.boot.bff.web.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ImportanciaDTO {

	@Schema(name = "id", description = "numero unico de identificação", example = "1", type = "Integer")
	private Integer id; 
	
	@Schema(name = "importancia", description = "Nome importancia", example = "Principal", type = "String")
	private String importancia;
	
	@Schema(name = "importanciasDesc", description = "Descrição da importancia", example = "materia principal", type = "String")
	private String importanciasDesc;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm;
}
