package br.nemo.ufes.scap.Application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Parentesco;
import br.nemo.ufes.scap.Domain.TipoParentesco;
import br.nemo.ufes.scap.Persistency.ParentescoDAO;
import br.nemo.ufes.scap.Persistency.PessoaDAO;

@Service
public class AplParentescoImp implements AplParentesco {

	@Autowired
	private PessoaDAO pessoaDAO;

	@Autowired
	private ParentescoDAO parentescoDAO;

	@Transactional
	@Override
	public void salvar(String matricula1, String matricula2, TipoParentesco tipo) {

		Parentesco parentesco = new Parentesco();
		parentesco.setPessoa1(pessoaDAO.buscaMatricula(matricula1));
		parentesco.setPessoa2(pessoaDAO.buscaMatricula(matricula2));
		parentesco.setTipoParentesco(tipo);
		parentescoDAO.salvar(parentesco);

		Parentesco parentesco2 = new Parentesco();
		parentesco2.setPessoa1(pessoaDAO.buscaMatricula(matricula2));
		parentesco2.setPessoa2(pessoaDAO.buscaMatricula(matricula1));
		parentesco2.setTipoParentesco(tipo);
		parentescoDAO.salvar(parentesco2);
	}

	@Transactional
	@Override
	public boolean checaParentesco(String matricula1, String matricula2) {
		return parentescoDAO.checaParentesco(matricula1, matricula2);
	}

}
