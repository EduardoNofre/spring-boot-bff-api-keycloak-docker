package com.spring.boot.bff.mobile.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.bff.mobile.app.dto.ImportanciaDTO;

@FeignClient(url = "${api.client.url}", name = "importancia")
public interface ImportanciaClient {

	@GetMapping("/importancia/id")
	public ResponseEntity<ImportanciaDTO> buscarId(@RequestParam("id") Integer id);

	@GetMapping("/importancia/listar")
	public ResponseEntity<List<ImportanciaDTO>> listar();

	@PostMapping("/importancia/criar")
	public ResponseEntity<ImportanciaDTO> criar(@RequestBody ImportanciaDTO importanciaDTO);

	@PutMapping("/importancia/atualizar")
	public ResponseEntity<ImportanciaDTO> atualizar(@RequestBody ImportanciaDTO importanciaDTO);

	@DeleteMapping("/importancia/excluir")
	public ResponseEntity<Void> excluir(@RequestBody ImportanciaDTO importanciaDTO);
}
