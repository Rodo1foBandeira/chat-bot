package com.server.Server;

import org.springframework.beans.factory.annotation.Autowired;

import com.server.model.Cliente;
import com.server.repo.IClienteRepo;

public class Handle {
		
	@Autowired
	private IClienteRepo clienteRepo;
	
	public String Decisao(String cpf, String ultimaMsg, String msgRecebida) {
		String decisao = "Decisao";
		if (msgRecebida.contains("Xau"))
			decisao = "Xau";
		return decisao;
	}
	
	public String VerificarCpfCadastrado(String ultimaMsg, String msgRecebida) {
		clienteRepo.save(new Cliente("Rodolfo", msgRecebida));
		//ClienteQuery clienteQuery = new ClienteQuery();
		//clienteQuery.save(new Cliente("Rodolfo", msgRecebida));
		//manager.persist(new Cliente("Rodolfo", msgRecebida));
		return "Cpf teste";
	}
}
