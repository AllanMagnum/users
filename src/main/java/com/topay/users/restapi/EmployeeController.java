package com.topay.users.restapi;

import com.topay.users.application.EmployeeApplicationService;
import com.topay.users.domain.employee.Employee;
import com.topay.users.infra.specification.EmployeeSpecification;
import com.topay.users.infra.wrapper.EmployeeWrapper;
import com.topay.users.infra.wrapper.PageWrapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.data.domain.Sort.Direction.*;


/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 02/05/2020
 */
@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeApplicationService employeeApplicationService;

    /**
     *
     * @param employeeSpecification
     * @param pageRequest
     * @return
     */
    @GetMapping("/employees")
    public PageWrapper findAll(final EmployeeSpecification employeeSpecification,
        @PageableDefault(sort = "name", direction = ASC, size = 30) final Pageable pageRequest) {
        final Page<Employee> employees = employeeApplicationService.findAll(employeeSpecification, pageRequest);
        return new PageWrapper(employees);
    }

    /**
     *
     * @param uuid
     * @return
     */
    @GetMapping("/employees/{uuid}")
    public EmployeeWrapper findById(@PathVariable(value = "uuid") final String uuid) {
        final Employee employee = employeeApplicationService.findByUuid(UUID.fromString(uuid));
        return new EmployeeWrapper(employee);
    }

}
