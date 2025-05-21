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
@Table(name = "prioridade")
public class Prioridade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Column(name = "prioridade ")
	private String prioridade;
	
	@Column(name = "prioridade_desc ")
	private String prioridadeDesc;
	
	@Column(name = "criado_em ")
	private LocalDateTime criadoEm;
}
