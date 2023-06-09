package com.example.demobackend.repository.mongo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface ResourceRepository<T, I extends Serializable> extends MongoRepository<T, I> {

    List<T> findAll(Query query);

    Page<T> findAll(Query query, Pageable pageable);

    Page<T> findAll(Aggregation aggregation, Pageable pageable);
}
