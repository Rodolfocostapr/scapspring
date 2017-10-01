package br.nemo.ufes.scap.Domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-17T08:21:44.925-0200")
@StaticMetamodel(Parentesco.class)
public class Parentesco_ {
	public static volatile SingularAttribute<Parentesco, Long> id_parentesco;
	public static volatile SingularAttribute<Parentesco, Pessoa> pessoa1;
	public static volatile SingularAttribute<Parentesco, Pessoa> pessoa2;
	public static volatile SingularAttribute<Parentesco, TipoParentesco> tipoParentesco;
}
