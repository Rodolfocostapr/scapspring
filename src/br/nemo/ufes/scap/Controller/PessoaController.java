package br.nemo.ufes.scap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.nemo.ufes.scap.Application.AplPessoa;
import br.nemo.ufes.scap.Domain.Pessoa;

@Controller
//@RequestMapping(value = "/pessoa/**")
public class PessoaController {

	@Autowired
	private AplPessoa aplPessoa;

	@RequestMapping(value = "/pessoa/form")
	public String formulario(ModelMap modelMap) {
		modelMap.addAttribute("pessoa", new Pessoa());
		return "pessoa/formulario";
	}

	public void lista() {
	}

	@RequestMapping(value = "/pessoa/salva", method = RequestMethod.POST)
	public String salva(@ModelAttribute("pessoa") Pessoa novoUsuario) {
		aplPessoa.salvar(novoUsuario);

		return "index/index";
	}

	@RequestMapping(value = "/pessoa/bus")
	public String busca() {
		return "pessoa/busca";
	}

	@RequestMapping(value = "/pessoa/list", method = RequestMethod.POST)
	public String listar(String nome, String sobreNome, ModelMap map) {
		map.addAttribute("pessoaList", aplPessoa.buscaNome(nome, sobreNome));
		return "pessoa/listar";
	}

}
