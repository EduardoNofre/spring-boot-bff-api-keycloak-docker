package br.com.noticiario.app.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrioridadeDTO {

	@Schema(name = "id", description = "numero unico de identificação", example = "1", type = "Integer")
	private Integer id; 
	
	@Schema(name = "prioridade", description = "Nome prioridade", example = "Principal", type = "String")
	private String prioridade;
	
	@Schema(name = "prioridadeDesc", description = "Descrição da prioridade", example = "materia principal", type = "String")
	private String prioridadeDesc;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime criadoEm;
}
