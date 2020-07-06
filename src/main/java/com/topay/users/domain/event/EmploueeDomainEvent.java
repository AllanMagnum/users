package com.topay.users.domain.event;

import com.topay.users.domain.employee.Employee;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 05/07/2020
 */
public class EmploueeDomainEvent extends DomainEvent<Employee>{

    @Override
    public Employee getSource() {
        return null;
    }

}
