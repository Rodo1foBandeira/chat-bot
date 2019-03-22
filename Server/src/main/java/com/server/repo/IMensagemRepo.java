package com.server.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.server.model.Mensagem;

/**
 *
 * @author Rodolfo
 */

public interface IMensagemRepo extends CrudRepository<Mensagem, Long> {
    
}