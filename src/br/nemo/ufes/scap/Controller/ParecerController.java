package br.nemo.ufes.scap.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.nemo.ufes.scap.Application.AplParecer;
import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Parecer;
import br.nemo.ufes.scap.Domain.TipoParecer;

@Controller
public class ParecerController {

	@Autowired
	private AplParecer aplParecer;

	// @ProfessorRestricted
	@RequestMapping(value = "/parecer/form")
	public String formulario() {
		return "parecer/formulario";
	}

	// @ProfessorRestricted
	@RequestMapping(value = "/parecer/salva")
	public String salvar(Parecer parecer, TipoParecer tipoParecer, HttpSession session) {
		Afastamento afastamento = new Afastamento();
		afastamento = (Afastamento) session.getAttribute("afastamento");

		if (!afastamento.getSituacaoSolicitacao().getStatusAfastamento().equals("LIBERADO")) {
			// result.redirectTo(IndexController.class).msgErro("Afastamendo não
			// consta como Liberado!");
			return "index/msgErro";
		}

		Usuario usuarioWeb = (Usuario) session.getAttribute("usuarioWeb");
		Calendar cal = Calendar.getInstance();

		parecer.setRelator(usuarioWeb.getLogado());
		parecer.setAfastamento(afastamento);
		parecer.setData_parecer(cal);

		aplParecer.salvar(parecer, afastamento, usuarioWeb.getLogado(), tipoParecer);
		return "index/index";
	}

	@RequestMapping(value = "/parecer/list")
	public String listar(HttpSession session, ModelMap map) {
		Afastamento afastamento = new Afastamento();
		afastamento = (Afastamento) session.getAttribute("afastamento");

		List<Parecer> listaDAO = aplParecer.buscaPorAfastamento(afastamento.getId_afastamento().toString());
		List<ParecerLista> tabela = new ArrayList<ParecerLista>();
		SimpleDateFormat formatada = new SimpleDateFormat("dd/MM/yyyy");
		for (Integer i = 0; i < listaDAO.size(); i++) {
			ParecerLista elemento = new ParecerLista();
			elemento.setNomeCriador(
					listaDAO.get(i).getRelator().getNome() + " " + listaDAO.get(i).getRelator().getSobreNome());
			elemento.setData(formatada.format(listaDAO.get(i).getData_parecer().getTime()));
			elemento.setJulgamento(listaDAO.get(i).getJulgamento().get());
			elemento.setMotivo(listaDAO.get(i).getMotivoIndeferimento());
			tabela.add(elemento);
		}
		map.addAttribute("parecerLista", tabela);
		return "parecer/listar";
	}

}
