package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class NoticiaDTO {

	@Schema(name = "id", description = "numero unico de identificação", example = "123", type = "Integer")
	private Integer id;

	@Schema(name = "tipoNoticiasPrinc", description = "tipo noticia", example = "123", type = "String")
	private String tipoNoticiasPrinc;

	@Schema(name = "tipoNoticiasDescPrinc", description = "tipo noticia descrição", example = "Alines pedem asilo na terra!", type = "String")
	private String tipoNoticiasDescPrinc;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dataHrInclusao;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm;

	@Schema(name = "imagemNoticiaPrinc", description = "repositorio da imagem principal", example = "/mnt/imag/sportes/tetse.png", type = "String")
	private String imagemNoticiaPrinc;
	
	@Schema(name = "categoriaId", description = "fk categoria Id", example = "123", type = "String")
	private Integer categoriaId;
}
