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

import com.spring.boot.bff.web.app.dto.NoticiaDTO;

@FeignClient(url = "${api.client.api.back.end.url}", name = "noticia")
public interface NoticiaClient {

	@GetMapping("/noticia/id")
	public ResponseEntity<NoticiaDTO> buscarId(@RequestParam("id") Integer id);

	@GetMapping("/noticia/listar")
	public ResponseEntity<List<NoticiaDTO>> listar();

	@PostMapping("/noticia/criar")
	public ResponseEntity<NoticiaDTO> criar(@RequestBody NoticiaDTO noticiaDTO);

	@PutMapping("/noticia/atualizar")
	public ResponseEntity<NoticiaDTO> atualizar(@RequestBody NoticiaDTO noticiaDTO);

	@DeleteMapping("/noticia/excluir")
	public ResponseEntity<Void> excluir(@RequestBody NoticiaDTO noticiaDTO);
	
}
