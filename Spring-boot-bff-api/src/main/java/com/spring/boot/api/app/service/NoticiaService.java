package com.spring.boot.api.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spring.boot.api.app.dto.NoticiaDTO;
import com.spring.boot.api.app.handle.HandleException;
import com.spring.boot.api.app.model.Noticia;
import com.spring.boot.api.app.repository.NoticiaRepository;

import jakarta.transaction.Transactional;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository noticiaPrincipalRepositoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	public NoticiaDTO buscarId(Integer id) throws HandleException {

		Optional<Noticia> noticiaPrincipalRepositoryNoticia = noticiaPrincipalRepositoryRepository.findById(id);

		if (noticiaPrincipalRepositoryNoticia.isEmpty()) {
			throw new HandleException("NENHUMA NOTICIA PRINCIPAL ECONTRADA", HttpStatus.NO_CONTENT);

		}

		return modelMapper.map(noticiaPrincipalRepositoryNoticia.get(), new TypeToken<NoticiaDTO>() {
		}.getType());

	}

	public List<NoticiaDTO> listaNoticia() throws HandleException {

		List<Noticia> noticiaPrincipalRepositoryNoticia = noticiaPrincipalRepositoryRepository.findAll();

		if (CollectionUtils.isEmpty(noticiaPrincipalRepositoryNoticia)) {

			throw new HandleException("NENHUMA NOTICIA PRINCIPAL ECONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(noticiaPrincipalRepositoryNoticia, new TypeToken<List<NoticiaDTO>>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public NoticiaDTO criarNoticia(NoticiaDTO noticiaPrincipalRepositoryDTO) {

		Noticia entity = modelMapper.map(noticiaPrincipalRepositoryDTO, new TypeToken<Noticia>() {
		}.getType());

		return modelMapper.map(noticiaPrincipalRepositoryRepository.save(entity), new TypeToken<NoticiaDTO>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public NoticiaDTO atualizarNoticia(NoticiaDTO noticiaPrincipalRepositoryDTO) throws HandleException {

		if(noticiaPrincipalRepositoryRepository.findById(noticiaPrincipalRepositoryDTO.getId()).isPresent()) {

			Noticia entity = modelMapper.map(noticiaPrincipalRepositoryDTO, new TypeToken<Noticia>() {}.getType());

			return modelMapper.map(noticiaPrincipalRepositoryRepository.save(entity), new TypeToken<NoticiaDTO>() {}.getType());
		}

		throw new HandleException("A NOTICIA PRINCIPAL NÃO PODE SER ATUALIZADA", HttpStatus.CONFLICT);
	}

	@Transactional(rollbackOn = Exception.class)
	public void excluirNoticia(NoticiaDTO noticiaPrincipalRepositoryDTO) {

		if(noticiaPrincipalRepositoryRepository.findById(noticiaPrincipalRepositoryDTO.getId()).isPresent()) {

			Noticia entity = modelMapper.map(noticiaPrincipalRepositoryDTO, new TypeToken<Noticia>() {}.getType());
			
			noticiaPrincipalRepositoryRepository.delete(entity);
		}
	}
}
