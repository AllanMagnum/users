package com.topay.users.domain.employee;

import com.topay.users.domain.company.Company;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 02/05/2020
 */
@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends Employee {

    @OneToMany(mappedBy = "manager")
    private final List<Employee> employees = new ArrayList<>();

    /**
     * @param email
     * @param name
     * @param company
     * @param employees
     */
    public Manager(final String email, final String name, final Company company, final List<Employee> employees) {
        super(EmployeeType.MANAGER, email, name, null, company);
        this.employees.addAll(employees);
    }

    private Manager() {
        this(null, null, null, Collections.emptyList());
    }

    /**
     * @return
     */
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

}
