package br.nemo.ufes.scap.Persistency;

import java.util.List;

import br.nemo.ufes.scap.Domain.Documento;

public interface DocumentoDAO extends BaseDAO<Documento> {
	
	public Documento buscaId(String id_documento);
	
	public List<Documento> buscaPorAfastamento(String id_afastamento);
	
}
