package com.topay.users.infra.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.topay.users.domain.employee.Employee;
import com.topay.users.infra.deserializer.EmployeeWrapperDeserializer;
import com.topay.users.infra.serializer.EmployeeWrapperSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonSerialize(using = EmployeeWrapperSerializer.class)
@JsonDeserialize(using = EmployeeWrapperDeserializer.class)
public class EmployeeWrapper {

    @Getter
    private final Employee employee;
}
