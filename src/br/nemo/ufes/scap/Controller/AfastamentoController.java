package br.nemo.ufes.scap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.nemo.ufes.scap.Application.AplAfastamento;

@Controller
public class AfastamentoController {

	@Autowired
	AplAfastamento aplAfastamento;

	@RequestMapping("/afastamento/busca")
	@PreAuthorize("hasRole('ROLE_PROF')")
	public String execute() {
		System.out.println("AfastamentoController");
		aplAfastamento.testeRoleProf();
		return "afastamentoBusca";
	}

}
