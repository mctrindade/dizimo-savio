package br.com.dizimo.enums;

public enum IgrejaEnum {
	IGREJA(0, "SELECIONE"),
	SAO_DOMINGOS_SAVIO(1, "Paróquia São Domingos Sávio"),
	SANTOS_ANJOS_GUARDA(2, "Capela Santos Anjos da Guarda"),
	SAO_RAFAEL(3, "Capela São Rafael");
	
	private Integer id;
	private String nome;
	
	private IgrejaEnum(Integer id, String nome) {
		this.id= id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
