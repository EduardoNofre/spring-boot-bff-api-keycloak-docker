package br.com.noticiario.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noticiario.app.client.NoticiaClient;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaClient noticiaClient;
}
