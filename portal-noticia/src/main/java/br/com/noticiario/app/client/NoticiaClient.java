package br.com.noticiario.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.noticiario.app.dto.CategoriaDTO;

@FeignClient(url = "${api.client.url}", name = "noticiaClient")
public interface NoticiaClient {

}
