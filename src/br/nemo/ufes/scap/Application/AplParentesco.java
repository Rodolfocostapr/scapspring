package br.nemo.ufes.scap.Application;

import br.nemo.ufes.scap.Domain.TipoParentesco;

public interface AplParentesco {

	void salvar(String matricula1, String matricula2, TipoParentesco tipo);

	boolean checaParentesco(String matricula1, String matricula2);

}
