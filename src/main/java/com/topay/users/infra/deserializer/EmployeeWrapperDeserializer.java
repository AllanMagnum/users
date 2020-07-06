package com.topay.users.infra.deserializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.topay.users.domain.employee.Employee;
import com.topay.users.infra.wrapper.EmployeeWrapper;

import java.io.IOException;

public class EmployeeWrapperDeserializer extends AbstractDeserializer<EmployeeWrapper> {


    @Override
    public EmployeeWrapper deserialize(JsonNode jsonNode) throws IOException {
        final Employee user = new Employee( jsonNode.get("email").asText(), jsonNode.get("name").asText(), null, null );
        return new EmployeeWrapper(user);
    }
}
