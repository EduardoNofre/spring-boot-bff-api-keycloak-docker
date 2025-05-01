package com.spring.boot.api.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.api.app.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{


}
