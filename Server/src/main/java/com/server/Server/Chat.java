package com.server.Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Chat extends UnicastRemoteObject implements IChat {
		
	public Chat() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4223425374772277289L;
	
	private static final String MensagemInicial = "Por favor insira seu Cpf!";
	
	private String mensagem = "";
	
	private Sessao sessao;
	
	private Handle handle = new Handle();

	@Override
	public void sendMessage(String msg) throws RemoteException {
		
		if (mensagem.length() == 0) {
			mensagem = "Olá. " + MensagemInicial;
		}else if (sessao == null && mensagem.contains(MensagemInicial)) {
			String decisao = handle.VerificarCpfCadastrado(mensagem, msg);
			if (decisao.contains(MensagemInicial)) {
				mensagem = MensagemInicial;
			}else {
				sessao = new Sessao(msg, decisao);
				mensagem = "O que deseja " + sessao.getNome();
			}				
		}else {
			mensagem = handle.Decisao(sessao.getCpf(), mensagem, msg);
		}	
	}

	@Override
	public String retrieveMessage() throws RemoteException {
		if (mensagem.length() == 0)
			mensagem = "Olá. " + MensagemInicial;
		return mensagem;
	}

	@Override
	public void sair() throws RemoteException {
		mensagem = "";
		sessao = null;
	}

}