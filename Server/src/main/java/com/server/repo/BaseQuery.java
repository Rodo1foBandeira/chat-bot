package com.server.repo;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public class BaseQuery<T, ID> implements CrudRepository<T, ID>{

	@Autowired
	@PersistenceContext
    private EntityManager manager;
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(T arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends T> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(ID arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(ID arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<T> findAllById(Iterable<ID> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<T> findById(ID arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> S save(S arg0) {
		manager.persist(arg0);
		return arg0;
	}

	@Override
	public <S extends T> Iterable<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
