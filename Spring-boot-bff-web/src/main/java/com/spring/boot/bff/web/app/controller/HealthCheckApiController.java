package com.spring.boot.bff.web.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

/**
 * Classe controller responsável por verificar se as funcionalidades dos
 * serviços OK.
 * 
 * @author equipe.arquitetura
 */

@RestController
@RequestMapping("/health-check")
@Hidden
public class HealthCheckApiController {

	@GetMapping
	public ResponseEntity<Void> healthCheck() {
		return ResponseEntity.ok().build();
	}
}
