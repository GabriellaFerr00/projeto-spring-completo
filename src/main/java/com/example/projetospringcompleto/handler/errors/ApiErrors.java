package com.example.projetospringcompleto.handler.errors;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiErrors {
    private String title;
    private long status;
    private String details;
    private LocalDateTime timestamp;
    private String cause;
}
