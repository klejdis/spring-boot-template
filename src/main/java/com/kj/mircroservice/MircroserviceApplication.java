package com.kj.mircroservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Microservice API", version = "1.0",
		description = "Microservice API")

)
public class MircroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircroserviceApplication.class, args);
	}

}
