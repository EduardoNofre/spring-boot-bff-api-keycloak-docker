package com.spring.boot.api.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.api.app.dto.CategoriaDTO;
import com.spring.boot.api.app.handle.HandleException;
import com.spring.boot.api.app.service.CategoriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "CategoriaController", description = "Recurso categoria controller Api")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@Operation(summary = "Retorna uma categoria", description = "Retorna uma categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoriaDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/categoria")
	public ResponseEntity<CategoriaDTO> listaNoticias(
			@Parameter(name = "id", description = "Número identificador da categoria", example = "123") @RequestParam(name = "id", required = true) Integer id)
			throws HandleException {

		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarId(id));
	}

	@Operation(summary = "Listar todas as categoria", description = "Listar todas as categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoriaDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/lista-categoria")
	public ResponseEntity<List<CategoriaDTO>> listaNoticiasRelacionadas() throws HandleException {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listaNoticiasRelacionadas());
	}

	@Operation(summary = "Inserir novas categoria", description = "Inserir novas categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = CategoriaDTO.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PostMapping("/criar-categoria")
	public ResponseEntity<CategoriaDTO> criarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.criarCategoria(categoriaDTO));
	}
	

	@Operation(summary = "Atualizar categoria existentes", description = "Atualizar categoria existentes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoriaDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PutMapping("/atualizar")
	public ResponseEntity<CategoriaDTO> atualizarNoticias(@Valid @RequestBody CategoriaDTO categoriaDTO) throws HandleException {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.atualizarNoticias(categoriaDTO));
	}

	@Operation(summary = "Excluir categoria existentes", description = "Excluir categoria existentes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CategoriaDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@DeleteMapping("excluir")
	public ResponseEntity<Void> excluirNoticias(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		
		categoriaService.excluirNoticias(categoriaDTO);
		
		return ResponseEntity.ok().build();
	}
}
