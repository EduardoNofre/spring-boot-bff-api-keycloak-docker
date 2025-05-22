package br.com.noticiario.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.noticiario.app.dto.PrioridadeDTO;

@FeignClient(url = "${api.client.bff.web.url}", name = "prioridadeClient")
public interface PrioridadeClient {

	@GetMapping("/bff-web-prioridade/bff-lista")
	public ResponseEntity<List<PrioridadeDTO>> listaPrioridade();	
	
	@PostMapping("/bff-web-prioridade/bff-criar")
	public ResponseEntity<PrioridadeDTO> salvarPrioridade(@RequestBody PrioridadeDTO prioridadeDTO);
	
	@PutMapping("/bff-web-prioridade/bff-atualizar")
	public ResponseEntity<PrioridadeDTO> editarPrioridade(@RequestBody PrioridadeDTO prioridadeDTO);
	
	
	@DeleteMapping("/bff-web-prioridade/bff-excluir")
	public ResponseEntity<Void> excluirPrioridade(@RequestBody PrioridadeDTO prioridadeDTO);

}
