package br.com.noticiario.app.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named
@RequestScoped
public class ConfirmBean {

	  public void confirm() {
	        addMessage("Confirmed", "You have accepted");
	    }
	  
	  public void addMessage(String summary, String detail) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
}
