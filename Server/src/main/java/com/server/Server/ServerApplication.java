package com.server.Server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.server.model.Cliente;
import com.server.repo.IClienteQuery;
import com.server.repo.IClienteRepo;
import com.server.repo.IMensagemRepo;

@SpringBootApplication(scanBasePackages  = "com.server")
@EntityScan(basePackages = "com.server.model")
@EnableJpaRepositories(basePackages = "com.server.repo")
public class ServerApplication {
	
	public static IClienteRepo clienteRepo;
	public static IMensagemRepo mensagemRepo;
	public static IClienteQuery clienteQry;
	
	private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);
	
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
	
	@Bean
	public CommandLineRunner init(IClienteRepo cliRepo, IMensagemRepo msgRepo, IClienteQuery cliQry) {
		clienteRepo = cliRepo;
		mensagemRepo = msgRepo;
		clienteQry = cliQry;
		return (args) -> {};
	}

}
