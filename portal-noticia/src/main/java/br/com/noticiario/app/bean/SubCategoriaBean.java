package br.com.noticiario.app.bean;

import java.time.LocalDateTime;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.noticiario.app.dto.SubCategoriaDTO;
import br.com.noticiario.app.handle.HandleException;
import br.com.noticiario.app.service.SubCategoriaService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named("subCategoriaBean")
@ViewScoped
public class SubCategoriaBean {

	@Autowired
	private SubCategoriaService subCategoriaService;

	private SubCategoriaDTO subCategoriaSelecionada;

	private SubCategoriaDTO dto;

	private List<SubCategoriaDTO> subCategoriasSelecionadas;

	public List<SubCategoriaDTO> listarSubCategorias() throws HandleException {

		return subCategoriaService.subCategoriaListar();
	}

	public void salvarSubCategoria() throws HandleException {

		if (this.dto.getId() == null) {
			this.dto.setId(null);
			this.dto.setCriadoEm(LocalDateTime.now());
			subCategoriaService.subCategoriaInserir(null, null);
		}
		PrimeFaces.current().executeScript("PF('gerenciadoPrioridadeDialog').hide()");
		PrimeFaces.current().ajax().update("form-subCategorias:g-mensagem", "form-subCategorias:dt-tab-subCategoria");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro", "SubCategoria cadastrada!"));
	}

	public void editarSubCategoria() throws HandleException {

		if (this.subCategoriaSelecionada.getId() != null) {
			this.subCategoriaSelecionada.setCriadoEm(LocalDateTime.now());
			subCategoriaService.subCategoriaAtualizar(subCategoriaSelecionada);
		}
		PrimeFaces.current().executeScript("PF('wgv-gerenciadorPrioridadeDialogEdit').hide()");
		PrimeFaces.current().ajax().update("form-subCategorias:g-mensagem", "form-subCategorias:dt-tab-subCategoria");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edição", "SubCategoria editada!"));

	}

	public void excluirSubCategoria() throws HandleException {

		for (SubCategoriaDTO subCategoriaSelecionada : subCategoriasSelecionadas) {

			subCategoriaService.subCategoriaExcluir(subCategoriaSelecionada);
		}

		if (subCategoriasSelecionadas.size() > 1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Remoção","A remoção das sub Categoria foi realizada com sucesso"));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Remoção","A sub Categoria foi removida com sucesso"));
		}
		this.subCategoriasSelecionadas = null;
		PrimeFaces.current().ajax().update("form-categorias:g-mensagem", "form-categorias:dt-tab-subCategoria");
		PrimeFaces.current().executeScript("PF('dt-tab-categoria').clearFilters()");
	}
	
	public void inserirNovaSubCategoria() {
		this.dto = new SubCategoriaDTO();
	}

	public boolean temSubCategoriaSelecionada() {
		return this.subCategoriasSelecionadas != null && !this.subCategoriasSelecionadas.isEmpty();
	}

	public String getDeleteButtonMessage() {
		if (temSubCategoriaSelecionada()) {
			int size = this.subCategoriasSelecionadas.size();
			return size > 1 ? " Deseja excluir " + size : " Deseja excluir 1";
		}

		return "Deseja excluir";
	}
}
