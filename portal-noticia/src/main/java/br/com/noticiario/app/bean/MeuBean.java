package br.com.noticiario.app.bean;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.noticiario.app.service.BeanService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Data;

@Data
@Named
@RequestScoped
public class MeuBean {

	@Autowired
	private BeanService beanService;

	private String nome;

	public String saudacao() {
		return beanService.ola(nome);
	}

}
