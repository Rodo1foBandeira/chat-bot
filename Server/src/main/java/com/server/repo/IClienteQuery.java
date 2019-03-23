package com.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.server.model.Cliente;

public interface IClienteQuery extends JpaRepository<Cliente, Long>{
	@Query("select c from Cliente c where c.Cpf = ?1")
	Cliente getByCpf(String cpf);
}
