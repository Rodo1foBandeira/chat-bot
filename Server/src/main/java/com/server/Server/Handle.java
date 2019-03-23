package com.server.Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.server.model.Cliente;
import com.server.model.Mensagem;
import com.server.repo.IClienteRepo;
import com.server.repo.IMensagemRepo;

import java.util.ArrayList;
import java.util.Arrays;

public class Handle {
	
	private static final String MensagemInicial = "Por favor insira seu Cpf!";
	private static final String EhSegundaVia = "Você quis dizer 2ª via?";
	private static final ArrayList<String> SegundaViaPossiveis = new ArrayList<String>(Arrays.asList("segundavia", "2via", "segvia", "via", "2a", "segunda", "seg", "2ª"));
	private static final ArrayList<String> SegundaViaPerfeitas = new ArrayList<String>(Arrays.asList("segunda via", "2a via", "2ª via"));
		
	private String mensagemAnterior = "";
	
	public String getMensagemAnterior () {
		return mensagemAnterior;
	}
	
	private Cliente sessao;
		
	public String Decisao(String msgRecebida) {
		if (mensagemAnterior.length() == 0) {
			mensagemAnterior = "Olá. " + MensagemInicial;
		}else if (sessao == null && mensagemAnterior.contains(MensagemInicial)) {
			sessao = ServerApplication.clienteQry.getByCpf(msgRecebida);
			if (sessao != null) {
				Mensagem msg = new Mensagem();
				msg.setCliente(sessao);
				msg.setMessage("Entrou no sistema");
				ServerApplication.mensagemRepo.save(msg);
				mensagemAnterior = "O que deseja " + sessao.getNome() + "?";
			}else if (mensagemAnterior.contains(MensagemInicial)) {
				mensagemAnterior = "Cpf não encontrado! " + MensagemInicial;
			}				
		} else {
			// TODO: Tomar decisoes
			Mensagem msg = new Mensagem();
			msg.setCliente(sessao);
			msg.setMessage(msgRecebida);
			ServerApplication.mensagemRepo.save(msg);
			if (this.eh2ViaPerfeita(msgRecebida)) {
				mensagemAnterior = "Sua 2ª via é de R$ " + sessao.getSegundaVia();
			} else if (eh2ViaPossiveis(msgRecebida)) {
				mensagemAnterior = EhSegundaVia;
			} else if (mensagemAnterior.contains(EhSegundaVia) && msgRecebida.toLowerCase().contains("s")) {
				mensagemAnterior = "Sua 2ª via é de R$ " + sessao.getSegundaVia();
			} else {
				mensagemAnterior = "O que deseja " + sessao.getNome() + "?";
			}
		}
		if (sessao != null) {
			Mensagem msg = new Mensagem();
			msg.setCliente(sessao);
			msg.setMessage("Robo: " + mensagemAnterior);
			ServerApplication.mensagemRepo.save(msg);
		}
		
		return mensagemAnterior;
	}
	
	private boolean eh2ViaPerfeita(String msg) {
		// "quero minha segunda via"		
		for (String parte : SegundaViaPerfeitas) {
			if (msg.contains(parte))
				return true;
		}
		return false;
	}
	
	private boolean eh2ViaPossiveis(String msg) {
		// "quero minha segunda via"		
		for (String parte : SegundaViaPossiveis) {
			if (msg.contains(parte))
				return true;
		}
		return false;
	}
		
	public void sair() {
		if (sessao != null) {
			Mensagem msg = new Mensagem();
			msg.setCliente(sessao);
			msg.setMessage("Saiu do sistema");
			ServerApplication.mensagemRepo.save(msg);
		}
		sessao = null;
		mensagemAnterior = "";
	}
}
