package br.com.noticiario.app.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SubCategoriaDTO {

	@Schema(name = "id", description = "Numero unico de identificação", example = "123", type = "Integer")
	private Integer id;

	@Schema(name = "subCategoria", description = "SubCategoria descrição", example = "123", type = "String")
	private String subCategoria;

	@Schema(name = "criadoEm", description = "Data da criação", example = "123", type = "LocalDateTime")
	private LocalDateTime criadoEm;

	@Schema(name = "categoriaId", description = "Numero unico de identificação categoria associado a Subcategoria", example = "123", type = "Integer")
	private Integer categoriaId;
}
