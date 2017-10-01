package br.nemo.ufes.scap.Domain;

public enum Onus {
	
	INEXISTENTE("INEXISTENTE"),   
    PARCIAL("PARCIAL"),
    TOTAL("TOTAL");
	
	private String onus;
	
	Onus(String tipo_Onus){
		this.onus= tipo_Onus;
	}
	
	
	//GETTER
	public String getOnus() {
		return onus;
	}
}