package br.nemo.ufes.scap.Domain;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-03T10:04:52.217-0200")
@StaticMetamodel(Parecer.class)
public class Parecer_ {
	public static volatile SingularAttribute<Parecer, Long> id_parecer;
	public static volatile SingularAttribute<Parecer, Pessoa> relator;
	public static volatile SingularAttribute<Parecer, Afastamento> afastamento;
	public static volatile SingularAttribute<Parecer, Calendar> data_parecer;
	public static volatile SingularAttribute<Parecer, TipoParecer> julgamento;
	public static volatile SingularAttribute<Parecer, String> motivoIndeferimento;
}
