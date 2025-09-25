package com.ashar.profileManager.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorResponseMessage{

    private String reason;
    private String message;

}
