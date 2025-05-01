package com.spring.boot.api.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spring.boot.api.app.dto.NoticiaPrincipalDTO;
import com.spring.boot.api.app.handle.HandleException;
import com.spring.boot.api.app.model.NoticiaPrincipal;
import com.spring.boot.api.app.repository.NoticiaPrincipalRepository;

import jakarta.transaction.Transactional;

@Service
public class NoticiaPrincipalService {

	@Autowired
	private NoticiaPrincipalRepository noticiaPrincipalRepositoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	public NoticiaPrincipalDTO buscarId(Integer id) throws HandleException {

		Optional<NoticiaPrincipal> noticiaPrincipalRepositoryNoticiaPrincipal = noticiaPrincipalRepositoryRepository.findById(id);

		if (noticiaPrincipalRepositoryNoticiaPrincipal.isEmpty()) {
			throw new HandleException("NENHUMA NOTICIA PRINCIPAL ECONTRADA", HttpStatus.NO_CONTENT);

		}

		return modelMapper.map(noticiaPrincipalRepositoryNoticiaPrincipal.get(), new TypeToken<NoticiaPrincipalDTO>() {
		}.getType());

	}

	public List<NoticiaPrincipalDTO> listaNoticiaPrincipalRelacionadas() throws HandleException {

		List<NoticiaPrincipal> noticiaPrincipalRepositoryNoticiaPrincipal = noticiaPrincipalRepositoryRepository.findAll();

		if (CollectionUtils.isEmpty(noticiaPrincipalRepositoryNoticiaPrincipal)) {

			throw new HandleException("NENHUMA NOTICIA PRINCIPAL ECONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(noticiaPrincipalRepositoryNoticiaPrincipal, new TypeToken<List<NoticiaPrincipalDTO>>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public NoticiaPrincipalDTO criarNoticiaPrincipal(NoticiaPrincipalDTO noticiaPrincipalRepositoryDTO) {

		NoticiaPrincipal entity = modelMapper.map(noticiaPrincipalRepositoryDTO, new TypeToken<NoticiaPrincipal>() {
		}.getType());

		return modelMapper.map(noticiaPrincipalRepositoryRepository.save(entity), new TypeToken<NoticiaPrincipalDTO>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public NoticiaPrincipalDTO atualizarNoticiaPrincipal(NoticiaPrincipalDTO noticiaPrincipalRepositoryDTO) throws HandleException {

		if(noticiaPrincipalRepositoryRepository.findById(noticiaPrincipalRepositoryDTO.getId()).isPresent()) {

			NoticiaPrincipal entity = modelMapper.map(noticiaPrincipalRepositoryDTO, new TypeToken<NoticiaPrincipal>() {}.getType());

			return modelMapper.map(noticiaPrincipalRepositoryRepository.save(entity), new TypeToken<NoticiaPrincipalDTO>() {}.getType());
		}

		throw new HandleException("A NOTICIA PRINCIPAL NÃO PODE SER ATUALIZADA", HttpStatus.CONFLICT);
	}

	@Transactional(rollbackOn = Exception.class)
	public void excluirNoticiaPrincipal(NoticiaPrincipalDTO noticiaPrincipalRepositoryDTO) {

		if(noticiaPrincipalRepositoryRepository.findById(noticiaPrincipalRepositoryDTO.getId()).isPresent()) {

			NoticiaPrincipal entity = modelMapper.map(noticiaPrincipalRepositoryDTO, new TypeToken<NoticiaPrincipal>() {}.getType());
			
			noticiaPrincipalRepositoryRepository.delete(entity);
		}
	}
}
