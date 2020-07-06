package com.topay.users.infra.serializer;

import com.topay.users.domain.employee.Employee;
import com.topay.users.infra.wrapper.EmployeeWrapper;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import static com.topay.users.infra.serializer.SerializationLabels.UUID;
import static com.topay.users.infra.serializer.SerializationLabels.CREATION_DATE;
import static com.topay.users.infra.serializer.SerializationLabels.EMAIL;
import static com.topay.users.infra.serializer.SerializationLabels.NAME;

public class EmployeeWrapperSerializer extends AbstractSerializer<EmployeeWrapper> {

    @Override
    public void serialize(EmployeeWrapper wrapper, JsonWriter jsonWriter) throws IOException {
        final Employee employee = wrapper.getEmployee();
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField(UUID, employee.getUuid().toString());
        jsonWriter.writeStringField(CREATION_DATE, employee.getCreationDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        jsonWriter.writeStringField(EMAIL, employee.getEmail());
        jsonWriter.writeStringField(NAME, employee.getName());
        jsonWriter.writeEndObject();
    }
}
