package com.spring.boot.bff.web.app.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class erroDTO {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
