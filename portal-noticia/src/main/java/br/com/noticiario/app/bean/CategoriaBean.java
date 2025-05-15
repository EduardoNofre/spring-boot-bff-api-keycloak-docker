package br.com.noticiario.app.bean;

import java.time.LocalDateTime;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.noticiario.app.dto.CategoriaDTO;
import br.com.noticiario.app.handle.HandleException;
import br.com.noticiario.app.service.CategoriaService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named("categoriaBean")
@ViewScoped
public class CategoriaBean {

	@Autowired
	private CategoriaService categoriaService;

	private CategoriaDTO categoriaSelecionada;
	
	private CategoriaDTO dto;

	private List<CategoriaDTO> categoriasSelecionadas;

	public List<CategoriaDTO> listarCategorias() throws HandleException {

		return categoriaService.categorias();
	}

	public void salvarCategoria() throws HandleException {

		if (this.dto.getId() == null) {
			this.dto.setId(null);
			this.dto.setDataHrAlteracao(LocalDateTime.now());
			this.dto.setCriadoEm(LocalDateTime.now());
			categoriaService.salvar(dto);
		}
		PrimeFaces.current().executeScript("PF('gerenciadoCategoriaDialog').hide()");
		PrimeFaces.current().ajax().update("form-categorias:g-mensagem", "form-categorias:dt-tab-categoria");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro","Categoria cadastrada!"));
	}

	public void editarCategoria() throws HandleException {

		if (this.categoriaSelecionada.getId() != null) {
			this.categoriaSelecionada.setDataHrAlteracao(LocalDateTime.now());
			this.categoriaSelecionada.setCriadoEm(LocalDateTime.now());
			categoriaService.editar(categoriaSelecionada);
		}
		PrimeFaces.current().executeScript("PF('wgv-gerenciadorCategoriaDialogEdit').hide()");
		PrimeFaces.current().ajax().update("form-categorias:g-mensagem", "form-categorias:dt-tab-categoria");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edição","Categoria editada!"));

	}

	public void excluirCategoria() throws HandleException {

		categoriaService.excluir(categoriaSelecionada);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exclusão","Categoria excluida!"));
		PrimeFaces.current().ajax().update("form-categorias:g-mensagem", "form-categorias:dt-tab-categoria");

	}

	public void inserirNovaCategoria() {
		this.dto = new CategoriaDTO();
	}

	public boolean temCategoriaSelecionada() {
		return this.categoriasSelecionadas != null && !this.categoriasSelecionadas.isEmpty();
	}

	public String getDeleteButtonMessage() {
		if (temCategoriaSelecionada()) {
			int size = this.categoriasSelecionadas.size();
			return size > 1 ? " Deseja excluir " + size : " Deseja excluir 1";
		}

		return "Deseja excluir";
	}

	public void excluirCategorias() throws HandleException {

		for (CategoriaDTO categoriaSelecionada : categoriasSelecionadas) {

			categoriaService.excluir(categoriaSelecionada);
		}

		if (categoriasSelecionadas.size() > 1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Remoção","A remoção das categorias foi realizada com sucesso"));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Remoção","A categoria foi removida com sucesso"));
		}
		this.categoriasSelecionadas = null;
		PrimeFaces.current().ajax().update("form-categorias:g-mensagem", "form-categorias:dt-tab-categoria");
		PrimeFaces.current().executeScript("PF('dt-tab-categoria').clearFilters()");
	}
}
