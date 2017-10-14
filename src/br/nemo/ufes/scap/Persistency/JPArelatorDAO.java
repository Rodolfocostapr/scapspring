package br.nemo.ufes.scap.Persistency;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import org.springframework.stereotype.Service;

import br.nemo.ufes.scap.Domain.Relator;

@Service("relatorDAO")
public class JPArelatorDAO extends JPABaseDAO<Relator> implements RelatorDAO{
	
	@PersistenceContext
	private EntityManager manager;
	
	protected EntityManager getEntityManager() {
		return manager;
	}

	@Override
	public Relator buscaId(String id_relator) {
		Relator relator = new Relator();
		try{
			Query q = manager.createQuery("SELECT a FROM Relator a WHERE a.id_relator = " + id_relator);
			relator = (Relator)q.getSingleResult();
			return relator;
		}catch(NoResultException e1) {
			System.out.println("Relator inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Relator> listaRelatores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Relator buscaPorAfastamento(String id_afastamento) {
		Relator relator = new Relator();
		try{
			Query q = manager.createQuery("SELECT a FROM Relator a WHERE a.afastamento = " + id_afastamento);
			relator = (Relator)q.getSingleResult();
			return relator;
		}catch(NoResultException e1) {
			System.out.println("Relator inexistente");
		}catch(QueryTimeoutException e3){
			System.out.println("Query timmed out");
		}catch(Exception e4){
			e4.printStackTrace();
		}
		return null;
	}
	
}
