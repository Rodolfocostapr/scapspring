package br.nemo.ufes.scap.Application;

import java.util.List;

import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Onus;
import br.nemo.ufes.scap.Domain.Pessoa;
import br.nemo.ufes.scap.Domain.SituacaoSolic;
import br.nemo.ufes.scap.Domain.TipoAfastamento;

public interface AplAfastamento {
	
	public void testeRoleProf();

	public void salvar(Afastamento novoAfastamento, TipoAfastamento tipo, Onus onusAfastamento);

	public List<Afastamento> listaAfastamentos();

	public Afastamento buscaId(String id_afastamento);

	public void mudarStatus(Afastamento afastamento, SituacaoSolic novoStatus, Pessoa logado);

}
