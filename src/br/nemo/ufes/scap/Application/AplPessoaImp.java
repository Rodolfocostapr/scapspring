package br.nemo.ufes.scap.Application;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Pessoa;
import br.nemo.ufes.scap.Domain.Professor;
import br.nemo.ufes.scap.Domain.Secretario;
import br.nemo.ufes.scap.Persistency.PessoaDAO;

@Service
public class AplPessoaImp implements AplPessoa {
	@Autowired
	private PessoaDAO pessoaDAO;

	@Transactional
	@Override
	public void salvar(Pessoa novoUsuario) {
		if (novoUsuario.getTipoPessoa().equals("1")) {
			Professor novoProfessor = new Professor();
			novoProfessor.setNome(novoUsuario.getNome());
			novoProfessor.setSobreNome(novoUsuario.getSobreNome());
			novoProfessor.setEmail(novoUsuario.getEmail());
			novoProfessor.setTelefone(novoUsuario.getTelefone());
			novoProfessor.setMatricula(novoUsuario.getMatricula());
			novoProfessor.setTipoPessoa("1");
			novoProfessor.setPassword(novoUsuario.getPassword());
			pessoaDAO.salvar(novoProfessor);
		} else {
			Secretario novoSecretario = new Secretario();
			novoSecretario.setNome(novoUsuario.getNome());
			novoSecretario.setSobreNome(novoUsuario.getSobreNome());
			novoSecretario.setEmail(novoUsuario.getEmail());
			novoSecretario.setTelefone(novoUsuario.getTelefone());
			novoSecretario.setMatricula(novoUsuario.getMatricula());
			novoSecretario.setTipoPessoa("2");
			novoSecretario.setPassword(novoUsuario.getPassword());
			pessoaDAO.salvar(novoSecretario);
		}
	}

	@Transactional
	@Override
	public List<Pessoa> buscaNome(String nome, String sobreNome) {
		List<Pessoa> lista = pessoaDAO.buscaNome(nome, sobreNome);

		return lista;
	}

	@Override
	@Transactional
	public Pessoa buscaMatricula(String matricula) {
		return pessoaDAO.buscaMatricula(matricula);
	}

}
