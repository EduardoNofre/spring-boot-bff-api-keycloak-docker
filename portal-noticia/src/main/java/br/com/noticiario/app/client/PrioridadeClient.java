package br.com.noticiario.app.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "${api.client.url}", name = "PrioridadeClient")
public interface PrioridadeClient {

}
