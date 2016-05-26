package com.mcnc.springdatamongo.frmk.repository;

import java.io.Serializable;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class BaseRepositoryFactoryBean<R extends BaseRepository<T, ID>, T, ID extends Serializable> extends MongoRepositoryFactoryBean<R, T, ID> {

	@Override
	protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
		return new BaseRepositoryFactory(operations);
	}

	private static class BaseRepositoryFactory extends MongoRepositoryFactory {

		public BaseRepositoryFactory(MongoOperations mongoOperations) {
			super(mongoOperations);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			Class<?> interfaceClass = metadata.getRepositoryInterface();
			Reflections reflections = new Reflections(ClasspathHelper.forPackage(interfaceClass.getPackage().getName()), new SubTypesScanner());
			Set<?> subClasses = reflections.getSubTypesOf(interfaceClass);
			for (Object clazz : subClasses) {
				if (BaseRepositoryImpl.class.isAssignableFrom((Class<?>) clazz)) {
					return (Class<?>) clazz;
				}
			}
			return BaseRepositoryImpl.class;
		}
	}
}
