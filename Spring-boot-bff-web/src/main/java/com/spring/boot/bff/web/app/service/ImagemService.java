package com.spring.boot.bff.web.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.bff.web.app.client.ImagemClient;
import com.spring.boot.bff.web.app.dto.ImagemDTO;
import com.spring.boot.bff.web.app.handle.HandleException;
import com.spring.boot.bff.web.app.util.Util;

@Service
public class ImagemService {

	@Autowired
	private ImagemClient imagemClient;

	@GetMapping()
	public byte[] ImagemDownload(String servidor, String repositorio, String imagem) throws HandleException {

		ResponseEntity<byte[]> response = imagemClient.ImagemDownload(servidor, repositorio, imagem);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	@PostMapping()
	public ImagemDTO ImagemUpload(MultipartFile imagem) throws HandleException {

		ResponseEntity<ImagemDTO> response = imagemClient.ImagemUpload(imagem);

		Util.validarResponse204(response.getStatusCode().value());

		return response.getBody();
	}

	@DeleteMapping()
	public void deletarImagem(Integer idNoticia) throws HandleException {

		imagemClient.deletarImagem(idNoticia);

	}
}
