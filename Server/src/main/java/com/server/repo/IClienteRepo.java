package com.server.repo;

import com.server.model.Cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Rodolfo
 */
public interface IClienteRepo extends CrudRepository<Cliente, Long> {    
}