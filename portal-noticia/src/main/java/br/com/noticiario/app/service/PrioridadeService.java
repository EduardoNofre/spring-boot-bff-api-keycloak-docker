package br.com.noticiario.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noticiario.app.client.PrioridadeClient;

@Service
public class PrioridadeService {

	@Autowired
	private PrioridadeClient prioridadeClient;
}
