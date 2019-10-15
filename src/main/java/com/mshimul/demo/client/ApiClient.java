package com.mshimul.demo.client;

import com.mshimul.demo.service.ApiRequest;
import com.mshimul.demo.service.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ApiClient {

    private final RequestFactory requestFactory;

    @Autowired
    public ApiClient(RequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }

    public void callApi() {
        RestTemplate restTemplate = requestFactory.getRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<ApiResponse> responseEntity = restTemplate.exchange("http://localhost:8080/api/name",
                HttpMethod.POST, new HttpEntity<>(new ApiRequest("Monzurul", "Haque", "Shimul"), headers), ApiResponse.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ApiResponse response = responseEntity.getBody();
            assert response != null;
            log.info("FullName: {}", response.getFullName());
        }
    }
}
