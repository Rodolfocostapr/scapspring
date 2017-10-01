package br.nemo.ufes.scap.Persistency;

import br.nemo.ufes.scap.Domain.Mandato;

public interface MandatoDAO extends BaseDAO<Mandato> {
	
	public Mandato buscaId(String id_mandato);
	
	public boolean checaMandato(String id_pessoa);
	
}
