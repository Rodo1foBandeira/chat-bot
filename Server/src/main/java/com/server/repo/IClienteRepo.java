package com.server.repo;

import com.server.model.Cliente;

import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Rodolfo
 */
public interface IClienteRepo extends CrudRepository<Cliente, Long> {    
}