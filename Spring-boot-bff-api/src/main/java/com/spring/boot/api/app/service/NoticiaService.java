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
import com.spring.boot.api.app.repository.CategoriaRepository;
import com.spring.boot.api.app.repository.NoticiaRepository;

import jakarta.transaction.Transactional;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository noticiaRepositoryRepository;

	@Autowired
	private CategoriaRepository CategoriaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public NoticiaDTO buscarId(Integer id) throws HandleException {

		Optional<Noticia> noticiaRepositoryNoticia = noticiaRepositoryRepository.findById(id);

		if (noticiaRepositoryNoticia.isEmpty()) {
			throw new HandleException("NENHUMA NOTICIA ENCONTRADA", HttpStatus.NO_CONTENT);

		}

		return modelMapper.map(noticiaRepositoryNoticia.get(), new TypeToken<NoticiaDTO>() {
		}.getType());

	}

	public List<NoticiaDTO> listaNoticia() throws HandleException {

		List<Noticia> noticiaRepositoryNoticia = noticiaRepositoryRepository.findAll();

		if (CollectionUtils.isEmpty(noticiaRepositoryNoticia)) {

			throw new HandleException("NENHUMA NOTICIA ENCONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(noticiaRepositoryNoticia, new TypeToken<List<NoticiaDTO>>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public NoticiaDTO criarNoticia(NoticiaDTO noticiaRepositoryDTO) {

		Noticia entity = modelMapper.map(noticiaRepositoryDTO, new TypeToken<Noticia>() {
		}.getType());

		return modelMapper.map(noticiaRepositoryRepository.save(entity), new TypeToken<NoticiaDTO>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public NoticiaDTO atualizarNoticia(NoticiaDTO noticiaRepositoryDTO) throws HandleException {

		if(noticiaRepositoryRepository.findById(noticiaRepositoryDTO.getId()).isPresent()) {

			Noticia entity = modelMapper.map(noticiaRepositoryDTO, new TypeToken<Noticia>() {}.getType());

			return modelMapper.map(noticiaRepositoryRepository.save(entity), new TypeToken<NoticiaDTO>() {}.getType());
		}

		throw new HandleException("A NOTICIA NÃO PODE SER ATUALIZADA", HttpStatus.CONFLICT);
	}

	@Transactional(rollbackOn = Exception.class)
	public void excluirNoticia(NoticiaDTO noticiaRepositoryDTO) {

		if(noticiaRepositoryRepository.findById(noticiaRepositoryDTO.getId()).isPresent()) {

			Noticia entity = modelMapper.map(noticiaRepositoryDTO, new TypeToken<Noticia>() {}.getType());

			noticiaRepositoryRepository.delete(entity);
		}
	}

	public List<NoticiaDTO> listaNoticiaCategoria(NoticiaDTO noticiaDTO) throws HandleException {

		List<Noticia> noticias = noticiaRepositoryRepository.findByCategoriaId(noticiaDTO.getCategoriaId());

		if (CollectionUtils.isEmpty(noticias)) {

			throw new HandleException("NENHUMA NOTICIA ENCONTRADA", HttpStatus.NO_CONTENT);
		}		
		return modelMapper.map(noticias, new TypeToken<List<NoticiaDTO>>() {}.getType());	
	}


	public NoticiaDTO inserirNoticiaCategoria(NoticiaDTO noticiaDTO) throws HandleException {

		if(CategoriaRepository.findById(noticiaDTO.getCategoriaId()).isPresent()) {

			Noticia entity = modelMapper.map(noticiaDTO, new TypeToken<Noticia>() {}.getType());

			return modelMapper.map(noticiaRepositoryRepository.save(entity), new TypeToken<NoticiaDTO>() {}.getType());

		}else {

			throw new HandleException("CATEGORIA NÃO ENCONTRADA", HttpStatus.CONFLICT);
		}
	}
}
