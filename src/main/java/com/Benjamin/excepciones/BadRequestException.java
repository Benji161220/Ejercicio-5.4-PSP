package com.Benjamin.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class BadRequestException extends Exception {
    public BadRequestException() {
        super("Usuario o contraseña incorrectos");
    }
}
