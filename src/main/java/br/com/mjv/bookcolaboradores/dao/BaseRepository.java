package br.com.mjv.bookcolaboradores.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository <T, ID extends Serializable> {

	T findOne(ID id);
	T save(T entity);
}
