package br.nemo.ufes.scap.Application;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Onus;
import br.nemo.ufes.scap.Domain.Pessoa;
import br.nemo.ufes.scap.Domain.SituacaoSolic;
import br.nemo.ufes.scap.Domain.TipoAfastamento;
import br.nemo.ufes.scap.Persistency.AfastamentoDAO;
import br.nemo.ufes.scap.Persistency.PessoaDAO;

@Service
@PreAuthorize("hasAuthority('PERM_AFAST')")
public class AplAfastamentoImp implements AplAfastamento {

	@Autowired
	private AfastamentoDAO afastamentoDAO;

	@Autowired
	private PessoaDAO pessoaDAO;

	/*
	 * private final AsyncMailer mailer;
	 * 
	 * @Autowired public AplAfastamentoImp(AsyncMailer mailer){ this.mailer =
	 * mailer; }
	 */

	@Transactional
	@Override
	@PreAuthorize("hasAuthority('PERM_AFAST_SAVE')")
	public void salvar(Afastamento novoAfastamento, Pessoa solicitante, TipoAfastamento tipo, Onus onusAfastamento) {
		novoAfastamento.setSolicitante(solicitante);
		novoAfastamento.setTipoAfastamento(tipo);
		novoAfastamento.setOnus(onusAfastamento);
		if (tipo.getTipoAfastamento().equals("NACIONAL")) {
			SituacaoSolic situacao = SituacaoSolic.LIBERADO;
			novoAfastamento.setSituacaoSolicitacao(situacao);
		} else {
			SituacaoSolic situacao = SituacaoSolic.INICIADO;
			novoAfastamento.setSituacaoSolicitacao(situacao);
		}
		System.out.println("Salvou um afastamento");
		// afastamentoDAO.salvar(novoAfastamento);

		/*
		 * List<Pessoa> listaProfessores = pessoaDAO.listaProfessores();
		 * DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
		 * 
		 * for(int i=0;i<listaProfessores.size();i++){ Email email = new
		 * SimpleEmail();
		 * email.setSubject("SCAP - Um novo Afastamento foi solicitado"); try {
		 * email.addTo(listaProfessores.get(i).getEmail());
		 * email.setMsg("O Professor: "+novoAfastamento.getSolicitante().getNome
		 * ()+" solicitou um Afastamento a partir de: "+
		 * f.format(novoAfastamento.getData_iniAfast().getTime())+". Até: "+f.
		 * format(novoAfastamento.getData_fimAfast().getTime())+".");
		 * mailer.asyncSend(email);
		 * 
		 * } catch (EmailException e) { e.printStackTrace(); } }
		 */

	}

	@Transactional
	@Override
	public List<Afastamento> listaAfastamentos() {
		System.out.println("Listou os Afastamentos");
		List<Afastamento> lista = new ArrayList<Afastamento>();
		return lista;
	}

	@Transactional
	@Override
	public Afastamento buscaId(String id_afastamento) {
		return afastamentoDAO.buscaId(id_afastamento);
	}

	@Transactional
	@Override
	public void mudarStatus(Afastamento afastamento, SituacaoSolic novoStatus, Pessoa logado) {
		afastamento.setSituacaoSolicitacao(novoStatus);
		afastamentoDAO.merge(afastamento);
		/*
		 * Email email = new SimpleEmail(); email.
		 * setSubject("SCAP - O status da sua Solicitação de Afastamento foi alterado."
		 * ); try { email.addTo(afastamento.getSolicitante().getEmail());
		 * email.setMsg("O status de sua Solicitação de Afastamento ID: "
		 * +afastamento.getId_afastamento().toString()+" foi alterado para "
		 * +novoStatus.getStatusAfastamento()+" por: "+logado.getNome()+" "
		 * +logado.getSobreNome()+"."); mailer.asyncSend(email);
		 * 
		 * } catch (EmailException e) { e.printStackTrace(); }
		 */
	}

}
