package br.com.noticiario.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.noticiario.app.client.SubCategoriaClient;
import br.com.noticiario.app.dto.SubCategoriaDTO;
import br.com.noticiario.app.handle.HandleException;
import br.com.noticiario.app.util.Util;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubCategoriaService {

	private SubCategoriaClient subCategoriaClient;

	public List<SubCategoriaDTO> subCategoriaListar() throws HandleException {

		List<SubCategoriaDTO> nenhumaSubCategoriaEncontrada = null;
		ResponseEntity<List<SubCategoriaDTO>> response = subCategoriaClient.subCategoriaListar();

		if (response.getStatusCode().value() == 204) {

			return nenhumaSubCategoriaEncontrada;
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

	public SubCategoriaDTO subCategoriaAtualizar(SubCategoriaDTO subCategoriaDTO) throws HandleException {

		ResponseEntity<SubCategoriaDTO> response = subCategoriaClient.subCategoriaAtualizar(subCategoriaDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}
}
