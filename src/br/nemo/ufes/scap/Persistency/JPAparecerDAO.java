package br.nemo.ufes.scap.Persistency;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Parecer;

@Service("parecerDAO")
public class JPAparecerDAO extends JPABaseDAO<Parecer> implements ParecerDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Parecer buscaId(String id_parecer) {
		Parecer parecer = new Parecer();
		try{
			Query q = manager.createQuery("SELECT a FROM Parecer a WHERE a.id_parecer = " + id_parecer);
			parecer = (Parecer)q.getSingleResult();
			return parecer;
		}catch(NoResultException e1) {
			System.out.println("parecer inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Parecer> buscaPorAfastamento(String id_afastamento) {
		List<Parecer> lista = new ArrayList<Parecer>();
		
		try{
			Query q = manager.createQuery("SELECT a FROM Parecer a WHERE a.afastamento = " + id_afastamento);
			lista = q.getResultList();
			return lista;
		}catch(NoResultException e1) {
			System.out.println("documento inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}
	
	
	
}
