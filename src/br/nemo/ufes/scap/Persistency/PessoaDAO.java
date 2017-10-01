package br.nemo.ufes.scap.Persistency;

import java.util.List;

import br.nemo.ufes.scap.Domain.Pessoa;

public interface PessoaDAO extends BaseDAO<Pessoa> {
	
	public Pessoa buscaMatricula(String Matricula);
	
	public Pessoa buscaId(Long id_pessoa);
	
	public List<Pessoa> buscaNome(String nome,String sobreNome);
	
	public List<Pessoa> listaProfessores();
}
