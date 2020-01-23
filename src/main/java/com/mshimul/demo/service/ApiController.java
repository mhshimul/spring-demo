package com.mshimul.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class ApiController {

    @RequestMapping(
            path = "/name",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse getFullName(@RequestBody ApiRequest apiRequest) {
        log.info("{}", apiRequest);
        String fullName = apiRequest.getFirstName() + " " + apiRequest.getMiddleName() + " " + apiRequest.getLastName();
        return new ApiResponse(fullName);
    }
}
