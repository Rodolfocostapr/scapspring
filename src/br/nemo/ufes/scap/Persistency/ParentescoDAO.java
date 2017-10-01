package br.nemo.ufes.scap.Persistency;

import br.nemo.ufes.scap.Domain.Parentesco;

public interface ParentescoDAO extends BaseDAO<Parentesco>{
	
	public Parentesco buscaId(String id_parentesco);
	
	public Boolean checaParentesco(String id_pessoa1, String id_pessoa2);
}
