package com.mcnc.springdatamongo.frmk.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, ID> implements BaseRepository<T, ID> {
	
	private final MongoOperations mongoOperations;
	private final MongoEntityInformation<T, ID> entityInformation;
	
	public BaseRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		this.mongoOperations = mongoOperations;
		this.entityInformation = metadata;
	}

	public MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	public MongoEntityInformation<T, ID> getEntityInformation() {
		return entityInformation;
	}
	
	@Override
	public Class<T> getEntityClass() {
		return entityInformation.getJavaType();
	}
	
	@Override
	public Class<ID> getIDClass() {
		return entityInformation.getIdType();
	}
	
	@Override
	public boolean exist(Query query) {
		return mongoOperations.exists(query, getEntityClass());
	}
	
	@Override
	public Long count(Query query) {
		return mongoOperations.count(query, getEntityClass());
	}
	
	@Override
	public void update(Query query, Update update) {
		mongoOperations.findAndModify(query, update, getEntityClass());
	}
	
	@Override
	public void delete(Query query) {
		mongoOperations.findAllAndRemove(query, getEntityClass());
	}

	@Override
	public T findOne(Query query) {
		return mongoOperations.findOne(query, getEntityClass());
	}

	@Override
	public List<T> findAll(Query query) {
		return mongoOperations.find(query, getEntityClass());
	}

	@Override
	public Page<T> findAll(Query query, Pageable pageable) {
		Long count = count(query);
		List<T> list = findAll(query.with(pageable));
		return new PageImpl<T>(list, pageable, count);
	}

	@Override
	public List<T> findAll(Query query, Sort sort) {
		return findAll(query.with(sort));
	}
	
	@Override
	public <O> AggregationResults<O> aggregate(Aggregation aggregation, Class<?> inputType, Class<O> outputType) {
		return mongoOperations.aggregate(aggregation, inputType, outputType);
	}
}
