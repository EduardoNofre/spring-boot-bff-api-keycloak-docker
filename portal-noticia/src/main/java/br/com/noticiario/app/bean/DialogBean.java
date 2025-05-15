package br.com.noticiario.app.bean;

import org.primefaces.PrimeFaces;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named
@RequestScoped
public class DialogBean {

	
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Always Bet on Prime!");

        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}
