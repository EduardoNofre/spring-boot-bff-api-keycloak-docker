package com.spring.boot.bff.mobile.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.bff.mobile.app.client.ImportanciaClient;
import com.spring.boot.bff.mobile.app.dto.ImportanciaDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImportanciaService {

	@Autowired
	private ImportanciaClient importanciaClient;

	public ImportanciaDTO buscarId(Integer id)  {return null;}

	public List<ImportanciaDTO> listar()  {return null;}

	public ImportanciaDTO criarImportancia(ImportanciaDTO importanciaDTO) {return null;}

	public ImportanciaDTO atualizar(ImportanciaDTO importanciaDTO)  {return null;}

	public void excluir(ImportanciaDTO importanciaDTO) {}

}
