package br.com.api.imagem.app.model;

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
@Table(name = "imagem")
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "repositorio ")
	private String repositorio;

	@Column(name = "servidor ")
	private String servidor;

	@Column(name = "imagem ")
	private String imagem;
	
	@Column(name = "criadoEm ")
	private LocalDateTime criadoEm;

	@Column(name = "noticia_id ")
	private Integer noticiaId;

}
