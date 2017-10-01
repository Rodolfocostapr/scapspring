package br.nemo.ufes.scap.Domain;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-01T13:49:05.774-0200")
@StaticMetamodel(Mandato.class)
public class Mandato_ {
	public static volatile SingularAttribute<Mandato, Long> id_mandato;
	public static volatile SingularAttribute<Mandato, Pessoa> pessoa;
	public static volatile SingularAttribute<Mandato, Calendar> data_inicio;
	public static volatile SingularAttribute<Mandato, Calendar> data_fim;
}
