package com.server.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Rodolfo
 */
@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long Id;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private Cliente Cliente;

    public void setId(long id) {
		Id = id;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	private String Message;
    
    @Column
    @CreationTimestamp
    private Timestamp createDateTime;

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public long getId() {
		return Id;
	}

	public Timestamp getCreateDateTime() {
		return createDateTime;
	}
    
    
}