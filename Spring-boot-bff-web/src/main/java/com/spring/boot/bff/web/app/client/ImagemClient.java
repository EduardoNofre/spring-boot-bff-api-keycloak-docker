package com.spring.boot.bff.web.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.spring.boot.bff.web.app.dto.ImagemDTO;
import com.spring.boot.bff.web.app.handle.HandleException;

@FeignClient(url = "${api.client.api.image.url}", name = "imagem")
public interface ImagemClient {

	@GetMapping(value = "/imagem")
	public ResponseEntity<byte[]> ImagemDownload(@RequestParam String servidor,@RequestParam(required = true) String repositorio, @RequestParam(required = true) String imagem) throws HandleException;


	@PostMapping(value = "/imagem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ImagemDTO> ImagemUpload(@RequestPart MultipartFile imagem) throws HandleException;

	@DeleteMapping(value = "/imagem")
	public ResponseEntity<Void> deletarImagem(@RequestParam Integer idNoticia) throws HandleException;

}
