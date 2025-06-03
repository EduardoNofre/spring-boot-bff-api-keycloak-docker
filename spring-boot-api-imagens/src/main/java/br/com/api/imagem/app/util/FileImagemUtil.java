package br.com.api.imagem.app.util;

import java.io.File;

import org.springframework.http.HttpStatus;

import br.com.api.imagem.app.handle.HandleException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileImagem {

	public static void validarPath(File file) throws HandleException {

		if (file.isDirectory()) {
			log.info("CAMINHO VALIDO {} ", file.getAbsolutePath());
			return;
		}

		throw new HandleException(" CAMINHO INVALIDO ", HttpStatus.CONFLICT);
	}

	public static void validarArquivo(String nomefile) throws HandleException {

		if (nomefile.toUpperCase().endsWith("PNG")) {
			log.info("ARQUIVO VALIDO {} ", nomefile);
			return;
		}

		throw new HandleException(" SOMENTE ARQUIVOS .PNG ", HttpStatus.CONFLICT);
	}
	
	
	public static boolean arquivoExiste(String exiteFileName) throws HandleException {
		
		File arquivo = new File(exiteFileName);

		if (arquivo.exists()) {
			log.info("ARQUIVO ENCONTRADO {} ", exiteFileName);
			return true;
		}

		return false;
		//throw new HandleException(" ARQUIVO NÃO ENCONTRADO ", HttpStatus.CONFLICT);
	}
	
	
	public static void arquivoExcluir(String deleteFile) throws HandleException {

		File arquivo = new File(deleteFile);

		if (arquivo.delete()) {
			log.info("EXCLUIDO COM SUCESSO {} ", arquivo);
			return;
		}

		throw new HandleException(" NÃO FOI POSSIVEL EXCLUIR O ARQUIVO ", HttpStatus.CONFLICT);
	}
}
