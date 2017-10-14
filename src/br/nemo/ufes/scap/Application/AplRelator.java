package br.nemo.ufes.scap.Application;

import br.nemo.ufes.scap.Domain.Afastamento;
import br.nemo.ufes.scap.Domain.Relator;

public interface AplRelator {// ESSA CLASSE FOI CONSIDERADA DESNECESS�?RIA EM
								// UMA REAVALIAÇÃO DO DIAGRAMA DE CLASSES,
								// SEUS MÉTODOS DEVEM SER MOVIDOS PARA
								// A AplAfastamento DESTE PACOTE

	public void salvar(Relator relator, Afastamento afastamento);

}
