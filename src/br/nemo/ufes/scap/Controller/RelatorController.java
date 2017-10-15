package br.nemo.ufes.scap.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.nemo.ufes.scap.Application.AplAfastamento;
import br.nemo.ufes.scap.Application.AplParentesco;
import br.nemo.ufes.scap.Application.AplPessoa;
import br.nemo.ufes.scap.Application.AplRelator;
import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Relator;

@Controller
public class RelatorController {

	@Autowired
	private AplRelator aplRelator;

	@Autowired
	private AplAfastamento aplAfastamento;

	@Autowired
	private AplPessoa aplPessoa;

	@Autowired
	private AplParentesco aplParentesco;

	// @ChefeRestricted
	@RequestMapping(value = "/relator/form")
	public String formulario(String msg) {
		return "relator/formulario";
	}

	// @ChefeRestricted
	@RequestMapping(value = "/relator/porafast")
	public void porAfastamento(String msg, String matricula) {
		// result.include("msg",msg);
		// result.include("matricula",matricula);
	}

	// @ChefeRestricted
	@RequestMapping(value = "/relator/salvaporafast")
	public String salvaPorAfastamento(Relator relator, String matricula, String id_afastamento, HttpSession session,
			ModelMap map) {
		Afastamento afastamento = aplAfastamento.buscaId(id_afastamento);
		relator.setRelator(aplPessoa.buscaMatricula(matricula));
		if (aplParentesco.checaParentesco(afastamento.getSolicitante().getId_pessoa().toString(),
				relator.getRelator().getId_pessoa().toString())) {
			map.addAttribute(
					"Erro: Não foi possível cadastrar essa pessoa como relatora porque existe um parentesco entre ela e o solicitante do afastamento!",
					matricula);
			return "relator/porAfastamento";
		}

		aplRelator.salvar(relator, afastamento);
		return "index:index";
	}

	// @ChefeRestricted
	@RequestMapping(value = "/relator/salva")
	public String salva(Relator relator, String matricula, HttpSession session, ModelMap map) {
		Afastamento afastamento = new Afastamento();
		afastamento = (Afastamento) session.getAttribute("afastamento");
		relator.setRelator(aplPessoa.buscaMatricula(matricula));
		if (aplParentesco.checaParentesco(afastamento.getSolicitante().getId_pessoa().toString(),
				relator.getRelator().getId_pessoa().toString())) {
			map.addAttribute("msg",
					"Erro: Não foi possível cadastrar essa pessoa como relatora porque existe um parentesco entre ela e o solicitante do afastamento!");
			return "relator/formulario";
		}
		aplRelator.salvar(relator, afastamento);
		return "index/index";
	}

}
