package com.server.Server;

public class Sessao {
	private String Cpf;
	private String Nome;
	
	public Sessao (String cpf, String nome) {
		Cpf = cpf;
		Nome = nome;
	}
	
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	
}
