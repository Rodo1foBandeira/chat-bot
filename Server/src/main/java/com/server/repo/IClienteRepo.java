package com.server.repo;

import com.server.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Rodolfo
 */
public interface IClienteRepo extends JpaRepository<Cliente, Long> {    
}