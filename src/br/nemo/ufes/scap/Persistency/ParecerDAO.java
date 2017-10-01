package br.nemo.ufes.scap.Persistency;

import java.util.List;

import br.nemo.ufes.scap.Domain.Parecer;

public interface ParecerDAO extends BaseDAO<Parecer> {
	
	public Parecer buscaId(String id_parecer);
	
	public List<Parecer> buscaPorAfastamento(String id_afastamento);

}
