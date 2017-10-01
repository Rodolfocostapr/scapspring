package br.nemo.ufes.scap.Persistency;

import java.util.Calendar;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import br.nemo.ufes.scap.Domain.Mandato;

@Model
public class JPAmandatoDAO extends JPABaseDAO<Mandato> implements MandatoDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Mandato buscaId(String id_mandato) {
		Mandato mandato = new Mandato();
		try {
			Query q = manager.createQuery("SELECT a FROM Mandato a WHERE a.id_mandato = " + id_mandato);
			mandato = (Mandato) q.getSingleResult();
			return mandato;
		} catch (NoResultException e1) {
			System.out.println("Mandato inexistente");
		} catch (QueryTimeoutException e3) {
			System.out.println("Query timmed out");
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checaMandato(String id_professor) {
		Mandato mandato = new Mandato();
		try {
			Query q = manager.createQuery("SELECT a FROM Mandato a WHERE a.pessoa =" + id_professor);
			mandato = (Mandato) q.getSingleResult();
			Calendar cal = Calendar.getInstance();
			if (cal.after(mandato.getData_inicio()) && cal.before(mandato.getData_fim())) {
				return true;
			} else {
				return false;
			}
		} catch (NoResultException e1) {
			return false;
		} catch (QueryTimeoutException e3) {
			System.out.println("Query timmed out");
		} catch (Exception e4) {
			e4.printStackTrace();
		}
		return false;
	}

}
