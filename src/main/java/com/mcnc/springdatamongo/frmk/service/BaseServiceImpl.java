package com.mcnc.springdatamongo.frmk.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mcnc.springdatamongo.frmk.repository.BaseRepository;

public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Autowired
	private BaseRepository<T, ID> repository;

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public Long count(Query query) {
		return repository.count(query);
	}

	@Override
	public boolean exists(ID id) {
		return repository.exists(id);
	}

	@Override
	public boolean exist(Query query) {
		return repository.exist(query);
	}

	@Override
	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entites) {
		return repository.save(entites);
	}
	
	@Override
	public void update(Query query, Update update) {
		repository.update(query, update);
	}
	
	@Override
	public void delete(Query query) {
		repository.delete(query);
	}

	@Override
	public void delete(ID id) {
		repository.delete(id);
	}

	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		repository.delete(entities);
	}

	@Override
	public T findOne(ID id) {
		return repository.findOne(id);
	}

	@Override
	public T findOne(Query query) {
		return repository.findOne(query);
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public List<T> findAll(Query query) {
		return repository.findAll(query);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Page<T> findAll(Query query, Pageable pageable) {
		return repository.findAll(query, pageable);
	}

	@Override
	public List<T> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public List<T> findAll(Query query, Sort sort) {
		return repository.findAll(query, sort);
	}
	
	@Override
	public <O> AggregationResults<O> aggregate(Aggregation aggregation, Class<?> inputType, Class<O> outputType) {
		return repository.aggregate(aggregation, inputType, outputType);
	}
}
