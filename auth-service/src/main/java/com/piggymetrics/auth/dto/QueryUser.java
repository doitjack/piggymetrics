package com.piggymetrics.auth.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryUser implements Serializable {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean enabled;
}
