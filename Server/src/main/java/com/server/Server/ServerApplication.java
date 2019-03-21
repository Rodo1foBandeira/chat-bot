package com.server.Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {
	
	public static void main(String[] args) throws RemoteException {
		SpringApplication.run(ServerApplication.class, args);
		
		try {
			LocateRegistry.createRegistry(8282);
			Naming.rebind("rmi://localhost:8282/chat", new Chat());
			System.out.println("Rodando...");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
