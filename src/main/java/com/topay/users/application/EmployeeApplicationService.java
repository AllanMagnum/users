package com.topay.users.application;

import com.topay.users.domain.employee.Employee;
import com.topay.users.domain.employee.EmployeeNotFoundException;
import com.topay.users.domain.employee.EmployeeRepository;
import com.topay.users.infra.specification.EmployeeSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 02/05/2020
 */
@Service
@AllArgsConstructor
public class EmployeeApplicationService {

    private final EmployeeRepository employeeRepository;

    /**
     *
     * @param employeeSpecification
     * @param pageRequest
     * @return
     */
    public Page<Employee> findAll(final EmployeeSpecification employeeSpecification, final Pageable pageRequest) {
        return employeeRepository.findAll(employeeSpecification, pageRequest);
    }

    /**
     *
     * @param uuid
     * @return
     */
    public Employee findByUuid(final UUID uuid) {
        return employeeRepository.findById(uuid)
            .orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee with uuid '%s' not found", uuid)));
    }

}
