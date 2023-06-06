package com.example.demobackend.repository.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ResourceRepositoryImpl<T, I extends Serializable> extends SimpleMongoRepository<T, I> implements ResourceRepository<T, I> {
    private final MongoOperations mongoOperations;
    private final MongoEntityInformation<T, I> entityInformation;

    public ResourceRepositoryImpl(final MongoEntityInformation<T, I> entityInformation, final MongoOperations mongoOperations) {
        super(entityInformation, mongoOperations);

        this.entityInformation = entityInformation;
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Page<T> findAll(final Query query, final Pageable pageable) {
        Assert.notNull(query, "Query must not be null!");
        Assert.notNull(pageable, "Pageable must not be null!");

        long count = this.count(query);
        List<T> list = this.findAll(query.with(pageable));
        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<T> findAll(Aggregation aggregation, Pageable pageable) {
        Assert.notNull(aggregation, "Aggregation must not be null!");
        Assert.notNull(pageable, "Pageable must not be null!");

        AggregationResults<T> aggregate = (AggregationResults<T>) mongoOperations.aggregate(aggregation,
                this.entityInformation.getCollectionName(), this.entityInformation.getJavaType());

        return new PageImpl<>(aggregate.getMappedResults(), pageable, aggregate.getMappedResults().size());
    }

    @Override
    public List<T> findAll(@Nullable Query query) {
        return query == null ? Collections.emptyList() : this.mongoOperations.find(query, this.entityInformation.getJavaType(), this.entityInformation.getCollectionName());
    }

    private long count(Query query) {
        return this.mongoOperations.count(query, this.entityInformation.getCollectionName());
    }
}
