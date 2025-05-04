package com.spring.boot.bff.mobile.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.bff.mobile.app.client.NoticiaClient;
import com.spring.boot.bff.mobile.app.dto.ImportanciaDTO;
import com.spring.boot.bff.mobile.app.dto.NoticiaDTO;
import com.spring.boot.bff.mobile.app.handle.HandleException;
import com.spring.boot.bff.mobile.app.util.Util;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoticiaService {

	@Autowired
	private NoticiaClient noticiaClient;

	public NoticiaDTO buscarId(Integer id) throws HandleException {

		ResponseEntity<NoticiaDTO> response = noticiaClient.buscarId(id);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public List<NoticiaDTO> listar() throws HandleException {

		ResponseEntity<List<NoticiaDTO>> response = noticiaClient.listar();

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public NoticiaDTO criar(NoticiaDTO noticiaRepositoryDTO) throws HandleException {

		ResponseEntity<NoticiaDTO> response = noticiaClient.criar(noticiaRepositoryDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public NoticiaDTO atualizar(NoticiaDTO noticiaRepositoryDTO) throws HandleException {

		ResponseEntity<NoticiaDTO> response = noticiaClient.atualizar(noticiaRepositoryDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public void excluir(NoticiaDTO noticiaRepositoryDTO) throws HandleException{
		
		ResponseEntity<Void> response = noticiaClient.excluir(noticiaRepositoryDTO);
		
		Util.validarResponse204(response.getStatusCode().value());
		
	}

	public List<NoticiaDTO> listarNoticiaCategoria(NoticiaDTO noticiaDTO) {
		return null;
	}

	public NoticiaDTO inserirNoticiaCategoria(NoticiaDTO noticiaDTO) {
		return null;
	}

}
