package br.com.mjv.bookcolaboradores.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository<T, ID extends Serializable> {
	
	<S extends T> S save(S entity);

	T findOne(ID primaryKey);

	Iterable<T> findAll();

	Long count();

	void delete(T entity);

	boolean exists(ID primaryKey);
}