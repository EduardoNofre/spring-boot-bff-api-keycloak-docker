package com.spring.boot.api.prioridade.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spring.boot.api.prioridade.app.dto.PrioridadeDTO;
import com.spring.boot.api.prioridade.app.handle.HandleException;
import com.spring.boot.api.prioridade.app.model.Prioridade;
import com.spring.boot.api.prioridade.app.repository.PrioridadeRepository;

import jakarta.transaction.Transactional;

@Service
public class PrioridadeService {

	@Autowired
	private PrioridadeRepository prioridadeRepository;

	@Autowired
	private ModelMapper modelMapper;

	public PrioridadeDTO buscarId(Integer id) throws HandleException {

		Optional<Prioridade> prioridade = prioridadeRepository.findById(id);

		if (prioridade.isEmpty()) {
			throw new HandleException("NENHUMA NOTICIA ECONTRADA", HttpStatus.NO_CONTENT);

		}

		return modelMapper.map(prioridade.get(), new TypeToken<PrioridadeDTO>() {
		}.getType());

	}

	public List<PrioridadeDTO> listar() throws HandleException {

		List<Prioridade> prioridade = prioridadeRepository.findAll();

		if (CollectionUtils.isEmpty(prioridade)) {

			throw new HandleException("NENHUMA NOTICIA ECONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(prioridade, new TypeToken<List<PrioridadeDTO>>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public PrioridadeDTO criarPrioridade(PrioridadeDTO prioridadeDTO) {

		Prioridade entity = modelMapper.map(prioridadeDTO, new TypeToken<Prioridade>() {
		}.getType());

		return modelMapper.map(prioridadeRepository.save(entity), new TypeToken<PrioridadeDTO>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public PrioridadeDTO atualizar(PrioridadeDTO prioridadeDTO) throws HandleException {

		if(prioridadeRepository.findById(prioridadeDTO.getId()).isPresent()) {

			Prioridade entity = modelMapper.map(prioridadeDTO, new TypeToken<Prioridade>() {}.getType());

			return modelMapper.map(prioridadeRepository.save(entity), new TypeToken<PrioridadeDTO>() {}.getType());
		}

		throw new HandleException("A noticia não pode ser atualizada", HttpStatus.CONFLICT);
	}

	@Transactional(rollbackOn = Exception.class)
	public void excluir(PrioridadeDTO prioridadeDTO) {

		if(prioridadeRepository.findById(prioridadeDTO.getId()).isPresent()) {

			Prioridade entity = modelMapper.map(prioridadeDTO, new TypeToken<Prioridade>() {}.getType());

			prioridadeRepository.delete(entity);
		}
	}
}
