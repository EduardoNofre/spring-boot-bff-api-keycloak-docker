package com.spring.boot.bff.web.app.controller;

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

import com.spring.boot.bff.web.app.dto.NoticiaDTO;
import com.spring.boot.bff.web.app.handle.HandleException;
import com.spring.boot.bff.web.app.service.NoticiaService;

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
@RequestMapping("/bff-web-noticia")
@Tag(name = "Noticia", description = "Recurso bff noticia controller BFF")
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
	@GetMapping("/bff-noticias")
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
	@GetMapping("/bff-listas")
	public ResponseEntity<List<NoticiaDTO>> listaNoticia() throws HandleException {
		return ResponseEntity.status(HttpStatus.OK).body(noticiaService.listar());
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
	@PostMapping("/bff-criar")
	public ResponseEntity<NoticiaDTO> criarNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO) throws HandleException {
		return ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.criar(noticiaDTO));
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
	@PutMapping("/bff-atualizar")
	public ResponseEntity<NoticiaDTO> atualizarNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO) throws HandleException {
		return ResponseEntity.status(HttpStatus.OK).body(noticiaService.atualizar(noticiaDTO));
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
	@DeleteMapping("bff-excluir")
	public ResponseEntity<Void> excluirNoticia(@Valid @RequestBody NoticiaDTO noticiaDTO) throws HandleException {
		
		noticiaService.excluir(noticiaDTO);
		
		return ResponseEntity.ok().build();
	}
}
