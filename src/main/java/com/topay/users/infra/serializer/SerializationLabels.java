package com.topay.users.infra.serializer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SerializationLabels {

    ACTUAL_PAGE(" actualPage"),
    CREATION_DATE("creationDate"),
    NAME("name"),
    EMAIL("email"),
    PAGE(" page"),
    PAGE_SIZE("pageSize"),
    TOTAL_PAGES(" totalPages"),
    UUID("uuid");

    private final String field;

    @Override
    public String toString() {
        return this.field;
    }

}