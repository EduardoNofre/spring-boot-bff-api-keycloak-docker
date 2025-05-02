package com.spring.boot.api.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spring.boot.api.app.dto.ImportanciaDTO;
import com.spring.boot.api.app.handle.HandleException;
import com.spring.boot.api.app.model.Importancia;
import com.spring.boot.api.app.repository.ImportanciaRepository;

import jakarta.transaction.Transactional;

@Service
public class ImportanciaService {

	@Autowired
	private ImportanciaRepository importanciaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ImportanciaDTO buscarId(Integer id) throws HandleException {

		Optional<Importancia> importancia = importanciaRepository.findById(id);

		if (importancia.isEmpty()) {
			throw new HandleException("NENHUMA NOTICIA ECONTRADA", HttpStatus.NO_CONTENT);

		}

		return modelMapper.map(importancia.get(), new TypeToken<ImportanciaDTO>() {
		}.getType());

	}

	public List<ImportanciaDTO> listar() throws HandleException {

		List<Importancia> importancia = importanciaRepository.findAll();

		if (CollectionUtils.isEmpty(importancia)) {

			throw new HandleException("NENHUMA NOTICIA ECONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(importancia, new TypeToken<List<ImportanciaDTO>>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public ImportanciaDTO criarImportancia(ImportanciaDTO importanciaDTO) {

		Importancia entity = modelMapper.map(importanciaDTO, new TypeToken<Importancia>() {
		}.getType());

		return modelMapper.map(importanciaRepository.save(entity), new TypeToken<ImportanciaDTO>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public ImportanciaDTO atualizar(ImportanciaDTO importanciaDTO) throws HandleException {

		if(importanciaRepository.findById(importanciaDTO.getId()).isPresent()) {

			Importancia entity = modelMapper.map(importanciaDTO, new TypeToken<Importancia>() {}.getType());

			return modelMapper.map(importanciaRepository.save(entity), new TypeToken<ImportanciaDTO>() {}.getType());
		}

		throw new HandleException("A noticia não pode ser atualizada", HttpStatus.CONFLICT);
	}

	@Transactional(rollbackOn = Exception.class)
	public void excluir(ImportanciaDTO importanciaDTO) {

		if(importanciaRepository.findById(importanciaDTO.getId()).isPresent()) {

			Importancia entity = modelMapper.map(importanciaDTO, new TypeToken<Importancia>() {}.getType());

			importanciaRepository.delete(entity);
		}
	}
}
