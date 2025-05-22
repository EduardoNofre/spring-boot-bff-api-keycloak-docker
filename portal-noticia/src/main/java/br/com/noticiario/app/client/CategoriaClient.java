package br.com.noticiario.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.noticiario.app.dto.CategoriaDTO;

@FeignClient(url = "${api.client.bff.web.url}", name = "categoriaClient")
public interface CategoriaClient {
	
	@GetMapping("/bff-web-categoria/bff-lista")
	public ResponseEntity<List<CategoriaDTO>> listaCategoria();	
	
	@PostMapping("/bff-web-categoria/bff-criar")
	public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaDTO categoriaDTO);
	
	@PutMapping("/bff-web-categoria/bff-atualizar")
	public ResponseEntity<CategoriaDTO> editarCategoria(@RequestBody CategoriaDTO categoriaDTO);
	
	
	@DeleteMapping("/bff-web-categoria/bff-excluir")
	public ResponseEntity<Void> excluirCategoria(@RequestBody CategoriaDTO categoriaDTO);

}
