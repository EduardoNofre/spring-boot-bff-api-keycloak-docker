package com.spring.boot.bff.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.bff.web.app.client.CategoriaClient;
import com.spring.boot.bff.web.app.dto.CategoriaDTO;
import com.spring.boot.bff.web.app.handle.HandleException;
import com.spring.boot.bff.web.app.util.Util;

import lombok.Data;

@Data
@Service
public class CategoriaService {

	@Autowired
	private final CategoriaClient categoriaClient;

	public CategoriaDTO buscarId(Integer id) throws HandleException {

		ResponseEntity<CategoriaDTO> response = categoriaClient.buscarId(id);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public List<CategoriaDTO> listaCategorias() throws HandleException {

		ResponseEntity<List<CategoriaDTO>> response = categoriaClient.listaCategoria();

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) throws HandleException {

		ResponseEntity<CategoriaDTO> response = categoriaClient.criarCategoria(categoriaDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public CategoriaDTO atualizarCategoria(CategoriaDTO categoriaDTO) throws HandleException {

		ResponseEntity<CategoriaDTO> response = categoriaClient.atualizar(categoriaDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public void excluirCategoria(CategoriaDTO categoriaDTO) throws HandleException {

		ResponseEntity<Void> response = categoriaClient.excluir(categoriaDTO);

		Util.validarResponse204(response.getStatusCode().value());

	}
}
