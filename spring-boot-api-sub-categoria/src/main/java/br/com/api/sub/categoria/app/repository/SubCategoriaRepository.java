package br.com.api.sub.categoria.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.sub.categoria.app.model.SubCategoria;
import java.util.List;


@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Integer>{

	
	List<SubCategoria> findByCategoriaId(Integer categoriaId);
}
