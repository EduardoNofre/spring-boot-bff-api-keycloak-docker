package com.spring.boot.api.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
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

import com.spring.boot.api.app.dto.NoticiaDTO;
import com.spring.boot.api.app.handle.HandleException;
import com.spring.boot.api.app.service.NoticiaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Order
@RestController
@RequestMapping("/noticia")
@Tag(name = "Noticia", description = "Recurso noticia  Api Service")
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;

	@Operation(summary = "Retorna uma noticia", description = "Retorna uma noticia")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NoticiaDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/id")
	public ResponseEntity<NoticiaDTO> listaNoticia(
			@Parameter(name = "id", description = "Número identificador da noticia", example = "123") @RequestParam(name = "id", required = true) Integer id)
			throws HandleException {

		return ResponseEntity.status(HttpStatus.OK).body(noticiaService.buscarId(id));
	}

	@Operation(summary = "Listar todas as noticias", description = "Listar todas as noticias")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NoticiaDTO.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/listar")
	public ResponseEntity<List<NoticiaDTO>> listaNoticia() throws HandleException {
		return ResponseEntity.status(HttpStatus.OK).body(noticiaService.listaNoticia());
	}

	@Operation(summary = "Inserir novas noticia", description = "Inserir novas noticia")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = NoticiaDTO.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PostMapping("/criar")
	public ResponseEntity<NoticiaDTO> criarNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.criarNoticia(noticiaDTO));
	}
	

	@Operation(summary = "Atualizar noticias existentes", description = "Atualizar noticias existentes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json",schema = @Schema(implementation = NoticiaDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PutMapping("/atualizar")
	public ResponseEntity<NoticiaDTO> atualizarNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO) throws HandleException {
		return ResponseEntity.status(HttpStatus.OK).body(noticiaService.atualizarNoticia(noticiaDTO));
	}

	@Operation(summary = "Excluir noticias existentes", description = "Excluir noticias existentes")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@DeleteMapping("excluir")
	public ResponseEntity<Void> excluirNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO) {
		
		noticiaService.excluirNoticia(noticiaDTO);
		
		return ResponseEntity.ok().build();
	}

	
	@Operation(summary = "Listas as noiticias relaciona a categoria", description = "Listas as noiticias relaciona a categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NoticiaDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping("/lista-categoria-noticias")
	public ResponseEntity<List<NoticiaDTO>> incluirNoticiaCategoria(
			@Valid @RequestBody NoticiaDTO noticiaDTO) throws HandleException {
		return ResponseEntity.status(HttpStatus.OK).body(noticiaService.listaNoticiaCategoria(noticiaDTO));
	}
	
	@Operation(summary = "Inserir noticia categoria", description = "Inserir noticia categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "criado", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = NoticiaDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PostMapping("/categoria-noticias")
	public ResponseEntity<NoticiaDTO> inserirNoticiaCategoria(
			@Valid @RequestBody NoticiaDTO noticiaDTO) throws HandleException {
		return ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.inserirNoticiaCategoria(noticiaDTO));
	}
}
