package com.spring.boot.api.prioridade.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.api.prioridade.app.model.Prioridade;

public interface PrioridadeRepository extends JpaRepository<Prioridade, Integer>{

}
