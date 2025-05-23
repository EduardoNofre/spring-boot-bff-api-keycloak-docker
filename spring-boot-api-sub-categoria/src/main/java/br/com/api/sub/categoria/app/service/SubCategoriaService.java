package br.com.api.sub.categoria.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.api.sub.categoria.app.dto.SubCategoriaDTO;
import br.com.api.sub.categoria.app.handle.HandleException;
import br.com.api.sub.categoria.app.model.SubCategoria;
import br.com.api.sub.categoria.app.repository.SubCategoriaRepository;
import jakarta.transaction.Transactional;

@Service
public class SubCategoriaService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SubCategoriaRepository subCategoriaRepository;

	public List<SubCategoriaDTO> subCategoriaListar() throws HandleException {

		List<SubCategoria> categoria = subCategoriaRepository.findAll();

		if (CollectionUtils.isEmpty(categoria)) {

			throw new HandleException("NENHUMA SUB CATEGORIA ECONTRADA", HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(categoria, new TypeToken<List<SubCategoriaDTO>>() {
		}.getType());
	}

	public List<SubCategoriaDTO> subCategoriaListarCategoria(Integer idCategoriaFk) throws HandleException {

		List<SubCategoria> categoria = subCategoriaRepository.findByCategoriaId(idCategoriaFk);

		if (CollectionUtils.isEmpty(categoria)) {

			throw new HandleException("NENHUMA SUB CATEGORIA ENCONTRADA PARA A CATEGORIA INFORMADA ",
					HttpStatus.NO_CONTENT);
		}

		return modelMapper.map(categoria, new TypeToken<List<SubCategoriaDTO>>() {
		}.getType());
	}

	@Transactional(rollbackOn = Exception.class)
	public SubCategoriaDTO subCategoriaInserir(String subCategoria, Integer categoriaId) {

		SubCategoria entity = new SubCategoria();
		entity.setSubCategoria(subCategoria);
		entity.setCategoriaId(categoriaId);
		entity.setCriadoEm(LocalDateTime.now());

		return modelMapper.map(subCategoriaRepository.save(entity), new TypeToken<SubCategoriaDTO>() {
		}.getType());

	}

	@Transactional(rollbackOn = Exception.class)
	public void subCategoriaExcluir(SubCategoriaDTO subCategoriaDTO) {

		if (subCategoriaRepository.findById(subCategoriaDTO.getId()).isPresent()) {

			SubCategoria entity = modelMapper.map(subCategoriaDTO, new TypeToken<SubCategoria>() {
			}.getType());

			subCategoriaRepository.delete(entity);
		}

	}

	@Transactional(rollbackOn = Exception.class)
	public SubCategoriaDTO SubCategoriaAtualizar(SubCategoriaDTO subCategoriaDTO) throws HandleException {

		if (subCategoriaRepository.findById(subCategoriaDTO.getId()).isPresent()) {

			SubCategoria entity = modelMapper.map(subCategoriaDTO, new TypeToken<SubCategoria>() {
			}.getType());

			return modelMapper.map(subCategoriaRepository.save(entity), new TypeToken<SubCategoriaDTO>() {
			}.getType());
		}

		throw new HandleException("A CATEGORIA NÃO PODE SER ATUALIZADA", HttpStatus.CONFLICT);

	}
}
