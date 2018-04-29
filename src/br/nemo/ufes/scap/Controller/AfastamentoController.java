package br.nemo.ufes.scap.Controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.nemo.ufes.scap.Application.AplAfastamento;
import br.nemo.ufes.scap.Application.AplDocumento;
import br.nemo.ufes.scap.Application.AplMandato;
import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Documento;
import br.nemo.ufes.scap.Domain.Onus;
import br.nemo.ufes.scap.Domain.Pessoa;
import br.nemo.ufes.scap.Domain.SituacaoSolic;
import br.nemo.ufes.scap.Domain.TipoAfastamento;

@Controller
public class AfastamentoController {

	@Autowired
	private AplAfastamento aplAfastamento;

	@Autowired
	private AplDocumento aplDocumento;

	@Autowired
	private AplMandato aplMandato;

	// @ProfessorRestricted
	@RequestMapping(value = "/afastamento/form")
	public String formulario() {
		return "afastamento/formulario";
	}

	// @ProfessorRestricted
	@RequestMapping(value = "/afastamento/salva", method = RequestMethod.POST)
	public String salva(String nome_evento, String nome_cidade, TipoAfastamento tipo, Onus onusAfastamento,
			String data_iniAfast, String data_fimAfast, String data_iniEvento, String data_fimEvento,
			Principal principal) throws ParseException {
		Afastamento novoAfastamento = new Afastamento();
		System.out.println(principal.getName());
		SimpleDateFormat formatada = new SimpleDateFormat("yyyy/MM/dd");

		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		Calendar cal5 = Calendar.getInstance();

		novoAfastamento.setNome_evento(nome_evento);
		novoAfastamento.setNome_cidade(nome_cidade);
		novoAfastamento.setData_criacao(cal);
		cal2.setTime(formatada.parse(data_iniAfast.replaceAll("-", "/")));
		novoAfastamento.setData_iniAfast(cal2);
		cal3.setTime(formatada.parse(data_fimAfast.replaceAll("-", "/")));
		novoAfastamento.setData_fimAfast(cal3);
		cal4.setTime(formatada.parse(data_iniEvento.replaceAll("-", "/")));
		novoAfastamento.setData_iniEvento(cal4);
		cal5.setTime(formatada.parse(data_fimEvento.replaceAll("-", "/")));
		novoAfastamento.setData_fimEvento(cal5);
		// new person so pra teste
		aplAfastamento.salvar(novoAfastamento, new Pessoa(), tipo, onusAfastamento);

		return "index/index";
	}

	@RequestMapping(value = "/afastamento/bus")
	public String busca(HttpSession session, ModelMap map, String id_afastamento) {

		List<Afastamento> listaDAO = aplAfastamento.listaAfastamentos();
		List<AfastamentoLista> tabela = new ArrayList<AfastamentoLista>();
		SimpleDateFormat formatada = new SimpleDateFormat("dd/MM/yyyy");
		for (Integer i = 0; i < listaDAO.size(); i++) {
			if (!listaDAO.get(i).getSituacaoSolicitacao().getStatusAfastamento().equals("CANCELADO")
					&& !listaDAO.get(i).getSituacaoSolicitacao().getStatusAfastamento().equals("ARQUIVADO")) {
				AfastamentoLista elemento = new AfastamentoLista();
				elemento.setId_afastamento(listaDAO.get(i).getId_afastamento().toString());
				elemento.setNome_pessoa(listaDAO.get(i).getSolicitante().getNome() + " "
						+ listaDAO.get(i).getSolicitante().getSobreNome());
				elemento.setNome_cidade(listaDAO.get(i).getNome_cidade());
				elemento.setNome_evento(listaDAO.get(i).getNome_evento());
				elemento.setSituacaoSolicitacao(listaDAO.get(i).getSituacaoSolicitacao().getStatusAfastamento());
				elemento.setTipoAfastamento(listaDAO.get(i).getTipoAfastamento().getTipoAfastamento());
				elemento.setData_iniAfast(formatada.format(listaDAO.get(i).getData_iniAfast().getTime()));
				elemento.setData_fimAfast(formatada.format(listaDAO.get(i).getData_fimAfast().getTime()));
				tabela.add(elemento);
			}
		}
		map.addAttribute("afastamentoLista", tabela);
		return "afastamento/busca";
	}

	@RequestMapping(value = "/afastamento/most")
	public String mostrar(String id_afastamento, ModelMap map, HttpSession session) {
		Afastamento afastamento = aplAfastamento.buscaId(id_afastamento);
		if (afastamento == null) {
			afastamento = aplAfastamento.buscaId("id_afastamento");
		}
		if (afastamento == null) {
			// result.redirectTo(IndexController.class).msgErro("Id de
			// Afastamendo não encontrada!");
			return "index/index";
		}
		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
		session.setAttribute("afastamento", afastamento);
		List<DocumentoLista> tabela = new ArrayList<DocumentoLista>();
		List<Documento> listaDAO = aplDocumento.buscaPorAfastamento(afastamento.getId_afastamento().toString());
		SimpleDateFormat formatada = new SimpleDateFormat("dd/MM/yyyy");

		for (Integer i = 0; i < listaDAO.size(); i++) {
			DocumentoLista elemento = new DocumentoLista();
			elemento.setId(listaDAO.get(i).getId_documento().toString());
			elemento.setTitulo(listaDAO.get(i).getTituloDocumento());
			elemento.setArquivo(listaDAO.get(i).getNomeArquivo());
			elemento.setJuntada(formatada.format(listaDAO.get(i).getData_juntada().getTime()));
			elemento.setContent(listaDAO.get(i).getContent());
			tabela.add(elemento);

		}

		Usuario usuarioWeb = (Usuario) session.getAttribute("usuarioWeb");
		if (aplMandato.checaMandato(usuarioWeb.getLogado().getId().toString())) {
			map.addAttribute("chefe", true);
		}

		map.addAttribute("SolicitanteNome",
				afastamento.getSolicitante().getNome() + " " + afastamento.getSolicitante().getSobreNome());
		map.addAttribute("SolicitanteMatricula", afastamento.getSolicitante().getMatricula());
		map.addAttribute("SolicitanteEmail", afastamento.getSolicitante().getEmail());
		map.addAttribute("SolicitanteTel", afastamento.getSolicitante().getTelefone());
		map.addAttribute("afastamentonomeCidade", afastamento.getNome_cidade());
		map.addAttribute("afastamentonomeEvento", afastamento.getNome_evento());
		map.addAttribute("afastamentotipo", afastamento.getTipoAfastamento().getTipoAfastamento());
		map.addAttribute("afastamentoonus", afastamento.getOnus().getOnus());
		map.addAttribute("afastamentostatus", afastamento.getSituacaoSolicitacao().getStatusAfastamento());
		map.addAttribute("afastamentoData_iniAfasta", f.format(afastamento.getData_iniAfast().getTime()));
		map.addAttribute("afastamentoData_fimAfasta", f.format(afastamento.getData_fimAfast().getTime()));
		map.addAttribute("afastamentoData_iniEvento", f.format(afastamento.getData_iniEvento().getTime()));
		map.addAttribute("afastamentoData_fimEvento", f.format(afastamento.getData_fimEvento().getTime()));
		map.addAttribute("id_afastamento", afastamento.getId_afastamento().toString());

		map.addAttribute("documentoLista", tabela);
		return "afastamento/mostrar";

	}

	@RequestMapping(value = "/afastamento/status")
	public String mudarStatusForm(String msg) {
		return "afastamento/mudarStatusForm";
	}

	@RequestMapping(value = "/afastamento/mudastatus")
	public String mudarStatus(HttpSession session, SituacaoSolic novoStatus, ModelMap map, String msg) {
		Afastamento afastamento = new Afastamento();
		Usuario usuarioWeb = (Usuario) session.getAttribute("usuarioWeb");
		afastamento = (Afastamento) session.getAttribute("afastamento");
		if (novoStatus.getStatusAfastamento().equals("CANCELADO")) {
			if (!(usuarioWeb.getLogado().equals(afastamento.getSolicitante()))
					&& !(aplMandato.checaMandato(usuarioWeb.getLogado().getId().toString()))) {
				map.addAttribute("Somente o solicitante do Afastamento ou o Chefe do Departamento pode Cancela-lo!",
						msg);
				return "index/msgErro";
			}
		}
		System.out.println("Tentado mudar status");
		aplAfastamento.mudarStatus(afastamento, novoStatus, usuarioWeb.getLogado());

		return "index/index";
	}

}
