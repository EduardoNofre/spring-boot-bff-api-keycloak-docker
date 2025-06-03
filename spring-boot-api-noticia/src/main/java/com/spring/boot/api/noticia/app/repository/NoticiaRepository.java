package com.spring.boot.api.noticia.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.api.noticia.app.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

		List<Noticia> findByCategoriaId(Integer categoriaId);

}
