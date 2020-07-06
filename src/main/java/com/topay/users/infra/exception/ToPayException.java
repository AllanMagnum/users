package com.topay.users.infra.exception;

/**
 * Class comments go here...
 *
 * @author Allan Magnum Melo de Mendonça
 * @version 1.0 08/08/2019
 */
public abstract class ToPayException extends RuntimeException {

    protected ToPayException(final String message) {
        super(message);
    }

    protected ToPayException(final String message, final Throwable cause) {
        super(message, cause);
    }

}

