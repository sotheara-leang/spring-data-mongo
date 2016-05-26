package com.mcnc.springdatamongo.frmk.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface BaseService<T, ID extends Serializable> {
	
	Long count();
	
	Long count(Query query);
	
	boolean exists(ID id);
	
	boolean exist(Query query);
	
	<S extends T> S save(S entity);
	
	<S extends T> List<S> save(Iterable<S> entites);
	
	void update(Query query, Update update);
	
	void delete(Query query);
	
	void delete(ID id);
	
	void delete(T entity);
	
	void delete(Iterable<? extends T> entities);
	
	T findOne(ID id);
	
	T findOne(Query query);
	
	List<T> findAll();
	
	List<T> findAll(Query query);
	
	Page<T> findAll(Pageable pageable);
	
	Page<T> findAll(Query query, Pageable pageable);
	
	List<T> findAll(Sort sort);
	
	List<T> findAll(Query query, Sort sort);
	
	<O> AggregationResults<O> aggregate(Aggregation aggregation, Class<?> inputType, Class<O> outputType);
}
