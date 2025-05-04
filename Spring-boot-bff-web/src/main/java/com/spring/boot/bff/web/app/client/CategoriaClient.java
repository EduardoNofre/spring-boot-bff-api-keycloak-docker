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

import com.spring.boot.bff.web.app.dto.CategoriaDTO;

@FeignClient(url = "${api.client.url}", name = "categoria")
public interface CategoriaClient {

	@GetMapping("/categoria/id")
	public ResponseEntity<CategoriaDTO> buscarId(@RequestParam("id") Integer id);

	@GetMapping("/categoria/listar")
	public ResponseEntity<List<CategoriaDTO>> listaCategoria();

	@PostMapping("/categoria/criar")
	public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoriaDTO);

	@PutMapping("/categoria/atualizar")
	public ResponseEntity<CategoriaDTO> atualizar(@RequestBody CategoriaDTO categoriaDTO);

	@DeleteMapping("/categoria/excluir")
	public ResponseEntity<Void> excluir(@RequestBody CategoriaDTO categoriaDTO);

}
