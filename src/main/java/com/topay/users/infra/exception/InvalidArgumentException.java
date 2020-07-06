package com.topay.users.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class comments go here...
 *
 * @author Allan Magnum Mello de Mendonça
 * @version 1.0 22/06/2019
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid parameter")
public class InvalidArgumentException extends ToPayException {

    public InvalidArgumentException(final String message) {
        super(message);
    }

}
