package com.spring.boot.bff.mobile.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.bff.mobile.app.client.ImportanciaClient;
import com.spring.boot.bff.mobile.app.dto.ImportanciaDTO;
import com.spring.boot.bff.mobile.app.handle.HandleException;
import com.spring.boot.bff.mobile.app.util.Util;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImportanciaService {

	@Autowired
	private ImportanciaClient importanciaClient;

	public ImportanciaDTO buscarId(Integer id) throws HandleException {

		ResponseEntity<ImportanciaDTO> response = importanciaClient.buscarId(id);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public List<ImportanciaDTO> listar() throws HandleException {

		ResponseEntity<List<ImportanciaDTO>> response = importanciaClient.listar();

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public ImportanciaDTO criarImportancia(ImportanciaDTO importanciaDTO) throws HandleException {

		ResponseEntity<ImportanciaDTO> response = importanciaClient.criar(importanciaDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public ImportanciaDTO atualizar(ImportanciaDTO importanciaDTO) throws HandleException {

		ResponseEntity<ImportanciaDTO> response = importanciaClient.atualizar(importanciaDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public void excluir(ImportanciaDTO importanciaDTO) throws HandleException {

		ResponseEntity<Void> response = importanciaClient.excluir(importanciaDTO);

		Util.validarResponse204(response.getStatusCode().value());
	}

}
