package br.nemo.ufes.scap.Application;

import java.util.List;

import br.nemo.ufes.scap.Domain.Documento;

public interface AplDocumento {

	public void salvar(Documento documento);

	public Documento buscaId(String id_documento);

	public List<Documento> buscaPorAfastamento(String id_afastamento);

}