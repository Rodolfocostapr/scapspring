package br.nemo.ufes.scap.Persistency;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import br.nemo.ufes.scap.Domain.Afastamento;

public class JPAafastamentoDAO extends JPABaseDAO<Afastamento> implements AfastamentoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	@Inject
	PessoaDAO pessoaDAO;
	
	@Override
	public Afastamento buscaId(String id_afastamento) {
		Afastamento afastamento = new Afastamento();
		try{
			Query q = manager.createQuery("SELECT a FROM Afastamento a WHERE a.id_afastamento = " + id_afastamento);
			afastamento = (Afastamento)q.getSingleResult();
			return afastamento;
		}catch(NoResultException e1) {
			System.out.println("Afastamento inexistente");
			return null;
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
			return null;
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Afastamento> listaAfastamentos() {
		List<Afastamento> lista = new ArrayList<Afastamento>();
		
		try{
			Query q = manager.createQuery("SELECT a FROM Afastamento a");
			lista = q.getResultList();
			return lista;
			
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
			return null;
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}
	
	
	
}
