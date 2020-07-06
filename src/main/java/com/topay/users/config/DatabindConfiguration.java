package com.topay.users.config;

import com.topay.users.domain.employee.Employee;
import com.topay.users.domain.employee.Manager;
import com.topay.users.infra.serializer.AbstractSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 03/05/2020
 */
@Configuration
public class DatabindConfiguration {

    /**
     *
     * @param employeeSerializer
     * @param managerSerializer
     * @return
     */
    @Bean
    public Map<Class<?>, AbstractSerializer> serializers(@Qualifier("employeeSerializer") final AbstractSerializer employeeSerializer,
        @Qualifier("managerSerializer") final AbstractSerializer managerSerializer) {
        final HashMap<Class<?>, AbstractSerializer> serializers = new HashMap<>();
        serializers.put(Employee.class, employeeSerializer);
        serializers.put(Manager.class, managerSerializer);
        return Collections.unmodifiableMap(serializers);
    }

}
