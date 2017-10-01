package br.nemo.ufes.scap.Domain;

public enum TipoParentesco {
	MATRIOMONIAL("MATRIOMONIAL"),   
    SANGUINEO("SANGUINEO");
	
	private String tipoParentesco;  
	
	
	TipoParentesco(String tipo_Parentesco){  
	       this.tipoParentesco = tipo_Parentesco;  
	}  
	  
	public String getTipoAfastamento(){  
	       return tipoParentesco;  
	}
}
