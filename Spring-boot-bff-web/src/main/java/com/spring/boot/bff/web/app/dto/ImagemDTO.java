package com.spring.boot.bff.web.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagemDTO {

	@Schema(name = "id", description = "numero unico de identificação", example = "1", type = "Integer")
	private Integer id;

	@Schema(name = "repositorio", description = "diretorio da imagem", example = "/noticia/imagens/", type = "String")
	private String repositorio;

	@Schema(name = "servidor", description = "nome do servidor ou IP da imagem", example = "C:/", type = "String")
	private String servidor;
	
	@Schema(name = "imagem", description = "nome da imagem", example = "10.png", type = "String")
	private String imagem;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm;

	@Schema(name = "noticia_id", description = "imagem relacionada a noticia", example = "123", type = "Integer")
	private Integer noticiaId;

}
