package br.nemo.ufes.scap.Domain;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-16T16:26:15.095-0200")
@StaticMetamodel(Documento.class)
public class Documento_ {
	public static volatile SingularAttribute<Documento, Long> id_documento;
	public static volatile SingularAttribute<Documento, String> tituloDocumento;
	public static volatile SingularAttribute<Documento, String> nomeArquivo;
	public static volatile SingularAttribute<Documento, Afastamento> afastamento;
	public static volatile SingularAttribute<Documento, Calendar> data_juntada;
	public static volatile SingularAttribute<Documento, byte[]> content;
}
