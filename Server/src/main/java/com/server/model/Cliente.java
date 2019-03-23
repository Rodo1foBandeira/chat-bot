package com.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Rodolfo
 */
@Entity
public class Cliente {	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;

    private String Nome;
    
    @Column(length=14)
    private String Cpf;
    
    private float SegundaVia;

    public float getSegundaVia() {
        return SegundaVia;
    }

    public void setSegundaVia(float segundaVia) {
        SegundaVia = segundaVia;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public long getId() {
            return Id;
    }
    public void setId(long id) {
            Id = id;
    }
    public String getNome() {
            return Nome;
    }
    public void setNome(String nome) {
            Nome = nome;
    }
    
    public Cliente(String cpf, String nome) {
    	Cpf = cpf;
    	Nome = nome;
    }
    
    public Cliente() {
    	
    }
    
}
