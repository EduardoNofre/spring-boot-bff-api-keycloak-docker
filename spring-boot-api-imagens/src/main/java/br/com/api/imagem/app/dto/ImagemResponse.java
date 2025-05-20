package br.com.api.imagem.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImagemResponse {

	@Schema(name = "servidor", description = "nome do servidor ou IP da imagem", example = "C:\\", type = "String")
	private String servidor;

	@Schema(name = "repositorio", description = "diretorio da imagem", example = "\\noticia\\imagens\\", type = "String")
	private String repositorio;
	
	@Schema(name = "imagem", description = "nome da imagem", example = "10.png", type = "String")
	private String imagem;
	
	@Schema(name = "imagemByte", description = "array de bytes", example = "10.png", type = "byte")
	private byte[] imagemByte;
	
	@Schema(name = "contentType ", description = "png/jpg ..", example = "10.png", type = "byte")
	private String contentType;

}
