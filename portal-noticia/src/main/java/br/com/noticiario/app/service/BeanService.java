package br.com.noticiario.app.service;

import org.springframework.stereotype.Service;

@Service
public class BeanService {

	
	public String ola(String msg) {
		
		return "Olá service, " + msg + "!";
	}
}
