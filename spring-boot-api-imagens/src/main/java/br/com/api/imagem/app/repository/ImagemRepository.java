package br.com.api.imagem.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.imagem.app.model.Imagem;


@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

	Optional<Imagem> findByNoticiaId(Integer noticiaId);
}
