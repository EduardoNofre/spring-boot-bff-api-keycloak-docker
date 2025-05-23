package br.com.api.sub.categoria.app.handle;

import org.springframework.http.HttpStatus;

/**
 * Tratamento de Erro
 * @author equipe.arquitetura
 *
 */
public class HandleException extends Exception {

	private static final long serialVersionUID = 6376559008232800045L;

	private final HttpStatus status;
	
	public HandleException(String message, HttpStatus status) {
		super(message);
		this.status  = status;
	}

	/**
	 * Utilizar para manter a rastreabilidade das exceções - LOG
	 * @param message
	 * @param cause
	 */
	public HandleException(String message, Throwable cause,HttpStatus status) {
		super(message, cause);
		this.status  = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
}
