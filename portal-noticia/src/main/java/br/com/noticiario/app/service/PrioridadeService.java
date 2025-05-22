package br.com.noticiario.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.noticiario.app.client.PrioridadeClient;
import br.com.noticiario.app.dto.PrioridadeDTO;
import br.com.noticiario.app.handle.HandleException;
import br.com.noticiario.app.util.Util;

@Service
public class PrioridadeService {

	@Autowired
	private PrioridadeClient prioridadeClient;

	public List<PrioridadeDTO> prioridades() throws HandleException {

		ResponseEntity<List<PrioridadeDTO>> response = prioridadeClient.listaPrioridade();

		if(response.getStatusCode().value() == 204){
			List<PrioridadeDTO> nenhumaPrioridadeEncontrada = null;
			return nenhumaPrioridadeEncontrada; 
		}

		return response.getBody();
	}

	public void salvar(PrioridadeDTO prioridadeDTO) throws HandleException {

		ResponseEntity<PrioridadeDTO> response = prioridadeClient.salvarPrioridade(prioridadeDTO);

		// TO DO DIALOG
		Util.validarResponse204(response.getStatusCode().value());

	}

	public void editar(PrioridadeDTO prioridadeDTO) throws HandleException {

		ResponseEntity<PrioridadeDTO> response = prioridadeClient.salvarPrioridade(prioridadeDTO);

		// TO DO DIALOG
		Util.validarResponse204(response.getStatusCode().value());

	}

	public void excluir(PrioridadeDTO prioridadeDTO) throws HandleException {

		prioridadeClient.excluirPrioridade(prioridadeDTO);
	}

	public boolean validarCampos() {

		return false;
	}
}
