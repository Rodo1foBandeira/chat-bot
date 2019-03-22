package com.server.repo;

import org.springframework.data.repository.CrudRepository;

import com.server.model.Mensagem;

/**
 *
 * @author Rodolfo
 */
public interface IMensagemRepo extends CrudRepository<Mensagem, Long> {
    
}