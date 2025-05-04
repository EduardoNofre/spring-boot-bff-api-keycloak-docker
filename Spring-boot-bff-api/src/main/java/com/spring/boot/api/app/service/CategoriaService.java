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

	public CategoriaDTO buscarId(Integer id) throws HandleException {

		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isEmpty()) {
			throw new HandleException("NENHUMA ID PARA A CATEGORIA ECONTRADA", HttpStatus.NO_CONTENT);

		}

		return modelMapper.map(categoria.get(), new TypeToken<CategoriaDTO>() {
		}.getType());

	}

	public List<CategoriaDTO> listaCategoria() throws HandleException {

		List<Categoria> categoria = categoriaRepository.findAll();

		if (CollectionUtils.isEmpty(categoria)) {

			throw new HandleException("NENHUMA CATEGORIA ECONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(categoria, new TypeToken<List<CategoriaDTO>>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {

		Categoria entity = modelMapper.map(categoriaDTO, new TypeToken<Categoria>() {
		}.getType());

		return modelMapper.map(categoriaRepository.save(entity), new TypeToken<CategoriaDTO>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public CategoriaDTO atualizarCategoria(CategoriaDTO categoriaDTO) throws HandleException {

		if(categoriaRepository.findById(categoriaDTO.getId()).isPresent()) {

			Categoria entity = modelMapper.map(categoriaDTO, new TypeToken<Categoria>() {}.getType());

			return modelMapper.map(categoriaRepository.save(entity), new TypeToken<CategoriaDTO>() {}.getType());
		}

		throw new HandleException("A CATEGORIA NÃO PODE SER ATUALIZADA", HttpStatus.CONFLICT);
	}

	@Transactional(rollbackOn = Exception.class)
	public void excluirCategoria(CategoriaDTO categoriaDTO) {

		if(categoriaRepository.findById(categoriaDTO.getId()).isPresent()) {

			Categoria entity = modelMapper.map(categoriaDTO, new TypeToken<Categoria>() {}.getType());
			
			categoriaRepository.delete(entity);
		}
	}
}
