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

import com.spring.boot.bff.web.app.dto.PrioridadeDTO;

@FeignClient(url = "${api.client.api.sub.prioridade.url}", name = "prioridade")
public interface PrioridadeClient {

	@GetMapping("/prioridade/id")
	public ResponseEntity<PrioridadeDTO> buscarId(@RequestParam Integer id);

	@GetMapping("/prioridade/listar")
	public ResponseEntity<List<PrioridadeDTO>> listar();

	@PostMapping("/prioridade/criar")
	public ResponseEntity<PrioridadeDTO> criar(@RequestBody PrioridadeDTO prioridadeDTO);

	@PutMapping("/prioridade/atualizar")
	public ResponseEntity<PrioridadeDTO> atualizar(@RequestBody PrioridadeDTO prioridadeDTO);

	@DeleteMapping("/prioridade/excluir")
	public ResponseEntity<Void> excluir(@RequestBody PrioridadeDTO prioridadeDTO);
}
