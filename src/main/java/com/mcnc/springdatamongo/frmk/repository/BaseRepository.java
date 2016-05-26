package com.mcnc.springdatamongo.frmk.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable> extends MongoRepository<T, ID> {
	
	Class<T> getEntityClass();
	
	Class<ID> getIDClass();
	
	MongoOperations getMongoOperations();
	
	boolean exist(Query query);
	
	Long count(Query query);
	
	void update(Query query, Update update);
	
	void delete(Query query);
	
	T findOne(Query query);
	
	List<T> findAll(Query query);
	
	Page<T> findAll(Query query, Pageable pageable);
	
	List<T> findAll(Query query, Sort sort);
	
	<O> AggregationResults<O> aggregate(Aggregation aggregation, Class<?> inputType, Class<O> outputType);
}