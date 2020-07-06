package com.topay.users.infra.serializer;

import com.topay.users.domain.employee.Employee;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 03/05/2020
 */
@Component
public class EmployeeSerializer extends AbstractSerializer<Employee> {

    @Override
    public void serialize(final Employee value, final JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeEndObject();
    }

}
