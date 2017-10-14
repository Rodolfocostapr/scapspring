package br.nemo.ufes.scap.Application;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Parecer;
import br.nemo.ufes.scap.Domain.Pessoa;
import br.nemo.ufes.scap.Domain.TipoParecer;
import br.nemo.ufes.scap.Persistency.AfastamentoDAO;
import br.nemo.ufes.scap.Persistency.MandatoDAO;
import br.nemo.ufes.scap.Persistency.ParecerDAO;

@Service
public class AplParecerImp implements AplParecer {

	@Autowired
	private ParecerDAO parecerDAO;

	// @Inject
	// private RelatorDAO relatorDAO;

	@Autowired
	private MandatoDAO mandatoDAO;

	@Autowired
	private AfastamentoDAO afastamentoDAO;

	@Transactional
	@Override
	public void salvar(Parecer parecer, Afastamento afastamento, Pessoa usuario, TipoParecer tipoParecer) {
		parecerDAO.salvar(parecer);
		/*
		 * if(afastamento.getTipoAfastamento().getTipoAfastamento().equals(
		 * "INTERNACIONAL") &&
		 * !(mandatoDAO.checaMandato(usuario.getId().toString()))){ Relator
		 * relator =
		 * relatorDAO.buscaPorAfastamento(afastamento.getId_afastamento().
		 * toString()); if(relator != null){
		 * if(relator.getRelator().equals(usuario)){
		 * if(tipoParecer.get().equals("FAVORAVEL")){ SituacaoSolic situacao =
		 * SituacaoSolic.APROVADO_CT;
		 * afastamento.setSituacaoSolicitacao(situacao); }else{ SituacaoSolic
		 * situacao = SituacaoSolic.REPROVADO;
		 * afastamento.setSituacaoSolicitacao(situacao); }
		 * afastamentoDAO.merge(afastamento); } } }
		 */
	}

	@Transactional
	@Override
	public List<Parecer> buscaPorAfastamento(String id_afastamento) {
		return parecerDAO.buscaPorAfastamento(id_afastamento);
	}

}
