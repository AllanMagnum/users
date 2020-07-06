package com.topay.users.domain.company;

import com.topay.users.domain.employee.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "COMPANY", schema = "USR")
public class Company {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private final String name;

    @OneToMany(mappedBy = "company")
    private final List<Employee> employees = new ArrayList<>();

    /**
     * @param name
     */
    public Company(final String name, final List<Employee> employees) {
        this.name = name;
        this.employees.addAll(employees);
    }

    private Company() {
        this(null, Collections.emptyList());
    }

}
