package hu.nje.naplo.controller.exceptions;

import org.slf4j.helpers.MessageFormatter;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message, Object... data) {
        super(MessageFormatter.arrayFormat(message, data).getMessage());
    }
}
