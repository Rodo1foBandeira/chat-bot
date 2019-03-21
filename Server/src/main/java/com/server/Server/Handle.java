package com.server.Server;

import java.util.List;

public class Handle {
	
	public String Decisao(String cpf, String ultimaMsg, String msgRecebida) {
		String decisao = "Decisao";
		if (msgRecebida.contains("Xau"))
			decisao = "Xau";
		return decisao;
	}
	
	public String VerificarCpfCadastrado(String ultimaMsg, String msgRecebida) {
		return "Cpf teste";
	}
}
