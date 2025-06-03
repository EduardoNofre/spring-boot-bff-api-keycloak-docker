package com.spring.boot.api.noticia.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class NoticiaDTO {

	@Schema(name = "id", description = "numero unico de identificação", example = "123", type = "Integer")
	private Integer id;

	@Schema(name = "noticias", description = "tipo noticia", example = "123", type = "String")
	private String noticias;

	@Schema(name = "noticias_desc", description = "tipo noticia descrição", example = "Alines pedem asilo na terra!", type = "String")
	private String noticiasDesc;
	
	@Schema(name = "prioridadeId", description = "indica se é uma noticia principal", example = "1", type = "Boolean")
	private Integer prioridadeId;
	
	@Schema(name = "usuarioAcao", description = "Nome do usuario que fez a ação", example = "Mirelly", type = "String")
	private String usuarioAcao;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHrAlteracao;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm;
	
	@Schema(name = "categoriaId", description = "fk categoria Id", example = "123", type = "String")
	private Integer categoriaId;
}
