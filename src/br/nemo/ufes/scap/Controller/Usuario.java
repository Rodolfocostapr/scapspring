package br.nemo.ufes.scap.Controller;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Pessoa;

@Stateful
@SessionScoped
@Service
public class Usuario {

	private Pessoa logado;

	public void login(Pessoa usuario) {
		this.logado = usuario;
	}

	public boolean isLogado() {
		return logado != null;
	}

	public String getMatricula() {
		return logado.getMatricula();
	}

	public Pessoa getLogado() {
		return logado;
	}

	public void logout() {
		this.logado = null;
	}

}
