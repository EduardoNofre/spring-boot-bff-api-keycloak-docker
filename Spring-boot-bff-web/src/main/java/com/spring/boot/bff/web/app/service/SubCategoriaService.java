package com.spring.boot.bff.web.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.bff.web.app.client.SubCategoriaClient;
import com.spring.boot.bff.web.app.dto.SubCategoriaDTO;
import com.spring.boot.bff.web.app.handle.HandleException;
import com.spring.boot.bff.web.app.util.Util;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubCategoriaService {

	@Autowired
	private SubCategoriaClient subCategoriaClient;

	public List<SubCategoriaDTO> subCategoriaListar() throws HandleException {

		ResponseEntity<List<SubCategoriaDTO>> response = subCategoriaClient.subCategoriaListar();

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public List<SubCategoriaDTO> subCategoriaListarCategoria(Integer idCategoriaFk) throws HandleException {

		ResponseEntity<List<SubCategoriaDTO>> response = subCategoriaClient.subCategoriaListarCategoria(idCategoriaFk);

		if (response.getStatusCode().value() == 204) {
			List<SubCategoriaDTO> listaVazia = new ArrayList<>();

			return listaVazia;

		}

		return response.getBody();
	}

	public SubCategoriaDTO subCategoriaInserir(String subCategoria, Integer categoriaId) throws HandleException {

		ResponseEntity<SubCategoriaDTO> response = subCategoriaClient.subCategoriaInserir(subCategoria, categoriaId);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public void subCategoriaExcluir(SubCategoriaDTO subCategoriaDTO) {

		subCategoriaClient.subCategoriaExcluir(subCategoriaDTO);

	}

	public SubCategoriaDTO SubCategoriaAtualizar(SubCategoriaDTO subCategoriaDTO) throws HandleException {

		ResponseEntity<SubCategoriaDTO> response = subCategoriaClient.subCategoriaAtualizar(subCategoriaDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}
}
