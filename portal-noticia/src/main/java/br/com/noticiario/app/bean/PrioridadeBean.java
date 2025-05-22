package br.com.noticiario.app.bean;

import java.time.LocalDateTime;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.noticiario.app.dto.PrioridadeDTO;
import br.com.noticiario.app.handle.HandleException;
import br.com.noticiario.app.service.PrioridadeService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named("prioridadeBean")
@ViewScoped
public class PrioridadeBean {

	@Autowired
	private PrioridadeService prioridadeService;
	
	private PrioridadeDTO prioridadeSelecionada;
	
	private PrioridadeDTO dto;
	
	private List<PrioridadeDTO> prioridadesSelecionadas;
	
	public List<PrioridadeDTO> listarPrioridades() throws HandleException {

		return prioridadeService.prioridades();
	}

	public void salvarPrioridade() throws HandleException {

		if (this.dto.getId() == null) {
			this.dto.setId(null);
			this.dto.setCriadoEm(LocalDateTime.now());
			prioridadeService.salvar(dto);
		}
		PrimeFaces.current().executeScript("PF('gerenciadoPrioridadeDialog').hide()");
		PrimeFaces.current().ajax().update("form-prioridades:g-mensagem", "form-prioridades:dt-tab-prioridade");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro","Prioridade cadastrada!"));
	}

	public void editarPrioridade() throws HandleException {

		if (this.prioridadeSelecionada.getId() != null) {
			this.prioridadeSelecionada.setCriadoEm(LocalDateTime.now());
			prioridadeService.editar(prioridadeSelecionada);
		}
		PrimeFaces.current().executeScript("PF('wgv-gerenciadorPrioridadeDialogEdit').hide()");
		PrimeFaces.current().ajax().update("form-prioridades:g-mensagem", "form-prioridades:dt-tab-prioridade");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Edição","Prioridade editada!"));

	}

	public void excluirPrioridade() throws HandleException {

		prioridadeService.excluir(prioridadeSelecionada);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exclusão","Prioridade excluida!"));
		PrimeFaces.current().ajax().update("form-prioridades:g-mensagem", "form-prioridades:dt-tab-prioridade");

	}

	public void inserirNovaPrioridade() {
		this.dto = new PrioridadeDTO();
	}

	public boolean temPrioridadeSelecionada() {
		return this.prioridadesSelecionadas != null && !this.prioridadesSelecionadas.isEmpty();
	}

	public String getDeleteButtonMessage() {
		if (temPrioridadeSelecionada()) {
			int size = this.prioridadesSelecionadas.size();
			return size > 1 ? " Deseja excluir " + size : " Deseja excluir 1";
		}

		return "Deseja excluir";
	}

	public void excluirPrioridades() throws HandleException {

		for (PrioridadeDTO prioridadeSelecionada : prioridadesSelecionadas) {

			prioridadeService.excluir(prioridadeSelecionada);
		}

		if (prioridadesSelecionadas.size() > 1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Remoção","A remoção das prioridades foi realizada com sucesso"));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Remoção","A prioridade foi removida com sucesso"));
		}
		this.prioridadesSelecionadas = null;
		PrimeFaces.current().ajax().update("form-prioridades:g-mensagem", "form-prioridades:dt-tab-prioridade");
		PrimeFaces.current().executeScript("PF('dt-tab-prioridade').clearFilters()");
	}
}
