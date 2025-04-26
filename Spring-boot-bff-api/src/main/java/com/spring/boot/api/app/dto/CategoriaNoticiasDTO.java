package com.spring.boot.api.app.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.spring.boot.api.app.model.NoticiaEconomia;
import com.spring.boot.api.app.model.NoticiaEsportes;
import com.spring.boot.api.app.model.NoticiaPolitica;
import com.spring.boot.api.app.model.NoticiaPrincipal;

import lombok.Data;

@Data
public class CategoriaNoticiasDTO {

	private Integer id_cad;

	private String tipoNoticiasCad;

	private String tipoNoticiasDescCad;

	private LocalDateTime dataHrInclusao;

	private LocalDateTime criadoEm;

	private List<NoticiaEconomia> noticiaEconomia;

	private List<NoticiaEsportes> noticiaEsportes;

	private List<NoticiaPolitica> noticiaPolitica;

	private List<NoticiaPrincipal> noticiaPrincipal;
}
