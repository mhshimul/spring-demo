package com.mshimul.demo.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiRequest {
    private String firstName;
    private String middleName;
    private String lastName;
}
