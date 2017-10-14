package br.nemo.ufes.scap.Application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.commons.mail.Email;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Relator;
import br.nemo.ufes.scap.Domain.SituacaoSolic;
import br.nemo.ufes.scap.Persistency.AfastamentoDAO;
import br.nemo.ufes.scap.Persistency.RelatorDAO;

@Service
public class AplRelatorImp implements AplRelator {

	@Autowired
	private AfastamentoDAO afastamentoDAO;

	@Autowired
	private RelatorDAO relatorDAO;

	@Transactional
	@Override
	public void salvar(Relator relator, Afastamento afastamento) {

		relator.setAfastamento(afastamento);

		SituacaoSolic situacao = SituacaoSolic.LIBERADO;
		afastamento.setSituacaoSolicitacao(situacao);

		afastamentoDAO.merge(afastamento);

		/*
		 * Email email = new SimpleEmail(); email.
		 * setSubject("SCAP - Você foi escolhido como Relator de um Afastamento"
		 * ); try { email.addTo(relator.getRelator().getEmail());
		 * email.setMsg("Você foi escolhido como Relator do afastamento de ID: "
		 * + afastamento.getId_afastamento().toString());
		 * mailer.asyncSend(email);
		 * 
		 * } catch (EmailException e) { e.printStackTrace(); }
		 */
		relatorDAO.salvar(relator);
	}

}
