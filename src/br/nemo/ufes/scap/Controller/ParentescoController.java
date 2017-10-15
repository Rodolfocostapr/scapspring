package br.nemo.ufes.scap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.nemo.ufes.scap.Application.AplParentesco;
import br.nemo.ufes.scap.Domain.TipoParentesco;

@Controller
public class ParentescoController {

	@Autowired
	AplParentesco aplParentesco;

	// @SecretarioRestricted
	@RequestMapping(value = "/parentesco/form", method = RequestMethod.POST)
	public String formulario(String matricula1, ModelMap model) {
		model.addAttribute("matricula1", matricula1);
		return "parentesco/formulario";
	}

	public void lista() {
	}

	// @SecretarioRestricted
	@RequestMapping(value = "/parentesco/salva", method = RequestMethod.POST)
	public String salva(String matricula1, String matricula2, TipoParentesco tipo) {
		aplParentesco.salvar(matricula1, matricula2, tipo);
		return "index/index";
	}

}
