package com.topay.users.infra.specification;

/*
 * @(#)QueryPredicateBuilder.java 1.0 15/10/2019
 *
 * Copyright (c) 2019, PicPay S.A. All rights reserved.
 * PicPay S.A. proprietary/confidential. Use is subject to license terms.
 */



import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class comments go here...
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 07/10/2019
 */
public class QueryPredicateBuilder {

    private final List<Predicate> predicates = new ArrayList<>();

    /**
     * @param predicate
     *
     * @return QueryPredicateBuilder
     */
    public QueryPredicateBuilder addPredicate(final Predicate predicate) {
        predicates.add(predicate);
        return this;
    }

    /**
     * @param predicate
     * @param values
     *
     * @return QueryPredicateBuilder
     */
    public QueryPredicateBuilder addPredicate(final Predicate predicate, final Collection<?> values) {
        if (!CollectionUtils.isEmpty(values)) {
            predicates.add(predicate);
        }
        return this;
    }

    /**
     * @return QueryPredicateBuilder
     */
    public Predicate[] build() {
        final Predicate[] predicatesArray = this.predicates.toArray(new Predicate[this.predicates.size()]);
        predicates.clear();
        return predicatesArray;
    }

    /**
     * This method verify a predicate existence
     * @return QueryPredicateBuilder
     */
    public boolean hasPredicate() {
        return !CollectionUtils.isEmpty(predicates);
    }

}
