package br.com.noticiario.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.noticiario.app.client.CategoriaClient;
import br.com.noticiario.app.dto.CategoriaDTO;
import br.com.noticiario.app.handle.HandleException;
import br.com.noticiario.app.util.Util;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaClient categoriaClient;

	public List<CategoriaDTO> categorias() throws HandleException {

		ResponseEntity<List<CategoriaDTO>> response = categoriaClient.listaCategoria();

		// TO DO DIALOG
		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public void salvar(CategoriaDTO categoriaDTO) throws HandleException {

		ResponseEntity<CategoriaDTO> response = categoriaClient.salvarCategoria(categoriaDTO);

		// TO DO DIALOG
		Util.validarResponse204(response.getStatusCode().value());

	}

	public void editar(CategoriaDTO categoriaDTO) throws HandleException {

		ResponseEntity<CategoriaDTO> response = categoriaClient.salvarCategoria(categoriaDTO);

		// TO DO DIALOG
		Util.validarResponse204(response.getStatusCode().value());

	}

	public void excluir(CategoriaDTO categoriaDTO) throws HandleException {

		categoriaClient.excluirCategoria(categoriaDTO);
	}
	
	
	public boolean validarCampos() {
		
		return false;
	}
}
