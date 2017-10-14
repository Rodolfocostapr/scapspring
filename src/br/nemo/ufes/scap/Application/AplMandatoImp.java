package br.nemo.ufes.scap.Application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Mandato;
import br.nemo.ufes.scap.Domain.Pessoa;
import br.nemo.ufes.scap.Persistency.MandatoDAO;
import br.nemo.ufes.scap.Persistency.PessoaDAO;

@Service
public class AplMandatoImp implements AplMandato {

	@Autowired
	private PessoaDAO pessoaDAO;

	@Autowired
	private MandatoDAO mandatoDAO;

	@Transactional
	@Override
	public void salvar(Mandato novoMandato, String matricula) {
		Pessoa chefeDepatamento;
		chefeDepatamento = pessoaDAO.buscaMatricula(matricula);
		novoMandato.setPessoa(chefeDepatamento);
		mandatoDAO.salvar(novoMandato);
	}

	@Transactional
	@Override
	public boolean checaMandato(String id_pessoa) {
		return mandatoDAO.checaMandato(id_pessoa);
	}

}
