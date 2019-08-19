package ru.javawebinar.topjava.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ValidationFieldsException extends RuntimeException {

    public ValidationFieldsException(BindingResult bindingResult) {
        super(getDescription(bindingResult));

    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    private static String getDescription(BindingResult bindingResult) {
        StringBuilder stringBuilder = new StringBuilder();
        bindingResult.getFieldErrors().forEach(
                fieldError -> stringBuilder.append(fieldError.getField())
                        .append(" ")
                        .append(fieldError.getDefaultMessage())
                        .append("<br>")
        );
        return stringBuilder.toString();
    }
}
