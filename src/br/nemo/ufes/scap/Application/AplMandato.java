package br.nemo.ufes.scap.Application;

import br.nemo.ufes.scap.Domain.Mandato;

public interface AplMandato {

	public void salvar(Mandato novoMandato, String matricula);

	public boolean checaMandato(String id_pessoa);

}
