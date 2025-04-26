package com.spring.boot.api.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SistemaApiController {

	@GetMapping("/noticias")
	public void listaNoticias() {

	}

	@GetMapping("/noticias-relacionadas")
	public void listaNoticiasRelacionadas() {

	}

	@PostMapping("criar")
	public void criarNoticias() {

	}

	@PutMapping("atualizar")
	public void atualizarNoticias() {

	}

	@DeleteMapping("excluir")
	public void excluirNoticias() {

	}

}
