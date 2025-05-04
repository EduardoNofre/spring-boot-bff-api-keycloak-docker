package com.spring.boot.bff.mobile.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.bff.mobile.app.client.NoticiaClient;
import com.spring.boot.bff.mobile.app.dto.NoticiaDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoticiaService {

	@Autowired
	private NoticiaClient noticiaClient;

	public NoticiaDTO buscarId(Integer id)  {return null;}

	public List<NoticiaDTO> listaNoticia()  {return null;}

	public NoticiaDTO criarNoticia(NoticiaDTO noticiaRepositoryDTO) {return null;}

	public NoticiaDTO atualizarNoticia(NoticiaDTO noticiaRepositoryDTO)  {return null;}

	public void excluirNoticia(NoticiaDTO noticiaRepositoryDTO) {}

	public List<NoticiaDTO> listaNoticiaCategoria(NoticiaDTO noticiaDTO)  {return null;}

	public NoticiaDTO inserirNoticiaCategoria(NoticiaDTO noticiaDTO)  {return null;}

}
