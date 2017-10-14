package br.nemo.ufes.scap.Application;

import java.util.List;

import br.nemo.ufes.scap.Domain.Pessoa;

public interface AplPessoa {
	void salvar(Pessoa novoUsuario);

	Pessoa buscaMatricula(String matricula);

	List<Pessoa> buscaNome(String nome, String sobreNome);
}