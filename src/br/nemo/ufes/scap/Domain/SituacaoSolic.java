package br.nemo.ufes.scap.Domain;

public enum SituacaoSolic {
	
	INICIADO("INICIADO"),
	LIBERADO("LIBERADO"),
	BLOQUEADO("BLOQUEADO"),
	APROPRIADO("APROPRIADO"),
	APROVADO_CT("APROVADO_CT"),
	APROVADO_DI("APROVADO_DI"),
	APROVADO_PRPPG("APROVADO_PRPPG"),
	ARQUIVADO("ARQUIVADO"),
	CANCELADO("CANCELADO"),
	REPROVADO("REPROVADO");
	
	private String statusAfastamento;
	
	SituacaoSolic(String Situacao_Afastamento){
		this.statusAfastamento = Situacao_Afastamento;
	}

	//GETTER
	public String getStatusAfastamento() {
		return statusAfastamento;
	}
}
