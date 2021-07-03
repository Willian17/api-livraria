package br.com.totemti.livraria.controllers.dto;

public class ErroDTO {
	
	private String erro;
	
	private String propriedade;
	
	
	public ErroDTO(String erro) {
		this.erro = erro;
	}

	public ErroDTO(String erro, String propriedade) {
		this.erro = erro;
		this.propriedade = propriedade;
	}
	
	public String getErro() {
		return erro;
	}

	public String getPropriedade() {
		return propriedade;
	}
	
	
	
}
