package com.spring.boot.api.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "importancia")
public class Importancia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(name = "importancia ")
	private String importancia;
	
	@Column(name = "importancias_desc ")
	private String importanciasDesc;
	
	@Column(name = "criado_em ")
	private LocalDateTime criadoEm;
}
