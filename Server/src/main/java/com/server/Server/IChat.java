package com.server.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChat extends Remote {
	
	void sendMessage(String msg) throws RemoteException;
	String retrieveMessage() throws RemoteException;
	void sair() throws RemoteException;
	
}