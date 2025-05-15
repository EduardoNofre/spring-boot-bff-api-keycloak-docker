package br.com.noticiario.app.bean;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.noticiario.app.service.ImportanciaService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named
@RequestScoped
public class ImportanciaBean {

	@Autowired
	private ImportanciaService importanciaService;
}
