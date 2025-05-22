package br.com.noticiario.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.noticiario.app.client.CategoriaClient;
import br.com.noticiario.app.client.NoticiaClient;
import br.com.noticiario.app.dto.CategoriaDTO;
import br.com.noticiario.app.handle.HandleException;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaClient noticiaClient;
	
	@Autowired
	private CategoriaClient categoriaClient;
	
	public List<CategoriaDTO> categorias() throws HandleException {

		List<CategoriaDTO> nenhumaCategoriaEncontrada = null;
		ResponseEntity<List<CategoriaDTO>> response = categoriaClient.listaCategoria();

		if(response.getStatusCode().value() == 204){
			
			return nenhumaCategoriaEncontrada; 
		}

		return response.getBody();
	}
}
