package com.spring.boot.api.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.api.app.model.CategoriaNoticias;

public interface SistemaApiRepository extends JpaRepository<CategoriaNoticias, Integer>{


}
