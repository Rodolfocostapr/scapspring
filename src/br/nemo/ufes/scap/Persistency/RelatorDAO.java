package br.nemo.ufes.scap.Persistency;

import java.util.List;

import br.nemo.ufes.scap.Domain.Relator;

public interface RelatorDAO extends BaseDAO<Relator> {
	
	public Relator buscaId(String id_relator);
	
	public Relator buscaPorAfastamento(String id_afastamento);
	
	public List<Relator> listaRelatores();
}
