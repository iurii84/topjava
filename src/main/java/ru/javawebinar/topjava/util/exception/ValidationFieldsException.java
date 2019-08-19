package ru.javawebinar.topjava.util.exception;

import org.springframework.validation.BindingResult;

public class ValidationFieldsException extends RuntimeException {
    public ValidationFieldsException(BindingResult bindingResult) {
        super(getDescription(bindingResult));

    }

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
