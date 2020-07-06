package com.topay.users.domain.employee;

import com.topay.users.infra.exception.ToPayException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class comments go here...
 *
 * @author Allan MAgnum
 * @version 1.0 03/05/2020
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends ToPayException {

    public EmployeeNotFoundException(final String message) {
        super(message);
    }

}
