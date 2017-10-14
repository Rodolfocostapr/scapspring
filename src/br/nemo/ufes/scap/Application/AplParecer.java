package br.nemo.ufes.scap.Application;

import java.util.List;

import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Parecer;
import br.nemo.ufes.scap.Domain.Pessoa;
import br.nemo.ufes.scap.Domain.TipoParecer;

public interface AplParecer {

	public void salvar(Parecer parecer, Afastamento afastamento, Pessoa usuario, TipoParecer tipoParecer);

	public List<Parecer> buscaPorAfastamento(String id_afastamento);

}
