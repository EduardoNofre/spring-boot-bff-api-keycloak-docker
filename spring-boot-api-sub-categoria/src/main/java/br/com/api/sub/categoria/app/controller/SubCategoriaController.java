package br.com.api.sub.categoria.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.sub.categoria.app.dto.SubCategoriaDTO;
import br.com.api.sub.categoria.app.handle.HandleException;
import br.com.api.sub.categoria.app.service.SubCategoriaService;
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
@RequestMapping("/sub-categoria")
@Tag(name = "SubCategoria", description = "Recurso Sub Sub Categoria controller Api")
public class SubCategoriaController {

	@Autowired
	private SubCategoriaService subCategoriaService;

	@Operation(summary = "Retorna uma Sub Categoria", description = "Retorna uma Sub Categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubCategoriaDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping()
	public ResponseEntity<List<SubCategoriaDTO>> subCategoriaListar() throws HandleException {

		return ResponseEntity.status(HttpStatus.OK).body(subCategoriaService.subCategoriaListar());
	}

	
	@Operation(summary = "Retorna uma lista de Sub Categoria atrelada a uma categoria", description = "Retorna uma Sub Categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubCategoriaDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/categoria")
	public ResponseEntity<List<SubCategoriaDTO>> subCategoriaListarCategoria(
			@Parameter(name = "categoriaId", description = "numero identificador categoria", example = "123") @RequestParam(required = true) Integer categoriaId) throws HandleException {

		return ResponseEntity.status(HttpStatus.OK).body(subCategoriaService.subCategoriaListarCategoria(categoriaId));
	}
	
	
	
	@Operation(summary = "Inserir novas Sub Categoria", description = "Inserir novas Sub Categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = SubCategoriaDTO.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PostMapping()
	public ResponseEntity<SubCategoriaDTO> subCategoriaInserir(
			@Parameter(name = "subCategoria", description = "sub categoria nome", example = "Jiu Jitsu") @RequestParam(required = true) String subCategoria,
			@Parameter(name = "categoriaId", description = "Identificador da categoria fk ", example = "123") @RequestParam(required = true) Integer categoriaId) {

		return ResponseEntity.status(HttpStatus.OK).body(subCategoriaService.subCategoriaInserir(subCategoria,categoriaId));
	}

	@Operation(summary = "Excluir Sub Categoria existentes", description = "Excluir Sub Categoria existentes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SubCategoriaDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@DeleteMapping()
	public ResponseEntity<Void> subCategoriaExcluir(@Valid @RequestBody SubCategoriaDTO subCategoriaDTO) {

		subCategoriaService.subCategoriaExcluir(subCategoriaDTO);

		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Atualizar Sub Categoria existentes", description = "Atualizar Sub Categoria existentes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Void.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PutMapping()
	public ResponseEntity<SubCategoriaDTO> subCategoriaAtualizar(@Valid @RequestBody SubCategoriaDTO subCategoriaDTO) throws HandleException {

		return ResponseEntity.status(HttpStatus.OK).body(subCategoriaService.SubCategoriaAtualizar(subCategoriaDTO));
	}

}
