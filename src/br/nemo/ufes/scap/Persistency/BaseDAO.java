package br.nemo.ufes.scap.Persistency;

public interface BaseDAO<T> {
	public void salvar (T object);
	
	T merge(T object);
}
