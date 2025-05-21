package com.spring.boot.bff.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.bff.web.app.dto.ImagemDTO;
import com.spring.boot.bff.web.app.handle.HandleException;
import com.spring.boot.bff.web.app.service.ImagemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/imagem")
@Tag(name = "imagem", description = "Recurso imagem controller Api")
public class ImagemController {
	

	@Autowired
	private ImagemService imagemService;
	
	@Operation(summary = "download imagem", description = "download imagem")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Byte.class))) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@GetMapping()
	public ResponseEntity<byte[]> ImagemDownload(
			@Parameter(name = "servidor", description = "nome servidor", example = "c:\\") @RequestParam(required = true) String servidor,
			@Parameter(name = "repositorio", description = "nome repositorio", example = "\\noticia\\imagens\\") @RequestParam(required = true) String repositorio,
			@Parameter(name = "imagem", description = "nome imagem", example = "teste.png") @RequestParam(required = true) String imagem
			
			) throws HandleException {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(imagemService.ImagemDownload(servidor, repositorio, imagem));
	}

	@Operation(summary = "upload imagem", description = "upload imagem")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Criado", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ImagemDTO.class)) }),
			@ApiResponse(responseCode = "204", description = "Sem conteudo", content = @Content),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@PostMapping(consumes = "multipart/form-data")
	public ResponseEntity<ImagemDTO> ImagemUpload(@Parameter(name = "imagem", description = "MultipartFile imagem", example = "local da imagem") @RequestParam(required = true) MultipartFile imagem) throws HandleException {
		return ResponseEntity.status(HttpStatus.CREATED).body(imagemService.ImagemUpload(imagem));
	}
	
	@Operation(summary = "Excluir imagem existente", description = "Excluir imagem existente")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ImagemDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro processar a requisição", content = @Content),
			@ApiResponse(responseCode = "401", description = "Não autorizado", content = @Content),
			@ApiResponse(responseCode = "404", description = "Pagina não encontrado", content = @Content),
			@ApiResponse(responseCode = "409", description = "Não conformidade na regra de negocio", content = @Content),
			@ApiResponse(responseCode = "500", description = "Interno sem causa mapeada.", content = @Content),
			@ApiResponse(responseCode = "504", description = "Gateway Time-Out", content = @Content) })
	@DeleteMapping()
	public ResponseEntity<Void> deletarImagem(@Parameter(name = "idNoticia", description = "id da Noticia", example = "123") @RequestParam(required = true) Integer idNoticia) throws HandleException {
		
		imagemService.deletarImagem(idNoticia);
		
		return ResponseEntity.ok().build();
	}
}
