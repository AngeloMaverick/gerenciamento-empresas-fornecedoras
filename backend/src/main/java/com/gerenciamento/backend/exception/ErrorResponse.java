package com.gerenciamento.backend.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private List<ValidationError> errors;
    private LocalDateTime timestamp;
}
