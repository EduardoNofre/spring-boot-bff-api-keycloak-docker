package br.com.noticiario.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.noticiario.app.dto.SubCategoriaDTO;
import br.com.noticiario.app.handle.HandleException;
import jakarta.validation.Valid;

@FeignClient(url = "${api.client.bff.web.url}", name = "subCategoriaClient")
public interface SubCategoriaClient {

	@GetMapping(value = "/bff-web-sub-categoria")
	public ResponseEntity<List<SubCategoriaDTO>> subCategoriaListar() ;
	
	@GetMapping(value = "/bff-web-sub-categoria/categoria")
	public ResponseEntity<List<SubCategoriaDTO>> subCategoriaListarCategoria(@RequestParam Integer categoriaId) ;

	@PostMapping(value = "/bff-web-sub-categoria")
	public ResponseEntity<SubCategoriaDTO> subCategoriaInserir(
			@RequestParam String subCategoria,
			@RequestParam Integer categoriaId);

	@DeleteMapping(value = "/bff-web-sub-categoria")
	public void subCategoriaExcluir(@Valid @RequestBody SubCategoriaDTO subCategoriaDTO);

	@PutMapping(value = "/bff-web-sub-categoria")
	public ResponseEntity<SubCategoriaDTO> subCategoriaAtualizar(@Valid @RequestBody SubCategoriaDTO subCategoriaDTO)
			;

}
