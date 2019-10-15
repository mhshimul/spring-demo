package com.mshimul.demo;

import com.mshimul.demo.client.ApiClient;
import com.mshimul.demo.client.RequestFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ApiClient client = new ApiClient(new RequestFactory());
		client.callApi();
	}

}
