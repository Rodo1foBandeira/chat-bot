package com.server.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.server.model.Cliente;
import com.server.repo.ClienteQuery;
import com.server.repo.IClienteRepo;
import com.server.repo.IMensagemRepo;

public class Handle {		
		
	public String Decisao(String cpf, String ultimaMsg, String msgRecebida) {
		String decisao = "Decisao";
		if (msgRecebida.contains("Xau"))
			decisao = "Xau";
		return decisao;
	}
	
	public String VerificarCpfCadastrado(String ultimaMsg, String msgRecebida) {
		ServerApplication.clienteRepo.save(new Cliente(msgRecebida, "Rodolfo"));
		IMensagemRepo msgRepo = ServerApplication.mensagemRepo;
		//ClienteQuery clienteQuery = new ClienteQuery();
		//clienteQuery.save(new Cliente("Rodolfo", msgRecebida));
		//manager.persist(new Cliente("Rodolfo", msgRecebida));
		return "Cpf teste";
	}
}
