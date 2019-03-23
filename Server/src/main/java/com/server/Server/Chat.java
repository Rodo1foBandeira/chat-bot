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
	
	private Handle handle = new Handle();

	@Override
	public void sendMessage(String msg) throws RemoteException {
		handle.Decisao(msg);			
	}

	@Override
	public String retrieveMessage() throws RemoteException {
		return handle.getMensagemAnterior();
	}

	@Override
	public void sair() throws RemoteException {
		handle.sair();
	}

}