package com.spring.boot.api.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spring.boot.api.app.dto.CategoriaDTO;
import com.spring.boot.api.app.handle.HandleException;
import com.spring.boot.api.app.model.Categoria;
import com.spring.boot.api.app.repository.CategoriaRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CategoriaDTO listaNoticias(Integer id) throws HandleException {

		Optional<Categoria> categoriaNoticias = categoriaRepository.findById(id);

		if (categoriaNoticias.isEmpty()) {
			throw new HandleException("NENHUMA NOTICIA ECONTRADA", HttpStatus.NO_CONTENT);

		}

		return modelMapper.map(categoriaNoticias.get(), new TypeToken<CategoriaDTO>() {
		}.getType());

	}

	public List<CategoriaDTO> listaNoticiasRelacionadas() throws HandleException {

		List<Categoria> categoriaNoticias = categoriaRepository.findAll();

		if (CollectionUtils.isEmpty(categoriaNoticias)) {

			throw new HandleException("NENHUMA NOTICIA ECONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(categoriaNoticias, new TypeToken<List<CategoriaDTO>>() {
		}.getType());
	}

	
	@Transactional
	public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
		
		Categoria entity = modelMapper.map(categoriaDTO, new TypeToken<Categoria>() {
		}.getType());

		
		return modelMapper.map(categoriaRepository.save(entity), new TypeToken<CategoriaDTO>() {
		}.getType());
	}


	public void atualizarNoticias() {

	}

	public void excluirNoticias() {

	}
}
