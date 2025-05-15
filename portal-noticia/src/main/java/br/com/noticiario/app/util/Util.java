package br.com.noticiario.app.util;

import org.springframework.http.HttpStatus;

import br.com.noticiario.app.handle.HandleException;

public class Util {

	
	public static void validarResponse204(int response) throws HandleException {
		
		if(response == 204) {
			throw new HandleException("NO_CONTENT", HttpStatus.NO_CONTENT);
		}
	}
}
