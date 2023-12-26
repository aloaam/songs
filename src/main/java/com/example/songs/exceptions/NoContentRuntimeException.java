package com.example.songs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentRuntimeException extends RuntimeException {

    public NoContentRuntimeException(String message) {
        super(message);
    }
}
