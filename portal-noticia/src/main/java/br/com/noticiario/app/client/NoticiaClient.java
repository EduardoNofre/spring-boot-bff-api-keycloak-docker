package br.com.noticiario.app.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "${api.client.bff.web.url}", name = "noticiaClient")
public interface NoticiaClient {

}
