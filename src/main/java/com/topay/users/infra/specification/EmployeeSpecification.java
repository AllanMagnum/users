package com.topay.users.infra.specification;

import com.topay.users.domain.employee.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class EmployeeSpecification implements Specification<Employee>{

    private final static String UUID_ATTRIBUTE_NAME = "uuid";
    private final static String NAME_ATTRIBUTE_NAME = "name";
    private final static String EMAIL_ATTRIBUTE_NAME = "email";

    private final List<UUID> uuids = new ArrayList<>();

    private final List<String> names = new ArrayList<>();

    private final List<String> emails = new ArrayList<>();

    public EmployeeSpecification(List<UUID> uuids, List<String> names, List<String> emails) {
        this.uuids.addAll(uuids);
        this.names.addAll(names);
        this.emails.addAll(emails);
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        final QueryPredicateBuilder predicates = new QueryPredicateBuilder();

        if(!uuids.isEmpty()){
            final Path<UUID> idPath = root.get(UUID_ATTRIBUTE_NAME);
            predicates.addPredicate( idPath.in(uuids) );
        }
        if(!names.isEmpty()) {
            final Path<String> namePath = root.get(NAME_ATTRIBUTE_NAME);
            predicates.addPredicate(namePath.in(names));
        }
        if(!emails.isEmpty()) {
            final Path<String> namePath = root.get(EMAIL_ATTRIBUTE_NAME);
            predicates.addPredicate(namePath.in(names));
        }

        return predicates.hasPredicate() ? criteriaBuilder.and(predicates.build()) : null;
    }
}
