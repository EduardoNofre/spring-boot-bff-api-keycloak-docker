package com.spring.boot.bff.web.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.boot.bff.web.app.client.PrioridadeClient;
import com.spring.boot.bff.web.app.dto.PrioridadeDTO;
import com.spring.boot.bff.web.app.handle.HandleException;
import com.spring.boot.bff.web.app.util.Util;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PrioridadeService {

	@Autowired
	private PrioridadeClient prioridadeClient;

	public PrioridadeDTO buscarId(Integer id) throws HandleException {

		ResponseEntity<PrioridadeDTO> response = prioridadeClient.buscarId(id);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public List<PrioridadeDTO> listar() throws HandleException {

		ResponseEntity<List<PrioridadeDTO>> response = prioridadeClient.listar();

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public PrioridadeDTO criarPrioridade(PrioridadeDTO prioridadeDTO) throws HandleException {

		ResponseEntity<PrioridadeDTO> response = prioridadeClient.criar(prioridadeDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public PrioridadeDTO atualizar(PrioridadeDTO prioridadeDTO) throws HandleException {

		ResponseEntity<PrioridadeDTO> response = prioridadeClient.atualizar(prioridadeDTO);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	public void excluir(PrioridadeDTO prioridadeDTO) throws HandleException {

		ResponseEntity<Void> response = prioridadeClient.excluir(prioridadeDTO);

		Util.validarResponse204(response.getStatusCode().value());
	}

}
