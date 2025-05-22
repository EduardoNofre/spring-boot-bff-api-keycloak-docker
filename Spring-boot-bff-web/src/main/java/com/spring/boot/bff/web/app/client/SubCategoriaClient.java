package com.spring.boot.bff.web.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.bff.web.app.dto.SubCategoriaDTO;
import com.spring.boot.bff.web.app.handle.HandleException;

@FeignClient(url = "${api.client.api.sub.categoria.url}", name = "subCategoriaClient")
public interface SubCategoriaClient {

	@GetMapping(value = "/sub-categoria")
	public ResponseEntity<List<SubCategoriaDTO>> subCategoriaListar() throws HandleException;

	@PostMapping(value = "/sub-categoria")
	public ResponseEntity<SubCategoriaDTO> subCategoriaInserir(
			@RequestParam String subCategoria,
			@RequestParam Integer categoriaId);

	@DeleteMapping(value = "/sub-categoria")
	public void subCategoriaExcluir(@RequestBody SubCategoriaDTO subCategoriaDTO);

	@PutMapping(value = "/sub-categoria")
	public ResponseEntity<SubCategoriaDTO> subCategoriaAtualizar(@RequestBody SubCategoriaDTO subCategoriaDTO)
			throws HandleException;

}
