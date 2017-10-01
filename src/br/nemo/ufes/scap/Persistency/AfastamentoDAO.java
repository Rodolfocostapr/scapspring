package br.nemo.ufes.scap.Persistency;

import java.util.List;

import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Persistency.BaseDAO;

public interface AfastamentoDAO extends BaseDAO<Afastamento> {

	public Afastamento buscaId(String id_afastamento);
	
	public List<Afastamento> listaAfastamentos();

}
