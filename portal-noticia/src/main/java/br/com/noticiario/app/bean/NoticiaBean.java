package br.com.noticiario.app.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.noticiario.app.dto.CategoriaDTO;
import br.com.noticiario.app.dto.NoticiaDTO;
import br.com.noticiario.app.dto.PrioridadeDTO;
import br.com.noticiario.app.dto.SubCategoriaDTO;
import br.com.noticiario.app.handle.HandleException;
import br.com.noticiario.app.service.CategoriaService;
import br.com.noticiario.app.service.NoticiaService;
import br.com.noticiario.app.service.PrioridadeService;
import br.com.noticiario.app.service.SubCategoriaService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named("noticiaBean")
@ViewScoped
public class NoticiaBean {

	@Autowired
	private NoticiaService noticiaService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private SubCategoriaService subCategoriaService;

	@Autowired
	private PrioridadeService prioridadeService;

	private NoticiaDTO noticiaDTO;

	private String selectOneListCategoria;

	private String selectOneListSubCategoria;

	private String selectOneListPrioridade;

	/**
	 * SelectOneMenu Categorias
	 * 
	 * @return
	 * @throws HandleException
	 */
	public List<CategoriaDTO> listarCategorias() throws HandleException {

		return categoriaService.categorias();
	}

	/**
	 * SelectOneMenu SubCategoria
	 * 
	 * @return
	 * @throws HandleException
	 */
	public List<SubCategoriaDTO> listarSubCategoria() throws HandleException {

		return subCategoriaService.subCategoriaListar();
	}

	/**
	 * SelectOneMenu Prioridade
	 * 
	 * @return
	 * @throws HandleException
	 */
	public List<PrioridadeDTO> listarPrioridade() throws HandleException {

		return prioridadeService.prioridades();
	}
}
