package br.com.api.sub.categoria.app.model;

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
@Table(name = "sub_categoria")
public class SubCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "sub_categoria ")
	private String subCategoria;

	@Column(name = "criado_em")
	private LocalDateTime criadoEm;

	@Column(name = "categoria_id ")
	private Integer categoriaId;

}
